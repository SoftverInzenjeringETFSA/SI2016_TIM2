import BaseService from './base-service';
import Izvjestaj from '../models/izvjestaj';

export default BaseService.extend({

    get: function() {
    var izvjestaj = Izvjestaj.create({});
      
    this.ajax({ url: `izvjestaj/`, type: "GET"}).then(function(data) {
        //izvjestaj.setProperties(data);
    });

        return izvjestaj;
    },
});