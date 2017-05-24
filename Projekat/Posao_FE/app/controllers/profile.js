import Ember from 'ember';
import Izvjestaj from '../models/izvjestaj';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    izvjestajService: Ember.inject.service('izvjestaj-service'),
	session: Ember.inject.service(),
    modalClass: "modal fade",
    modalStyle: "display:hidden",
    izvjestaj: Izvjestaj.create({}),

    validacija: function(){
        return true;
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