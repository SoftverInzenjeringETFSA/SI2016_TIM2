import Ember from 'ember';

export default Ember.Controller.extend({
    kategorijaId: null,
    filter: null,
    pretraga: null,

    oglasiService: Ember.inject.service('oglasi-service'),

    search: function(kategorijaId, filter, name){
        if (kategorijaId === null && filter === null && name === null){
            let _oglasi = this.get("oglasiService").all();
            this.set("model.oglasi", _oglasi);
            return;
        }

        let _oglasi = this.get("oglasiService").search(name, kategorijaId, filter);
        this.set("model.oglasi", _oglasi);
    },
  
  actions: {
    selectKategorija(kategorijaId) {
        console.log(kategorijaId);
      this.set('kategorijaId', kategorijaId);
    },

    selectFilter(filter) {
        console.log(filter);
      this.set('filter', filter);
    },

    search(){
        let _kat = this.get("kategorijaId");
        let _filter = this.get("filter");
        let _name = this.get("pretraga");

        if (_kat == -1){
            _kat = null;
        }

        if (_filter == -1){
            _filter = null;
        }

        if (_name == ""){
            _name = null;
        }

        console.log("pretraga");
        console.log(_name);

        this.search(_kat, _filter, _name);
    }
  }
});