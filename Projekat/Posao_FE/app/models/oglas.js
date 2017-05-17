import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['id', 'naziv', 'poslodavac', 'datum'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});