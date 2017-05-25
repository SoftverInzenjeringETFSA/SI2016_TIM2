import Ember from 'ember';
import Izvjestaj from '../models/izvjestaj';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    izvjestajService: Ember.inject.service('izvjestaj-service'),
	session: Ember.inject.service(),
    modalClass: "modal fade",
    modalStyle: "display:hidden",
    izvjestaj: Izvjestaj.create({}),
    passwordError: false,
    emailError: false,
    telefonError: false,
    imeError: false,
    prezimeError: false,
    nazivFirmeError: false,
    cvError: false,


    validacija: function(){
        
        let uspjesno = true;

        let _passwordError = false;
        let _emailError = false;
        let _telefonError = false;
        let _imeError = false;
        let _prezimeError = false;
        let _nazivFirmeError = false;
        let _cvError = false;

        if (this.get("model.profil.password") == "") {
            _passwordError = true;
            uspjesno = false;
            console.log("Validiram password");
        }

        if (this.get("model.profil.email") == "") {
            _emailError = true;
            uspjesno = false;
            console.log("Validiram email");
        }

        if (this.get("model.profil.poslodavac.telefon") == "") {
            _telefonError = true;
            uspjesno = false;
            console.log("Validiram telefon");
        }

        if (this.get("model.profil.nezaposleni.ime") == "") {
            _imeError = true;
            uspjesno = false;
            console.log("Validiram ime");
        }

        if (this.get("model.profil.nezaposleni.prezime")) {
            _prezimeError = true;
            uspjesno = false;

            console.log("Validiram prezime");
        }

        if (this.get("model.profil.poslodavac.nazivFirme") == "") {
            _nazivFirmeError = true;
            uspjesno = false;

            console.log("Validiram imeFirme");
        }

        if (this.get("model.profil.nezaposleni.cv") == "") {
            _cvError = true;
            uspjesno = false;

            console.log("Validiram CV");
        }

        this.set("passwordError", _passwordError);
        this.set("emailError", _emailError);
        this.set("telefonError", _telefonError);
        this.set("imeError", _imeError);
        this.set("prezimeError", _prezimeError);
        this.set("nazivFirmeError", _nazivFirmeError);
        this.set("cvError", _cvError);

        return uspjesno;
    },

	update: function(korisnik, id) {
        this.get('korisnikService').update(korisnik, id).then(x => {}).catch(err => {});
    },

    delete: function(korisnikId){
        return this.get('korisnikService').delete(korisnikId);
    },

    getReport: function(){
        let _izvjestaj = this.get('korisnikService').izvjestaj();
        this.set("izvjestaj", _izvjestaj);
    },

    actions: {
    	update: function(){
			let korisnik = this.get('model.profil');

            if(this.validacija()){
                this.update(korisnik, korisnik.idKorisnika);
            }
    	},

        provjeri: function() {

            console.log(this.get("model.profil.poslodavac.telefon"));

        },


        delete: function(){
            let korisnikId = this.get("session.data.authenticated.userid");

            if (this.delete(korisnikId)){
                this.get('session').invalidate();
                this.transitionToRoute('index');
            }
        },

        sakrijModal: function(){
            this.set("modalClass", "modal fade");
            this.set("modalStyle", "display:none");
            this.set("izvjestaj", {brojOglasa: "", brojNezaposlenih: "", brojPoslodavaca: "", brojPrijava: ""});
        },

        report: function(){
            this.set("modalClass", "modal fade in");
            this.set("modalStyle", "display:block");

            this.getReport();
        },
    }
});