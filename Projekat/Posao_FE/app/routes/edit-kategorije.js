import Ember from 'ember';

export default Ember.Route.extend({
	kategorijaService: Ember.inject.service('kategorija-service'),
	session: Ember.inject.service('session'),

	model: function(params, transition) {
		return Ember.RSVP.hash({
			kategorije: this.get('kategorijaService').all(),

    	})
	}
});
