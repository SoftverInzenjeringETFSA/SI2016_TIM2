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
        this.ajax({ url: `kategorije/update?id=${kategorijaId}`, type: "POST", data: JSON.stringify(kategorija)}).then(function(data) {
        });
    
        return true;
    },

    delete: function(id) {
        this.ajax({ url: `kategorije/remove?id=${id}`, type: "DELETE" }).then(function(data) {
        });
    
        return true;
    },

    add: function(kategorija) {
        this.ajax({ url: `kategorije/add`, type: "POST", data: JSON.stringify(kategorija)}).then(function(data) {
        });
    
        return true;
    },


});