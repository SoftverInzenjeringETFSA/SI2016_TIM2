import BaseService from './base-service';
import Oglas from '../models/oglas';

export default BaseService.extend({

    all: function() {
        var oglasi = [];
        this.ajax({ url: `oglasi/svi`, type: "GET"}).then(function(data) {
            data.forEach(function(oglas) {
                oglasi.addObject(Oglas.create(oglas));
            });
        });     
        return oglasi;
    },
});