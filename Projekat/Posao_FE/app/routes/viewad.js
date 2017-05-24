import Ember from 'ember';

export default Ember.Route.extend({
	oglasiService: Ember.inject.service(),
	session: Ember.inject.service(),

	model: function(params, transition) {
		let _userid = this.get("session.data.authenticated.userid");

    	return Ember.RSVP.hash({
        	oglas: this.get('oglasiService').details(params.id),
        	userid: Number.parseInt(_userid),

    	});
	}
});
