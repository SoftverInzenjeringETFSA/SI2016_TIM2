import Ember from 'ember';

export default Ember.Route.extend({
	model: function(params, transition){
		let _template= {};
		_template.naziv = "";
		_template.poljaTemplatea = [];

		return Ember.RSVP.hash({
        	template: _template
    	})
	}

});
