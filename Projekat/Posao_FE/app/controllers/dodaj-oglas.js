import Ember from 'ember';

export default Ember.Controller.extend({
    templateService: Ember.inject.service('template-service'),
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service('session'),
    kategorija: null,
    lokacija: null,
    template: null,
    datum: null,
    naziv: "",
    opis: "",
    polja: [],

	addOglas: function(oglas){
		this.get("oglasiService").add(oglas);
	},

	register: function(){
		let oglas = {};
		oglas.poslodavacId = this.get("session.data.authenticated.userid");
		oglas.lokacija = this.get("lokacija");

		oglas.kategorije = this.get("kategorija");
		console.log("kategorija");
		console.log(oglas);
		//hardkodirano
		oglas.sakriven = "0";
        oglas.oglasPrijave = new Array();

		oglas.zatvoren = "0";
		oglas.uspjesan = "0";
		oglas.prioritet = "0";

		oglas.naziv = this.get("naziv");
		oglas.opis = this.get("opis");
		oglas.oglasPodaci = this.get("polja");
		oglas.datumIsteka = this.get("datum");

		this.get("oglasiService").postavi(oglas);


	},

    actions: {
	    selectKategorija(kategorijaId) {
    		let kategorije = this.get("model.kategorije");
    		let _kategorija = kategorije.find(x => x.get("id") == kategorijaId);

      		this.set('kategorija', _kategorija);
    	},

	    selectLokacija(lokacijaId) {
    		let lokacije = this.get("model.lokacije");
    		let _lokacija = lokacije.find(x => x.get("id") == lokacijaId);
			console.log(_lokacija);


      		this.set('lokacija', _lokacija);
    	},

    	register() {
    		console.log("hmm");
      		this.register();
    	},

    	selectTemplate(templateId) {
    		let templatei = this.get("model.templatei");
    		let template =templatei.find(x => x.get("id") == templateId);
    		let _polja = new Array(template.poljaTemplatea.length);
    		
    		for (let i = 0; i < template.poljaTemplatea.length; i++) {
    			_polja[i] = {vrijednost: ""};
  				_polja[i].staje = template.poljaTemplatea[i].nazivPolja;
			}
    		this.set("polja", _polja.slice());
    		console.log("polja");
    		console.log(this.get("polja"));

      		this.set('template', template);
    	},
	}
});