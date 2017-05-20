import BaseService from './base-service';
import Nezaposleni from '../models/nezaposleni';
import Poslodavac from '../models/poslodavac';

export default BaseService.extend({

    register: function(korisnik) {
        var oglasi = [];
        this.ajax({ url: `register`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },
});