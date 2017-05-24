import BaseService from './base-service';
import Template from '../models/template';

export default BaseService.extend({

    add: function(template) {
        this.ajax({ url: `template/add`, type: "POST", data: JSON.stringify(template)}).then(function(data) {
        });
    
        return true;
    },

    all: function(template) {
    	let templatei = [];
        this.ajax({ url: `template/get/all`, type: "GET"}).then(function(data) {
            data.forEach(function(template) {
                templatei.addObject(Template.create(template));
            });
        });
    
        return templatei;
    },

});