import Ember from 'ember';

export default Ember.Route.extend({
	oglasiService: Ember.inject.service(),
	session: Ember.inject.service(),


	beforeModel: function(transition) {
		//console.log(this.get('session.data.authenticated.role'));
		//console.log(this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC");
		//console.log((!this.get('session.isAuthenticated' || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ))));

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" )) {
			return this.transitionTo("error");
		}
	},

	model: function(params, transition) {
		let id = this.get('session.data.authenticated.userid');
		let _oglasi = this.get('oglasiService').my(id);

	    return Ember.RSVP.hash({
	        oglasi: _oglasi,
	    });
	},	
});
