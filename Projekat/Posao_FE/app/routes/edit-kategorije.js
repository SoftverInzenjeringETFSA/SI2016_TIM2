import Ember from 'ember';

export default Ember.Route.extend({
	kategorijaService: Ember.inject.service('kategorija-service'),
	session: Ember.inject.service('session'),

	beforeModel: function(transition) {
		//console.log(this.get('session.data.authenticated.role'));
		//console.log(this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC");
		//console.log((!this.get('session.isAuthenticated' || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ))));

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_ADMIN" )) {
			return this.transitionTo("unauthorized");
		}
	},

	model: function(params, transition) {
		return Ember.RSVP.hash({
			kategorije: this.get('kategorijaService').all(),

    	})
	}
});
