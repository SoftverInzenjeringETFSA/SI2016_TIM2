import Ember from 'ember';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    templateService: Ember.inject.service('template-service'),

    noviNazivError: false,
    noviNError: false,
    noviServerError: false,
    noviServerErrorText: "",
    noviServerSuccess: false,
    indexGreske: null,

    validirajPolje: function(){

        let uspjesno = true;
        let _noviNazivError = false;
        let _noviNError = false;
        let _polja=this.get('model.template.poljaTemplatea');
        let _indexGreske=null;



        if (this.get('model.template.naziv') ==  null || this.get('model.template.naziv').replace(/\s/g,"") == "") {

            _noviNazivError = true;
            uspjesno = false;
        } 

        for(let i=0; i<_polja.length; i++)
        {
            if(_polja[i].nazivPolja.replace(/\s/g,"") == "")
            {
                _noviNError = true;
                uspjesno = false;
                _indexGreske=i;
                break;
            }
        }

        this.set("noviNazivError", _noviNazivError);
        this.set("noviNError", _noviNError);
        this.set("indexGreske", _indexGreske);
        return uspjesno;
    },

    addTemplate: function(template){
        this.set("serverErrorText", "");

        var self = this;
        this.get("templateService").add(template).then(x => {
            self.set("noviServerError", false);
            self.set("noviServerSuccess", true);
            self.set("serverErrorText", "");

        }).catch(x => {
            self.set("noviServerError", true);
            self.set("noviServerSuccess", false);
            self.set("serverErrorText", err.responseText);

        });
    },

    actions: {
        dodaj: function(){
            let templ = this.get("model.template");
            let novaPolja = [...templ.poljaTemplatea, {nazivPolja: ""}];
            this.set("model.template.poljaTemplatea", novaPolja);
        },

        izbrisi: function(index){
            let templ = this.get("model.template");
            let novaPolja = [...templ.poljaTemplatea.slice(0, index), ...templ.poljaTemplatea.slice(index + 1, templ.poljaTemplatea.length)]; 
            this.set("model.template.poljaTemplatea", novaPolja);
        },

        submit: function(){

            if (this.validirajPolje()){
                let template = this.get("model.template");
                this.addTemplate(template);
            }
        }
    }
});