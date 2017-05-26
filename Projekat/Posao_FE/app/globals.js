const getTimeAgo = function(timestamp) {
    var date = new Date(timestamp);
    var seconds = Math.floor((new Date() - date) / 1000);

    // manje od minute
    if(seconds < 60)  
      return 'Sada';

    // manje od sata
    if(seconds < 3600)
      return 'Prije ' + Math.floor(seconds/60) + 'm';

    // manje od dana
    if(seconds < 86400) {
      return "Prije " + Math.floor(seconds/3600) + 'h';
    }

    // manje od 2 dana
    if(seconds < 172800)
      return "Jučer";
    
    // vrati datum
    return date.getDate() + '.' + (date.getMonth() + 1) + '.' + date.getFullYear() + '.';
};

export default getTimeAgo;