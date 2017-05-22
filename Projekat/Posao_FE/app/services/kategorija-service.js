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
});