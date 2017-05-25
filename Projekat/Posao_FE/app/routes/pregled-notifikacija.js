import Ember from 'ember';

export default Ember.Route.extend({
	porukeService: Ember.inject.service('poruke-service'),
	korisnikService: Ember.inject.service('korisnik-service'),
	session: Ember.inject.service('session'),

	profil: {},

	beforeModel: function(transition) {
		//console.log(this.get('session.data.authenticated.role'));
		//console.log(this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC");
		//console.log((!this.get('session.isAuthenticated' || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ))));

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ) && (this.get('session.data.authenticated.role') !== "ROLE_NEZAPOSLENI" )) {
			return this.transitionTo("error");
		}
	},

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
