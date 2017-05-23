import Ember from 'ember';

export default Ember.Controller.extend({
    session: Ember.inject.service('session'),
    collapsedBool: false,
	collapsedStr: "collapse navbar-collapse",

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

        collapse: function(){
            let col = !this.get("collapsedBool");

            this.set("collapsedBool", col);

            if(col){
                this.set("collapsedStr", "collapse navbar-collapse in");
            }
            else{
                this.set("collapsedStr", "collapse navbar-collapse");
            }
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