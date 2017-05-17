import Ember from 'ember';

export default Ember.Route.extend({
	oglasiService: Ember.inject.service(),

	model: function(params, transition) {
    	return Ember.RSVP.hash({
        	oglas: this.get('oglasiService').details(params.id)
    	});
	}
});
