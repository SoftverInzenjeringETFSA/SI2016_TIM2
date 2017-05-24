import Ember from 'ember';
import Korisnik from '../models/korisnik';
import Poruka from '../models/poruka';

export default Ember.Controller.extend({
    korisnikService: Ember.inject.service('korisnik-service'),
    porukeService: Ember.inject.service('poruke-service'),
	session: Ember.inject.service(),
    modalClass: "modal fade",
    modalStyle: "display:hidden",
    poruka: Poruka.create({}),
    success: false,
    error: false,

    sendMessage: function(){
        this.get("porukeService").send(this.get("poruka")).then(res => {}).catch(err => {});
    },

    validiraj: function(){
        let _success = false;
        let _error = false;
        let validno = true;

        return validno;
    },

    actions: {

        sakrijModal: function(){
            this.set("modalClass", "modal fade");
            this.set("modalStyle", "display:none");
            this.set("poruka", Poruka.create({}));
          //  this.set("izvjestaj", {brojOglasa: "", brojUspjesnihOglasa: "", brojKorisnika: ""});
        },

        porukaPopout: function(idkorisnika){
            this.set("modalClass", "modal fade in");
            this.set("modalStyle", "display:block");

            this.set("poruka.primalac", idkorisnika);
            this.set("poruka.posiljalac", this.get("session.data.authenticated.userid"));
        //    this.getReport();
        },

        posalji: function(){
            if (this.validiraj())
            {
                this.sendMessage();
            }
        }
    }
});