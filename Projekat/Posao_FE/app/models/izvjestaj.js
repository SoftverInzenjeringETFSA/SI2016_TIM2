import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['brojOglasa', 'brojUspjesnihOglasa', 'brojKorisnika'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});