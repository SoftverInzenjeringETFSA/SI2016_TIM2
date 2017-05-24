import Ember from 'ember';

export default Ember.Controller.extend({
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service(),

	prijava: function(korisnik, oglas) {
        this.get('oglasiService').prijava(korisnik, oglas);
    },

    delete: function(oglasId) {
        return this.get('oglasiService').delete(oglasId);
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
    	}
    }
});