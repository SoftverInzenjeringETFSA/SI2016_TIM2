import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['id', 'naziv', 'poljaTemplatea'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});