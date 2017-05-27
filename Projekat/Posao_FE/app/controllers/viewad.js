import Ember from 'ember';

export default Ember.Controller.extend({
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service(),
    noviDatumIsteka: null,
    prijavaSuccess: false,
    prijavaError: false,
    reopenSuccess: false,
    reopenError: false,

	prijava: function(korisnik, oglas) {
        var self = this;

        return this.get('oglasiService').prijava(korisnik, oglas).then(x => {
            self.set("prijavaSuccess", true);
            self.set("prijavaError", false);
            self.set("model.imaprijava", true)}).catch(err => {
                self.set("prijavaSuccess", false);
                self.set("prijavaError", true);
            });
    },

    delete: function(oglasId) {
        return this.get('oglasiService').delete(oglasId);
    },

    zatvori: function(oglasId) {
        return this.get('oglasiService').zatvori(oglasId);
    },

    reopen: function(oglasId, brojDana) {
        var self = this;
        this.get('oglasiService').reopen(oglasId, brojDana).then(x => {
            self.set("prijavaSuccess", true);
            self.set("prijavaError", false);
            self.set("datumError", false);
        }).catch(err => {
            self.set("prijavaError", true);
            self.set("prijavaSuccess", false);
            self.set("datumError", false);
        });
    },

    actions: {
    	prijava: function(oglasId){
			let korisnikId = this.get("session.data.authenticated.userid");
			this.prijava(korisnikId, oglasId);
    	},

    	delete: function(){
		    let oglasId = this.get("model.oglas.idOglasa");
            this.delete(oglasId).then(x => {
                this.transitionToRoute('index');
            });
    	},

        zatvori: function(){
            let oglasId = this.get("model.oglas.idOglasa");
            this.zatvori(oglasId).then(x => {
                this.set('model.oglas.zatvoren', 1);
            });
        },

        reopen: function(){
            let oglasId = this.get("model.oglas.idOglasa");
            let noviDatum = this.get("noviDatumIsteka");
            this.reopen(oglasId, noviDatum);
        },
    }
});