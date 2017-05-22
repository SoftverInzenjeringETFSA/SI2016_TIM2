import Ember from 'ember';

export default Ember.Route.extend({
	korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service('session'),

	model: function(params, transition) {
		let username = this.get("session.data.authenticated.username");
		let _profil = this.get('korisnikService').profil(username);
		console.log("test: "); + _profil;
		console.log(_profil);

	
		return Ember.RSVP.hash({
        	profil: _profil
    	})
	}
})
