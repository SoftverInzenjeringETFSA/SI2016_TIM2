import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['idOglasa', 'poslodavac', 'lokacija', 'datumObjave', 'datumIsteka', 'kategorije', 'oglasPodaci'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});