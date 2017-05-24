import Ember from 'ember';

export default Ember.Route.extend({
	oglasiService: Ember.inject.service(),
	session: Ember.inject.service(),

	model: function(params, transition) {
		let id = this.get('session.data.authenticated.userid');
		let _oglasi = this.get('oglasiService').my(id);

	    return Ember.RSVP.hash({
	        oglasi: _oglasi,
	    });
	},	
});
