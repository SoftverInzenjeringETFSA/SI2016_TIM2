import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['id', 'kanton', 'naziv'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});