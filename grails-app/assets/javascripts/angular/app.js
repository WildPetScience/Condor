'use strict';

/* App Module */

var condorApp = angular.module('condorApp', [
	'ngRoute',
	'condorControllers',
	'condorServices',
	'condorFilters'
]);

condorApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
	    when('/404', {
		    templateUrl: 'partials/404.html',
		    controller: 'PageNotFoundCtrl'
	    }).
	    when('/', {
		    templateUrl: 'partials/index.html',
		    controller: 'IndexCtrl'
	    }).
	    when('/Animals/:animalName', {
		    templateUrl: 'partials/animal.html',
		    controller: 'AnimalCtrl'
	    }).
	    when('/Pets/:identifier', {
		    templateUrl: 'partials/pet.html',
		    controller: 'PetCtrl'
	    }).
	    when('/Example', {
		    templateUrl: 'partials/example.html',
		    controller: 'ExampleCtrl'
	    }).
      otherwise({
        redirectTo: '/404'
      });
  }]);
