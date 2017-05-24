import Ember from 'ember';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service(),

	update: function(korisnik, id) {
        this.get('korisnikService').update(korisnik, id);
    },

    delete: function(korisnikId){
        return this.get('korisnikService').delete(korisnikId);
    },

    actions: {
    	update: function(){
			let korisnik = this.get('model.profil');
			this.update(korisnik, korisnik.idKorisnika);
    	},

        delete: function(){
            let korisnikId = this.get("session.data.authenticated.userid");

            if (this.delete(korisnikId)){
                this.get('session').invalidate();
                this.transitionToRoute('index');
            }
        }
    }
});