import Ember from 'ember';

export default Ember.Route.extend({

	beforeModel: function(transition) {

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_ADMIN" )) {
			return this.transitionTo("unauthorized");
		}
	},

	model: function(params, transition){
		let _template= {};
		_template.naziv = "";
		_template.poljaTemplatea = [];

		return Ember.RSVP.hash({
        	template: _template
    	})
	}

});
