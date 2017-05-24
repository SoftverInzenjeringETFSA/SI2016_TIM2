import Ember from 'ember';

export default Ember.Controller.extend({
	kategorijaService: Ember.inject.service('kategorija-service'),
    noviNaziv: "",

	add: function(kategorija) {
        this.get('kategorijaService').add(kategorija);
    },

    izmijeni: function(kategorija) {

        this.get('kategorijaService').update(kategorija, kategorija.id);
        //this.set("model.kategorije", )
    },

    brisi: function(kategorija, index) {
        this.get('kategorijaService').delete(kategorija.id);

        let _kategorije = this.get("model.kategorije");

        this.set("model.kategorije", [..._kategorije.slice(0, index), ..._kategorije.slice(index + 1)]);
    },

    actions: {
    	add: function(){
			let _kategorija = {naziv: this.get("noviNaziv")};
			this.add(_kategorija);
    	}, 

        izmijeni: function(index){
            let _kategorije = this.get("model.kategorije");
            //let kategorija = _kategorije.find(x => x.get("id") == id);
            let kategorija = _kategorije[index];
            this.izmijeni(kategorija);
        },

        brisi: function(index){
            let _kategorije = this.get("model.kategorije");
            //let kategorija = _kategorije.find(x => x.get("id") == id);
            let kategorija = _kategorije[index];
            this.brisi(kategorija, index);
        }
    }
});