import BaseService from './base-service';
import Korisnik from '../models/korisnik';
import Nezaposleni from '../models/nezaposleni';
import Poslodavac from '../models/poslodavac';

export default BaseService.extend({

    register: function(korisnik) {
        this.ajax({ url: `korisnici/register`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },

    profil: function(username) {
        var korisnik = Korisnik.create({});

    	this.ajax({url: `korisnici/get/exact?name=${username}`, type: "GET"}).then(function(data){
            console.log("data:");
            console.log(data);
    		korisnik.setProperties(data);
    	});

        return korisnik;
    },
});