import BaseService from './base-service';
import Korisnik from '../models/korisnik';
import Nezaposleni from '../models/nezaposleni';
import Poslodavac from '../models/poslodavac';
import Izvjestaj from '../models/izvjestaj';

export default BaseService.extend({

    register: function(korisnik) {
        return this.ajax({ url: `korisnici/register`, type: "POST", data: JSON.stringify(korisnik)});
    },

    profil: function(username) {
        var korisnik = Korisnik.create({});

    	this.ajax({url: `korisnici/get/exact?name=${username}`, type: "GET"}).then(function(data){
            data.password = "";
    		korisnik.setProperties(data);
    	});

        return korisnik;
    },

    update: function(korisnik, id) {
        return this.ajax({ url: `korisnici/update?id=${id}`, type: "POST", data: JSON.stringify(korisnik)});
    },

    delete: function(korisnikid) {
        return this.ajax({ url: `korisnici/delete?id=${korisnikid}`, type: "DELETE", data: JSON.stringify({})});
    },


    izvjestaj: function() {
        var izvjestaj = Izvjestaj.create({});
        this.ajax({ url: `izvjestaj`, type: "GET"}).then(function(data) {
            izvjestaj.setProperties(data);
        });

        return izvjestaj;
    },

    all: function() {
        var korisnici = [];
        this.ajax({ url: `korisnici/get/all`, type: "GET"}).then(function(data) {
            data.forEach(function(korisnik){
                korisnici.addObject(Korisnik.create(korisnik));
            })
        });

        return korisnici;
    },

    nezaposleni: function() {
        var korisnici = [];
        this.ajax({ url: `korisnici/nezaposleni`, type: "GET"}).then(function(data) {
            data.forEach(function(korisnik){
                korisnici.addObject(Korisnik.create(korisnik));
            })
        });

        return korisnici;
    },

});