import Ember from 'ember';

export default Ember.Route.extend({
	templateService: Ember.inject.service('template-service'),
	kategorijaService: Ember.inject.service(),
	lokacijaService: Ember.inject.service(),
	session: Ember.inject.service('session'),

	beforeModel: function(transition) {
		//console.log(this.get('session.data.authenticated.role'));
		//console.log(this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC");
		//console.log((!this.get('session.isAuthenticated' || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ))));

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" )) {
			return this.transitionTo("error");
		}
	},

	model: function(params, transition) {
		return Ember.RSVP.hash({
        	templatei: this.get("templateService").all(),
	        lokacije: this.get('lokacijaService').all(),
			kategorije: this.get('kategorijaService').all(),

    	})
	}
});
