import Ember from 'ember';

export default Ember.Route.extend({
	porukeService: Ember.inject.service('poruke-service'),
	korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service('session'),

	profil: {},

	model: function(params, transition) {
		let userid = this.get("session.data.authenticated.userid");
		console.log(this.get("session"));
		console.log("userid");
		console.log(userid);

		let _poruke = this.get("porukeService").all(userid);

		return Ember.RSVP.hash({
        	poruke: _poruke
    	})
	}

});
