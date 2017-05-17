import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['idKorisnika', 'ime', 'prezime', 'cv', 'privatanProfil'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});