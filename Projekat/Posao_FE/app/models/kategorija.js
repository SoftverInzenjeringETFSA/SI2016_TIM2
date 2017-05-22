import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['idkategorije', 'naziv'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});