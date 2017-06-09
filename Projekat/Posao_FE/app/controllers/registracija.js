import Ember from 'ember';

export default Ember.Controller.extend({
	korisnikService: Ember.inject.service('korisnik-service'),
	usernameError: false,
	passwordError: false,
	emailError: false,
	telefonError: false,
	imeError: false,
	prezimeError: false,
	firmaError: false,
	cvError: false,
	tipError: false,
	serverSuccess: false,
	serverError: false,
	serverErrorText: "",
	ponovljeniPass: "",
	ponovljeniPassError: false,


	validiraj: function(){


		let ispravno = true;

		let _usernameError = false;
		let _passwordError = false;
		let _emailError = false;
		let _telefonError = false;
		let _imeError = false;
		let _prezimeError = false;
		let _firmaError = false;
		let _cvError = false;
		let _tipError = false;
		let _ponovljeniPassError = false;
		
		//email unicode
		let re1 = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;

		if (this.get("tip") == null){
			ispravno = false;
			_tipError = true;
		}
		
		if (this.get("username") == null || this.get("username").length < 1 || !this.get("username").match(/^[0-9a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-_\.]{2,30}$/i)){
			ispravno = false;
			_usernameError = true;
			this.set("imeVarijable", "Korisničko ime se može sastojati samo od slova, brojeva i znakova . _ -!");
		}
		else{
			this.set("imeVarijable", "");
		}


		if (this.get("password") == null || this.get("password").length < 6 || !this.get("password").match(/^[0-9a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\_\+\-\*\:\.\,\;\?\!\$\#]{6,30}$/gi)){
			ispravno = false;
			_passwordError = true;
		}

		if (!_passwordError)
		{
			if (this.get("ponovljeniPass") == null || (this.get("ponovljeniPass") !== this.get("password")))
			{
					ispravno = false;
					_ponovljeniPassError = true;				
			}
		}
		
		if (this.get("email") == null || !re1.test(this.get("email"))){
			ispravno = false;
			_emailError = true;
		}


		if (!_tipError && this.get("tip") == "Nezaposleni")
		{
			if (this.get("cv") == null || this.get("cv").length < 50 || !this.get("cv").match(/^[0-9a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\ \_\+\-\*\:\.\,\;\?\!\$\#\(\)\[\]\{\}\=\@]{1,500}$/im)){
				ispravno = false;
				_cvError = true;
			}
		}

		if (!_tipError && this.get("tip") == "Poslodavac")
		{
	        if (this.get("telefon") == null || (!this.get("telefon").match(/^\d{9}$/) && !this.get("telefon").match(/^\d{8}$/))){
                ispravno = false;
                _telefonError = true;
            }


			if (this.get("nazivFirme") == null || this.get("nazivFirme").length < 1 || !this.get("nazivFirme").match(/^[0-9a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-_\.]{2,30}$/i)){
				ispravno = false;
				_firmaError = true;
			}
		}

		if (this.get("ime") == null || this.get("ime").length > 15 || this.get("ime").length < 1 || !this.get("ime").match(/^[a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-]{2,30}$/i)){
			ispravno = false;
			_imeError = true;
		}

		if (this.get("prezime") == null || this.get("prezime").length > 30 || this.get("prezime").length < 1 || !this.get("prezime").match(/^[a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-]{2,30}$/i)){
			ispravno = false;
			_prezimeError = true;
		}

		this.set("usernameError", _usernameError);
		this.set("passwordError", _passwordError);		
		this.set("emailError", _emailError);
		this.set("telefonError", _telefonError);
		this.set("imeError", _imeError);
		this.set("prezimeError", _prezimeError);
		this.set("firmaError", _firmaError);
		this.set("cvError", _cvError);
		this.set("firmaError", _firmaError);
		this.set("tipError", _tipError);
		this.set("ponovljeniPassError", _ponovljeniPassError);

		return ispravno;

	},

	register: function(korisnik) {
		var self = this;
		this.set("serverErrorText", "");

        this.get('korisnikService').register(korisnik).then(data => {
        	self.set("serverSuccess", true);
        	self.set("serverError", false);
			self.set("serverErrorText", "");

        }).catch(err => {
        	self.set("serverError", true);
        	self.set("serverSuccess", false);
			self.set("serverErrorText", err.responseText);

        });
    },

    actions: {
    	register: function(){
			let korisnik = this.getProperties('username', 'password', 'email');
			
			if (this.getProperties('tip').tip === "Nezaposleni"){
				let nezaposleni = this.getProperties('ime', 'prezime', 'cv');
				//nezaposleni.cv = this.cv;
				nezaposleni.privatanProfil = 0; //trenutno hardkodirano, treba promijeniti
				korisnik.poslodavac = null;
				korisnik.admin = null;
				korisnik.nezaposleni = nezaposleni;
			}else if (this.getProperties('tip').tip === "Poslodavac"){
				let poslodavac = this.getProperties('ime', 'prezime', 'telefon', 'nazivFirme');
				poslodavac.skriveniPodaci = {};	//trenutno hardkodirano, treba promijeniti
				korisnik.nezaposleni = null;
				korisnik.admin = null;
				korisnik.poslodavac = poslodavac;
			}

			if (this.validiraj()){
				this.register(korisnik);
			}
    	}
    }
});