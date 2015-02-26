'use strict';

/* Controllers */

var condorControllers = angular.module('condorControllers', []);

condorControllers.controller('AnimalsCtrl', ['$scope', 'AnimalTypes',
	function($scope, AnimalTypes) {

		$scope.animals = AnimalTypes.query();

        $scope.animals = [
            {
                "class":"uk.ac.cam.cl.wildpetscience.condor.models.AnimalType",
                "id":1,
                "name":"Hamster"
            }
        ];

	}]);
