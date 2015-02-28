'use strict';

/* App Module */

console.log("Hello");

var condorApp = angular.module('condorApp', [
  'ngRoute',
  'condorControllers',
  'condorServices'
]);

condorApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
	    when('/Animals', {
		    templateUrl: 'partials/animals.html',
		    controller: 'AnimalsCtrl'
	    }).
	    when('/Example', {
		    templateUrl: 'partials/example.html',
		    controller: 'ExampleCtrl'
	    }).
      otherwise({
        redirectTo: '/Animals'
      });
  }]);
