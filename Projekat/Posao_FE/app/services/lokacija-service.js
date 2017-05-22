
import BaseService from './base-service';
import Lokacija from '../models/lokacija';

export default BaseService.extend({

    all: function() {
    	var lokacije = [];
        this.ajax({ url: `lokacije/get/all`, type: "GET"}).then(function(data) {
        	data.forEach(function(lokacija){
        		lokacije.addObject(Lokacija.create(lokacija));
        	})
        });
    
        return lokacije;
    },
});