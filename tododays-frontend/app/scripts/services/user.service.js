'use strict';

angular.module('tododaysApp').service('LoginService', function () {

  this.user = {username: 'admin', password: 'koala'};

  this.authenticate = function(credentials) {
    if (this.user.username === credentials.username && (this.user.password === credentials.password)) {
      return true;
    }
    return false;
  };

});
