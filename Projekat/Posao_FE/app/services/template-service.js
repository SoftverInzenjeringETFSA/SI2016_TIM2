import BaseService from './base-service';

export default BaseService.extend({

    add: function(template) {
        this.ajax({ url: `template/add`, type: "POST", data: JSON.stringify(template)}).then(function(data) {
        });
    
        return true;
    },
});