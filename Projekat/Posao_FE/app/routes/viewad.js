import Ember from 'ember';

export default Ember.Route.extend({
	oglasiService: Ember.inject.service(),
	session: Ember.inject.service(),

	model: function(params, transition) {
		let _userid = this.get("session.data.authenticated.userid");
        let _role = this.get("session.data.authenticated.role");
       
       var _imaprijava = null;

        if (_role === "ROLE_NEZAPOSLENI"){
            _imaprijava = this.get('oglasiService').imaprijava(_userid, params.id)
        }

    	return Ember.RSVP.hash({
        	oglas: this.get('oglasiService').details(params.id),
        	userid: Number.parseInt(_userid),
        	imaprijava: _imaprijava,
    	});
	},
});
