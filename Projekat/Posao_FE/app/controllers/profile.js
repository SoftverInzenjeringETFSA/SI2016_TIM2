import Ember from 'ember';

export default Ember.Controller.extend({
	korisnikService: Ember.inject.service('korisnik-service'),

	update: function(korisnik, id) {
        this.get('korisnikService').update(korisnik, id);
    },

    actions: {
    	update: function(){
			let korisnik = this.get('model.profil');
			console.log("korisnik: ");
			console.log(korisnik);
			console.log(korisnik.idKorisnika);
			this.update(korisnik, korisnik.idKorisnika);
    	}
    }
});