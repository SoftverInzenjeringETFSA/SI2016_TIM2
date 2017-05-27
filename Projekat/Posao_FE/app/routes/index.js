import Ember from 'ember';
import $ from 'jquery';

export default Ember.Route.extend({

	oglasiService: Ember.inject.service(),
	kategorijaService: Ember.inject.service(),
	lokacijaService: Ember.inject.service(),
	session: Ember.inject.service(),

	model: function(params, transition) {
		let _kategorije = this.get('kategorijaService').all();

	    return Ember.RSVP.hash({
	        oglasi: this.get('oglasiService').all(),
	        lokacije: this.get('lokacijaService').all(),
	        kategorije: _kategorije
	    });
	}
});
