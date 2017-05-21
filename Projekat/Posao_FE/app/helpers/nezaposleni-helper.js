import Ember from 'ember';

export default Ember.Helper.helper(function([arg1]) {
  if (arg1){
  	if (arg1 === "Nezaposleni"){
  		return false;
  	}
  }

  return true;
});
