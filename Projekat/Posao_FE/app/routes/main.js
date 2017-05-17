import Ember from 'ember';

export default Ember.Route.extend({

	oglasiService: Ember.inject.service(),

		model: function(params, transition) {
        return Ember.RSVP.hash({
            oglasi: this.get('oglasiService').all()
        });

		//return this.get('store').findAll('oglas');/*{
		/*	oglasi: [{
				naziv: 'sekretar',
				poslodavac: 'firma1',
				datum: '20.5.2017.'
				},
				{
				naziv: 'TEST',
				poslodavac: 'firma2',
				datum: '24.5.2017.'
				},
			],
		};*/
	}
});
