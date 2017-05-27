import Ember from 'ember';

export default Ember.Route.extend({

	korisnikService: Ember.inject.service('korisnik-service'),

	beforeModel: function(transition) {
		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" )) {
			return this.transitionTo("unauthorized");
		}
	},

	model: function(params, transition) {
		return Ember.RSVP.hash({
			korisnici: this.get("korisnikService").nezaposleni()
		});
	}
});
