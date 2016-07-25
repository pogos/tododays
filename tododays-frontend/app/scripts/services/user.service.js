'use strict';

angular.module('tododaysApp').service('UserService', function () {

  this.users = [{username: 'admin', password: 'koala'}];


  this.authenticate = function(credentials) {
    var user = this.findUserByName(credentials.username);

    return (user !== null && (user.password === credentials.password));
  };

  this.register = function(user) {
    this.users.add(user);
  };

  this.findUserByName = function(userName) {
    var i = 0, len = this.users.length;
    for (; i < len; i++) {
      if (this.users[i].username === userName) {
        return this.users[i];
      }
      return null;
    }
  };

});
