import BaseService from './base-service';
import Kategorija from '../models/kategorija';

export default BaseService.extend({

    all: function() {
    	var kategorije = [];
        this.ajax({ url: `kategorije/get/all`, type: "GET"}).then(function(data) {
        	data.forEach(function(kategorija){
        		kategorije.addObject(Kategorija.create(kategorija));
        	})
        });
    
        return kategorije;
    },

    update: function(kategorija, kategorijaId) {
        return this.ajax({ url: `kategorije/update?id=${kategorijaId}`, type: "POST", data: JSON.stringify(kategorija)});

    },

    delete: function(id) {
        return this.ajax({ url: `kategorije/remove?id=${id}`, type: "DELETE" });
    },

    add: function(kategorija) {
        return this.ajax({ url: `kategorije/add`, type: "POST", data: JSON.stringify(kategorija)});
    },


});