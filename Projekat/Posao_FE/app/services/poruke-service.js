import BaseService from './base-service';
import Poruka from '../models/poruka';

export default BaseService.extend({

    all: function(id) {
        var poruke = [];
        this.ajax({ url: `poruke/get?recipient=${id}`, type: "GET"}).then(function(data) {
            data.forEach(function(poruka) {
                poruke.addObject(Poruka.create(poruka));
            });
        });

        return poruke;
    },


    send: function(poruka) {
        var poruke = [];
        this.ajax({ url: `poruke/send`, type: "POST", data: JSON.stringify(poruka)}).then({
        });

        return true;
    },
});