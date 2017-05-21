import BaseService from './base-service';
import Nezaposleni from '../models/nezaposleni';
import Poslodavac from '../models/poslodavac';

export default BaseService.extend({

    register: function(korisnik) {
        this.ajax({ url: `korisnici/register`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },
});