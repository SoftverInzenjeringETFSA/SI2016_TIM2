import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('index',{path:'/'});
  this.route('registracija',{ path: '/registracija' });
  this.route('login',{ path: '/login' });
  this.route('personal-adverts', {path: '/moji-oglasi'});
  this.route('dodaj-oglas',{path: '/dodaj-oglas'});
  this.route('viewad', {path: '/ad/:id'});
  this.route('profile');
  this.route('kreiraj-template', {path: '/kreiraj-template'});
  this.route('edit-kategorije');
  this.route('pregled-notifikacija');
  this.route('pregled-korisnika');
  this.route('pregled-profila-public');

  this.route('error');
});

export default Router;
