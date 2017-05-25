import Ember from 'ember';

export default Ember.Route.extend({
	korisnikService: Ember.inject.service('korisnik-service'),
	model: function(params, transition) {
		return Ember.RSVP.hash({
			korisnici: this.get("korisnikService").nezaposleni()
		});
	}
});
