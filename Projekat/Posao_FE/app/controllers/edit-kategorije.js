import Ember from 'ember';

export default Ember.Controller.extend({
    kategorijaService: Ember.inject.service('kategorija-service'),
    noviNaziv: "",
    noviNazivError: false,
    noviNError: false,
    indexGreske: null,
    noviServerError: false,
    noviServerErrorText: "",
    noviSuccess: false,

    izmjenaServerError: false,
    izmjenaServerErrorText: "",
    izmjenaSuccess: false,

    brisanjeServerError: false,
    brisanjeServerErrorText: "",
    brisanjeSuccess: false,

    add: function(kategorija) {
        var self = this;

        this.get('kategorijaService').add(kategorija).then(x => {
            self.set("noviServerError", false);
            self.set("noviServerErrorText", "");
            self.set("noviSuccess", true);
        }).catch(err => {
            self.set("noviServerError", true);
            self.set("noviServerErrorText", err.responseText);
            self.set("noviSuccess", false);
        });
    },

    izmijeni: function(kategorija) {
        var self = this;

        this.get('kategorijaService').update(kategorija, kategorija.id).then(x => {
            self.set("izmjenaServerError", false);
            self.set("izmjenaServerErrorText", "");
            self.set("izmjenaSuccess", true);
        }).catch(err => {
            self.set("izmjenaServerError", true);
            self.set("izmjenaServerErrorText", err.responseText);
            self.set("izmjenaSuccess", false);
        });
        //this.set("model.kategorije", )
    },

    brisi: function(kategorija, index) {
        var self = this;

        this.get('kategorijaService').delete(kategorija.id).then(x => {
                    let _kategorije = this.get("model.kategorije");
                    this.set("model.kategorije", [..._kategorije.slice(0, index), ..._kategorije.slice(index + 1)]);

                    self.set("izmjenaServerError", false);
                    self.set("izmjenaServerErrorText", "");
                    self.set("izmjenaSuccess", false);

                    self.set("brisanjeServerError", false);
                    self.set("brisanjeServerErrorText", "");
                    self.set("brisanjeSuccess", true);

                    //ispis poruke
        }).catch(err => {
                    self.set("izmjenaServerError", false);
                    self.set("izmjenaServerErrorText", "");
                    self.set("izmjenaSuccess", false);

                    self.set("brisanjeServerError", true);
                    self.set("brisanjeServerErrorText", err.responseText);
                    self.set("brisanjeSuccess", false);
        });


    },

    validirajNovu: function(){

        let uspjesno = true;
        let _noviNazivError = false;

        if (this.get('noviNaziv') ==  null || this.get('noviNaziv').replace(/\s/g,"") == "" || !this.get('noviNaziv').match(/^[a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-]{2,30}$/i)) {

            _noviNazivError = true;
            uspjesno = false;
        } 

        this.set("noviNazivError", _noviNazivError);

        return uspjesno;
    },

    validirajIzmjenu: function(){

        let uspjesno = true;
        let _noviNError = false;
        let _polja=this.get('model.kategorije');
        let _indexGreske=null;

        for(let i=0; i<_polja.length; i++)
        {
            if(_polja[i].naziv.replace(/\s/g,"") == "" || !_polja[i].naziv.match(/^[a-z\u0106\u0107\u010C\u010D\u0110\u0111\u0160\u0161\u017D-\u017F\u212A\-]{2,30}$/i))
            {
                _noviNError = true;
                uspjesno = false;
                _indexGreske=i;
                break;
            }
        }

        this.set("noviNError", _noviNError);
        this.set("indexGreske", _indexGreske);
        return uspjesno;
    },


    actions: {
        add: function(){

            if (this.validirajNovu()) {
                
                let _kategorija = {naziv: this.get("noviNaziv")};
                this.add(_kategorija);
            }

        }, 

        izmijeni: function(index){

            if(this.validirajIzmjenu())
            {
                let _kategorije = this.get("model.kategorije");
                let kategorija = _kategorije[index];
                this.izmijeni(kategorija);
            }
        },

        brisi: function(index){
            
                let _kategorije = this.get("model.kategorije");
                let kategorija = _kategorije[index];
                this.brisi(kategorija, index);
            
        }
    }
});