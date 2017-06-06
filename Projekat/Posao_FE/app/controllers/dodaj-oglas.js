import Ember from 'ember';

export default Ember.Controller.extend({
    templateService: Ember.inject.service('template-service'),
	oglasiService: Ember.inject.service('oglasi-service'),
	session: Ember.inject.service('session'),
    kategorija: null,
    lokacija: null,
    template: null,
    trajanje: null,
    naziv: "",
    opis: "",
    polja: [],
    kategorijaError: false,
    lokacijaError: false,
    templateError: false,
    datumError: false,
    nazivError: false,
    opisError: false,
    poljaError: false,
    serverError: false,
    serverErrorText: "",
    serverSuccess: false,

    validacija: function(){

        let ispravno = true;

        let _kategorijaError = false;
        let _lokacijaError = false;
        let _templateError = false;
        let _datumError = false;
        let _nazivError = false;
        let _opisError = false;
        let _poljaError = false;

        if (this.get("kategorija") == null){
            ispravno = false;
            _kategorijaError = true;
        }

        if (this.get("lokacija") == null){
            ispravno = false;
            _lokacijaError = true;
        }


        //suvišno?

        //if (this.get("template") == null){
        //    ispravno = false;
        //    _templateError = true;
        //}

        if (this.get("trajanje") == null || Number.parseInt(this.get('trajanje')) < 1){
            ispravno = false;
            _datumError = true;
        }

        if (this.get("naziv") == ""){
            ispravno = false;
            _nazivError = true;
        }

        if (this.get("opis") == ""){
            ispravno = false;
            _opisError = true;
        }

        this.get("polja").forEach(polje => {
            if(polje.vrijednost == null || polje.vrijednost === ""){
                ispravno = false;
                _poljaError = true;
            }
        });

        this.set("kategorijaError", _kategorijaError);
        this.set("templateError", _templateError);
        this.set("lokacijaError", _lokacijaError);
        this.set("datumError", _datumError);
        this.set("nazivError", _nazivError);
        this.set("opisError", _opisError);
        this.set("poljaError", _poljaError);

        return ispravno;
    },

	register: function(){
        this.set("serverErrorText", "");

		let oglas = {};
        var self = this;
		oglas.poslodavacId = this.get("session.data.authenticated.userid");
		oglas.lokacija = this.get("lokacija");

		oglas.kategorije = this.get("kategorija");

		//hardkodirano
		oglas.sakriven = "0";
        oglas.oglasPrijave = new Array();

		oglas.zatvoren = "0";
		oglas.uspjesan = "0";
		oglas.prioritet = "0";

		oglas.naziv = this.get("naziv");
		oglas.opis = this.get("opis");
		oglas.oglasPodaci = this.get("polja");
		oglas.datumIsteka = null;
        var trajanjeOglasa = Number.parseInt(this.get("trajanje"));
        var trajanjeOglasa = this.get("trajanje");
        oglas.vrijemeTrajanja = trajanjeOglasa;

        //this.get("oglasiService").postavi(oglas, trajanjeOglasa).then(x => {
		this.get("oglasiService").postavi(oglas).then(x => {
            self.set("serverSuccess", true);
            self.set("serverError", false);
            self.set("serverErrorText", "");

        }).catch(err => {
            self.set("serverSuccess", false);
            self.set("serverError", true);
            self.set("serverErrorText", err.responseText);

        });


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

      		this.set('lokacija', _lokacija);
    	},

    	register() {
            if (this.validacija()){
                this.register();
            }
    	},

    	selectTemplate(templateId) {
    		let templatei = this.get("model.templatei");
    		let template =templatei.find(x => x.get("id") == templateId);
            var _polja = [];
            if (template){
                _polja = new Array(template.poljaTemplatea.length);

        		for (let i = 0; i < template.poljaTemplatea.length; i++) {
        			_polja[i] = {vrijednost: ""};
      				_polja[i].staje = template.poljaTemplatea[i].nazivPolja;
                }
            }
    		this.set("polja", _polja.slice());

      		this.set('template', template);
    	},
	}
});