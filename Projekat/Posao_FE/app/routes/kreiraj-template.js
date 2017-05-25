import Ember from 'ember';

export default Ember.Route.extend({

	beforeModel: function(transition) {
		//console.log(this.get('session.data.authenticated.role'));
		//console.log(this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC");
		//console.log((!this.get('session.isAuthenticated' || (this.get('session.data.authenticated.role') !== "ROLE_POSLODAVAC" ))));

		if(!this.get('session.isAuthenticated') || (this.get('session.data.authenticated.role') !== "ROLE_ADMIN" )) {
			return this.transitionTo("error");
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
