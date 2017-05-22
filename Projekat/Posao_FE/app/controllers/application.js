import Ember from 'ember';

export default Ember.Controller.extend({
	session: Ember.inject.service('session'),

	authenticate: function(credentials) {
        var authenticator = 'authenticator:jwt';
        return this.get('session').authenticate(authenticator, credentials);
    },

	actions: {
		 login: function(credentials, doRedirect) {
            var self = this;
            this.authenticate(credentials).then(function(value) {
                console.log(self.get("session.data"));

                if(doRedirect) {
                    self.transitionToRoute('index');
                }
                //this.errorMessage = "Uspješan login!";
            }.bind(doRedirect), function(reason) {
            	//self.errorMessage = "op";
                self.transitionToRoute('registracija');

                //this.errorMessage = "Pogrešni kredencijali.";
            });
        },

        loginNormal: function() {
        	console.log("test");
            var credentials = this.getProperties('identification', 'password');
            this.send('login', credentials, true);
        },

        loginWithoutRedirect: function(credentials) {
            this.send('login', credentials, false);
        },

		logout(){
			this.get('session').invalidate();
		}
	}
});