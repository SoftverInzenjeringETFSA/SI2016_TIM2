import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('index',{path:'/'});
  this.route('registracija',{ path: '/registracija' });
  this.route('registracija-nezaposleni',{ path: '/registracija1' });
  this.route('registracija-poslodavac',{ path: '/registracija2' });
  this.route('login',{ path: '/login' });
  this.route('dodaj-oglas');
});

export default Router;
