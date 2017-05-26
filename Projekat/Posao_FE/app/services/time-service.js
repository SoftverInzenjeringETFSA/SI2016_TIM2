import Ember from 'ember';

export default Ember.Service.extend({

    getFormatedDate: function(timestamp) {
        var date = new Date(timestamp*1000);
        return date.getDate() + '.' + (date.getMonth() + 1) + '.' + date.getFullYear();
    },

    getTimeAgo: function(timestamp) {
        var date = new Date(timestamp);
        var seconds = Math.floor((new Date() - date) / 1000);

        // manje od minute
        if(seconds < 60)  
          return 'Sada';

        // manje od sata
        if(seconds < 3600)
          return 'Prije ' + Math.floor(seconds/60) + 'm';

        // manje od dana
        if(seconds < 86400)
          return "Prije " + Math.floor(seconds/86400) + 'h';

        // manje od 2 dana
        if(seconds < 172800)
          return "Jučer";

        // vrati datum
        return this.getFormatedDate(timestamp);
    }

});
