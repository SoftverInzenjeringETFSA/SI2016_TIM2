import Ember from 'ember';

export default Ember.Route.extend({

	oglasiService: Ember.inject.service(),

		model: function(params, transition) {
        return Ember.RSVP.hash({
            oglasi: this.get('oglasiService').all()
        });
	}
});
