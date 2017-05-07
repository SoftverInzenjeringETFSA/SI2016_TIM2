import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('registracija');
  this.route('registracijaNezaposleni');
  this.route('registracijaPoslodavac');
});

export default Router;
