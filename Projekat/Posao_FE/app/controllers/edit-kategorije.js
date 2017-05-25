import Ember from 'ember';

export default Ember.Controller.extend({
    kategorijaService: Ember.inject.service('kategorija-service'),
    noviNaziv: "",
    noviNazivError: false,

    add: function(kategorija) {
        this.get('kategorijaService').add(kategorija).then(x => {}).catch(x => {});
    },

    izmijeni: function(kategorija) {

        this.get('kategorijaService').update(kategorija, kategorija.id).then(x => {}).catch(x => {});
        //this.set("model.kategorije", )
    },

    brisi: function(kategorija, index) {
        var self = this;

        this.get('kategorijaService').delete(kategorija.id).then(x => {
                    let _kategorije = this.get("model.kategorije");
                    this.set("model.kategorije", [..._kategorije.slice(0, index), ..._kategorije.slice(index + 1)]);
                    //ispis poruke
        }).catch(err => {});


    },

    validirajNovu: function(){

        let uspjesno = true;
        let _noviNazivError = false;

        if (this.get('noviNaziv') ==  "") {

            _noviNazivError = true;
            uspjesno = false;
        } 

        this.set("noviNazivError", _noviNazivError);

        return uspjesno;
    },

    validirajIzmjenu: function(){
        return true;
    },


    actions: {
        add: function(){

            if (this.validirajNovu()) {
                
                let _kategorija = {naziv: this.get("noviNaziv")};
                this.add(_kategorija);
            }

        }, 

        izmijeni: function(index){
            let _kategorije = this.get("model.kategorije");
            let kategorija = _kategorije[index];
            this.izmijeni(kategorija);
        },

        brisi: function(index){
            let _kategorije = this.get("model.kategorije");
            let kategorija = _kategorije[index];
            this.brisi(kategorija, index);
        }
    }
});