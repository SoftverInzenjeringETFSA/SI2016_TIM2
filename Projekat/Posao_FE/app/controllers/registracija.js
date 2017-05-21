import Ember from 'ember';

export default Ember.Controller.extend({
	registracijaService: Ember.inject.service(),

	register: function(korisnik) {
        this.get('registracijaService').register(korisnik);
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

			this.register(korisnik);
    	}
    }
});