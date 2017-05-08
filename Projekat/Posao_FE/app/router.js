import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('registracija');
  this.route('registracija-nezaposleni');
  this.route('registracija-poslodavac');
});

export default Router;
