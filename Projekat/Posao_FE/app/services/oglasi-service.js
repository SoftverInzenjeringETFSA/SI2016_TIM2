import BaseService from './base-service';
import Oglas from '../models/oglas';

export default BaseService.extend({

    all: function() {
        var oglasi = [];
        this.ajax({ url: `oglasi/all`, type: "GET"}).then(function(data) {
            data.forEach(function(oglas) {
                oglasi.addObject(Oglas.create(oglas));
            });
        });

        return oglasi;
    },

    details: function(id) {
        var oglas = Oglas.create({});
        this.ajax({ url: `oglasi/get?id=${id}`, type: "GET"}).then(function(data) {
        	console.log("data: ");
        	console.log(data);
            oglas.setProperties(data);
        	console.log("created: ");
        	console.log(oglas);
        });

        return oglas;        
    },

});