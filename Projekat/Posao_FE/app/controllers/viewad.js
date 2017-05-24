import Ember from 'ember';

export default Ember.Controller.extend({
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service(),

	prijava: function(korisnik, oglas) {
		console.log("ovdje");
		console.log(oglas);
        this.get('oglasiService').prijava(korisnik, oglas);
    },

    actions: {
    	prijava: function(oglasId){
			let korisnikId = this.get("session.data.authenticated.userid");
		    console.log(this.get("model.oglas.idOglasa"));
			this.prijava(korisnikId, oglasId);
    	}
    }
});