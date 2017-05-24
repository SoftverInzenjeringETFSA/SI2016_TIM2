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
            oglas.setProperties(data);
        });

        return oglas;        
    },

    postavi: function(oglas) {
    this.ajax({ url: `oglasi/postavioglas`, type: "POST", data: JSON.stringify(oglas)}).then(function(data) {
    });

        return true;
    },

    prijava: function(userid, adid) {
    console.log("u prijavi");
    this.ajax({ url: `prijave/add?korisnik=${userid}&oglas=${adid}`, type: "POST", data: {}}).then(function(data) {
    });

        return true;
    },

    search: function(name, kategorijaId, filter){
        let query = "oglasi/search?";

        if (kategorijaId !== null && filter !== null){
            query = query + "idk=" + kategorijaId + "&idlok=" + filter;
            
            if (name !== null){
                query = query + "&name=" + name;
            }
        }
        else if (kategorijaId === null && filter !== null){
            query = query + "idlok=" + filter;

            if (name !== null){
                query = query + "&name=" + name;
            }
        }
        else if (kategorijaId !== null && filter === null){
            query = query + "idk=" + kategorijaId;

            if (name !== null){
                query = query + "&name=" + name;
            }
        }
        else if (name !== null){
            query = query + "name=" + name;
        }

        var oglasi = [];
        this.ajax({ url: query, type: "GET"}).then(function(data) {
            data.forEach(function(oglas) {
                oglasi.addObject(Oglas.create(oglas));
            });
        });

        return oglasi;
    }

});