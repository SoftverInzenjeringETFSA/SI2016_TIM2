import BaseService from './base-service';
import Korisnik from '../models/korisnik';
import Nezaposleni from '../models/nezaposleni';
import Poslodavac from '../models/poslodavac';
import Izvjestaj from '../models/izvjestaj';

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

    update: function(korisnik, id) {
        this.ajax({ url: `korisnici/update?id=${id}`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },

    delete: function(korisnikid) {
        this.ajax({ url: `korisnici/delete?id=${korisnikid}`, type: "DELETE", data: JSON.stringify({})}).then(function(data) {
        });
    
        return true;
    },


    izvjestaj: function() {
        var izvjestaj = Izvjestaj.create({});
        this.ajax({ url: `izvjestaj/get`, type: "GET"}).then(function(data) {
            izvjestaj.setProperties(data);
        });

        return izvjestaj;        
    },

});