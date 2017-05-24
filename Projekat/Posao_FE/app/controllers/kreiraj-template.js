import Ember from 'ember';

export default Ember.Controller.extend({
	korisnikService: Ember.inject.service('korisnik-service'),
	templateService: Ember.inject.service('template-service'),

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
    		let template = this.get("model.template");

            if (validno()){
                this.addTemplate(template);
            }
    	}
	}
});