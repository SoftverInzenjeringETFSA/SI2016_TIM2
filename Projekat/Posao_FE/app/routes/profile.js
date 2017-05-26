import Ember from 'ember';

export default Ember.Route.extend({
	korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service('session'),

	beforeModel: function(transition) {

		if(!this.get('session.isAuthenticated')) {
			return this.transitionTo("unauthorized");
		}
	},


	model: function(params, transition) {
		let username = this.get("session.data.authenticated.username");
		let _profil = this.get('korisnikService').profil(username);
	
		return Ember.RSVP.hash({
        	profil: _profil,
    	})
	}
})
