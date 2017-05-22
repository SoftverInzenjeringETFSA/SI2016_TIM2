import Ember from 'ember';

export default Ember.Route.extend({

	oglasiService: Ember.inject.service(),
	kategorijaService: Ember.inject.service(),
	lokacijaService: Ember.inject.service(),

		model: function(params, transition) {
		let _kategorije = this.get('kategorijaService').all();
		console.log(_kategorije);

        return Ember.RSVP.hash({
            oglasi: this.get('oglasiService').all(),
            lokacije: this.get('lokacijaService').all(),
            kategorije: _kategorije
        });
	}
});
