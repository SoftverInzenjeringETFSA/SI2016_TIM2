import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['brojOglasa', 'brojPoslodavaca', 'brojNezaposlenih', 'brojPrijava'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});