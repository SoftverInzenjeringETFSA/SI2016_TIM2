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
		
		//email unicode
		let re1 = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

		if (this.get("tip") == null){
			console.log("validiram");
			console.log(this.get("tip"));

			ispravno = false;
			_tipError = true;
		}
		
		if (this.get("username") == null || this.get("username").length < 1){
			ispravno = false;
			_usernameError = true;
			this.set("imeVarijable", "Polje mora sadržavati više od 0 katraktera!");
		}

		if (this.get("password") == null || this.get("password").length < 6){
			ispravno = false;
			_passwordError = true;
		}

		
		if (this.get("email") == null || !re1.test(this.get("email"))){
			ispravno = false;
			_emailError = true;
		}


		if (!_tipError && this.get("tip") == "Nezaposleni")
		{
			if (this.get("cv") == null || this.get("cv").length < 50 ){
				ispravno = false;
				_cvError = true;
			}
		}

		if (!_tipError && this.get("tip") == "Poslodavac")
		{
			if (this.get("telefon") == null || !this.get("telefon").match(/^\d{9}$/)){
				ispravno = false;
				_telefonError = true;
			}

			if (this.get("nazivFirme") == null || this.get("nazivFirme").length < 1 /*|| !re2.test(this.get("nazivFirme"))*/){
				ispravno = false;
				_firmaError = true;
			}
		}

		if (this.get("ime") == null || this.get("ime").length > 15 || this.get("ime").length < 1 /*|| !re3.test(this.get("ime"))*/){
			ispravno = false;
			_imeError = true;
		}

		if (this.get("prezime") == null || this.get("prezime").length > 30 || this.get("prezime").length < 1 /*|| !re3.test(this.get("prezime"))*/){
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

		return ispravno;

	},

	register: function(korisnik) {
		let self = this;

        this.get('korisnikService').register(korisnik).then(data => self.set("serverSuccess", true)).catch(err => self.set("serverError", true));
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