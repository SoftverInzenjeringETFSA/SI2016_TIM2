import Ember from 'ember';

export default Ember.Helper.helper(function([arg1]) {
  if (arg1){
  	if (arg1 === "Poslodavac"){
  		return false;
  	}
  }

  return true;
});
