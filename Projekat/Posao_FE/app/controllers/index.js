import Ember from 'ember';

export default Ember.Controller.extend({
    kategorijaId: null,
    filter: null,
    pretraga: null,
    poredak: null,
    asc: false,

    oglasiService: Ember.inject.service('oglasi-service'),

    search: function(kategorijaId, filter, name, asc){
        if (kategorijaId === null && filter === null && name === null && asc === false){
            let _oglasi = this.get("oglasiService").all();
            this.set("model.oglasi", _oglasi);
            return;
        }

        let _oglasi = this.get("oglasiService").search(name, kategorijaId, filter, asc);
        this.set("model.oglasi", _oglasi);
    },
  
  actions: {
    selectKategorija(kategorijaId) {
      this.set('kategorijaId', kategorijaId);
    },

    selectFilter(filter) {
      this.set('filter', filter);
    },

    selectPoredak(poredak){
        this.set('asc', poredak === "TEMP_ASC");
    },

    search(){
        let _kat = this.get("kategorijaId");
        let _filter = this.get("filter");
        let _name = this.get("pretraga");
        let _asc = this.get("asc");

        if (_kat == -1){
            _kat = null;
        }

        if (_filter == -1){
            _filter = null;
        }

        if (_name == ""){
            _name = null;
        }

        this.search(_kat, _filter, _name, _asc);
    }
  }
});