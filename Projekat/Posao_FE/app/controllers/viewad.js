import Ember from 'ember';

export default Ember.Controller.extend({
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service(),
    noviDatumIsteka: null,
    prijavaSuccess: false,
    prijavaError: false,

	prijava: function(korisnik, oglas) {
        return this.get('oglasiService').prijava(korisnik, oglas).then(x => {this.set("prijavaSuccess", true); this.set("model.imaprijava", true)}).catch(err => {this.set("prijavaSuccess", false)});
    },

    delete: function(oglasId) {
        return this.get('oglasiService').delete(oglasId);
    },

    zatvori: function(oglasId) {
        return this.get('oglasiService').zatvori(oglasId);
    },

    reopen: function(oglasId) {
        this.get('oglasiService').reopen(oglasId).then();
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