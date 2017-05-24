import Ember from 'ember';
import Izvjestaj from '../models/izvjestaj';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    izvjestajService: Ember.inject.service('izvjestaj-service'),
	session: Ember.inject.service(),
    modalClass: "modal fade",
    modalStyle: "display:hidden",
    izvjestaj: Izvjestaj.create({}),

	update: function(korisnik, id) {
        this.get('korisnikService').update(korisnik, id);
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
			this.update(korisnik, korisnik.idKorisnika);
    	},

        delete: function(){
            let korisnikId = this.get("session.data.authenticated.userid");
            console.log("korisnikId");
            console.log(korisnikId);

            if (this.delete(korisnikId)){
                this.get('session').invalidate();
                this.transitionToRoute('index');
            }
        },

        sakrijModal: function(){
            this.set("modalClass", "modal fade");
            this.set("modalStyle", "display:none");
            this.set("izvjestaj", {brojOglasa: "", brojUspjesnihOglasa: "", brojKorisnika: ""});
        },

        report: function(){
            this.set("modalClass", "modal fade in");
            this.set("modalStyle", "display:block");

            this.getReport();
        },
    }
});