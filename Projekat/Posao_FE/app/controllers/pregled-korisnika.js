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
    messageError: false,
    serverError: false,

    sendMessage: function(){
        var self = this;

        this.get("porukeService").send(this.get("poruka")).then(res => {
            self.set("success", true);
            self.set("serverError", false);
        }).catch(err => {
            self.set("success", false);
            self.set("serverError", true);
        });
    },

    validiraj: function(){
        let validno = this.get("poruka.tekst") != null && this.get("poruka.tekst").length !== 0;

        this.set("serverError", false);
        this.set("success", false);
        this.set("messageError", !validno);

        return validno;
    },

    actions: {

        sakrijModal: function(){
            this.set("modalClass", "modal fade");
            this.set("success", false);
            this.set("messageError", false);
            this.set("serverError", false);
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

        send: function(){
            if (this.validiraj())
            {
                this.sendMessage();
            }
        }
    }
});