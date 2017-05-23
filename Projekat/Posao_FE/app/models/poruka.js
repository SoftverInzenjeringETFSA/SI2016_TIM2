import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['tekst', 'posiljalac', 'primalac'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});