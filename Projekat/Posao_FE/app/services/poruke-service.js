import BaseService from './base-service';
import Poruka from '../models/poruka';

export default BaseService.extend({

    all: function(id) {
        var poruke = [];
        console.log("u servisu");
        console.log(id);
        this.ajax({ url: `poruke/get?recipient=${id}`, type: "GET"}).then(function(data) {
            data.forEach(function(poruka) {
                poruke.addObject(Poruka.create(poruka));
            });
        });

        return poruke;
    },
});