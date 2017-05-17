import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['idKorisnika', 'username', 'password', 'email', 'nezaposleni', 'admin', 'poslodavac'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});