import Ember from 'ember';

export default Ember.Route.extend({
	porukeService: Ember.inject.service('poruke-service'),
	korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service('session'),

	profil: {},

	beforeModel: function(transition) {
		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ) && (this.get('session.data.authenticated.role') !== "ROLE_NEZAPOSLENI" )) {
			return this.transitionTo("unauthorized");
		}
		this.set("session.imaNeprocitanih", false);
	},

	model: function(params, transition) {
		let userid = this.get("session.data.authenticated.userid");
		let _poruke = this.get("porukeService").all(userid);

		return Ember.RSVP.hash({
        	poruke: _poruke
    	})
	}

});
