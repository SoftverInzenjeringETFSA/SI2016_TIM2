import Ember from 'ember';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    templateService: Ember.inject.service('template-service'),

    noviNazivError: false,
    noviNError: false,
    indexGreske: null,

    validirajPolje: function(){

        let uspjesno = true;
        let _noviNazivError = false;
        let _noviNError = false;
        let _polja=this.get('model.template.poljaTemplatea');
        let _indexGreske=null;



        if (this.get('model.template.naziv') ==  "") {

            _noviNazivError = true;
            uspjesno = false;
        } 

        for(let i=0; i<_polja.length; i++)
        {
            if(_polja[i].nazivPolja=="")
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
        this.get("templateService").add(template).then(x => {}).catch(x => {});
    },

    actions: {
        dodaj: function(){
            let templ = this.get("model.template");
            let novaPolja = [...templ.poljaTemplatea, {nazivPolja: ""}];
            this.set("model.template.poljaTemplatea", novaPolja);
        },

        izbrisi: function(index){
            let templ = this.get("model.template");
            console.log("index");
            console.log(index);
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