import Ember from 'ember';

export default Ember.Controller.extend({
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service(),

	prijava: function(korisnik, oglas) {
        return this.get('oglasiService').prijava(korisnik, oglas).then(x => {}).catch(err => {});
    },

    delete: function(oglasId) {
        return this.get('oglasiService').delete(oglasId);
    },

    zatvori: function(oglasId) {
        return this.get('oglasiService').zatvori(oglasId);
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
    }
});