'use strict';

/* Controllers */

var condorControllers = angular.module('condorControllers', []);

// Naming convention:
// The suffix "Ctrl" indicates the controller is a page controller
// Ie.
// AnimalsCtrl is the controller for the Animals page
// Animals is a controller which can be used in various pages

condorControllers.controller('IndexCtrl', ['$scope',
	function($scope) {
		// Fake schema
		$scope.clients = [
			{
				"animalType": "Hamster",
				"identifier": "secret driver are"
			},
			{
				"animalType": "Hamster",
				"identifier": "things your is"
			},
			{
				"animalType": "Goldfish",
				"identifier": "officers gym that"
			},
			{
				"animalType": "Hamster",
				"identifier": "tip poker about"
			},
			{
				"animalType": "Snake",
				"identifier": "drive computer glass"
			},
			{
				"animalType": "Snake",
				"identifier": "paper cookie brush"
			},
			{
				"animalType": "Tarantula",
				"identifier": "pocket pen drink"
			}
		];
	}
]);

condorControllers.controller('AnimalCtrl', ['$scope', '$routeParams', 'Clients',
	function($scope, $routeParams, Clients) {
		$scope.animal = $routeParams.animalName;

		$scope.clients = Clients.query({animalType: $scope.animal});
	}
]);

condorControllers.controller('PetCtrl', ['$scope', '$routeParams', 'Client',
	function($scope, $routeParams, Client) {
		$scope.identifier = $routeParams.identifier.replace(new RegExp('-', 'g'), ' ');

		$scope.client = Client.query({identifier: $scope.identifier});

		$scope.client.$promise.then(function() {
			$(function() {
				Morris.Area({
					element: 'morris-area-chart',
					data: $scope.client.positions,
					xkey: 'time',
					ykeys: ['speed'],
					pointSize: 2,
					hideHover: 'auto',
					resize: true
				});
			});
		});
	}
]);

condorControllers.controller('PageNotFoundCtrl', ['$scope',
	function($scope) {

	}
]);

condorControllers.controller('Animals', ['$scope', 'AnimalTypes',
	function($scope, AnimalTypes) {
		$scope.animals = AnimalTypes.query();

		/*
		 * Demo return array
		 * (although it should be pointed out that .query()
		 *  returns a promise object)

		 $scope.animals = [
		 {
		 "class":"uk.ac.cam.cl.wildpetscience.condor.models.AnimalType",
		 "id":1,
		 "name":"Hamster"
		 }
		 ];*/
	}
]);

condorControllers.controller('ExampleCtrl', [
	function() {
		$(function() {
				Morris.Area({
					element: 'morris-area-chart',
					data: [{
						period: '2010 Q1',
						iphone: 2666,
						ipad: null,
						itouch: 2647
					}, {
						period: '2010 Q2',
						iphone: 2778,
						ipad: 2294,
						itouch: 2441
					}, {
						period: '2010 Q3',
						iphone: 4912,
						ipad: 1969,
						itouch: 2501
					}, {
						period: '2010 Q4',
						iphone: 3767,
						ipad: 3597,
						itouch: 5689
					}, {
						period: '2011 Q1',
						iphone: 6810,
						ipad: 1914,
						itouch: 2293
					}, {
						period: '2011 Q2',
						iphone: 5670,
						ipad: 4293,
						itouch: 1881
					}, {
						period: '2011 Q3',
						iphone: 4820,
						ipad: 3795,
						itouch: 1588
					}, {
						period: '2011 Q4',
						iphone: 15073,
						ipad: 5967,
						itouch: 5175
					}, {
						period: '2012 Q1',
						iphone: 10687,
						ipad: 4460,
						itouch: 2028
					}, {
						period: '2012 Q2',
						iphone: 8432,
						ipad: 5713,
						itouch: 1791
					}],
					xkey: 'period',
					ykeys: ['iphone', 'ipad', 'itouch'],
					labels: ['iPhone', 'iPad', 'iPod Touch'],
					pointSize: 2,
					hideHover: 'auto',
					resize: true
				});

				Morris.Donut({
					element: 'morris-donut-chart',
					data: [{
						label: "Download Sales",
						value: 12
					}, {
						label: "In-Store Sales",
						value: 30
					}, {
						label: "Mail-Order Sales",
						value: 20
					}],
					resize: true
				});

				Morris.Bar({
					element: 'morris-bar-chart',
					data: [{
						y: '2006',
						a: 100,
						b: 90
					}, {
						y: '2007',
						a: 75,
						b: 65
					}, {
						y: '2008',
						a: 50,
						b: 40
					}, {
						y: '2009',
						a: 75,
						b: 65
					}, {
						y: '2010',
						a: 50,
						b: 40
					}, {
						y: '2011',
						a: 75,
						b: 65
					}, {
						y: '2012',
						a: 100,
						b: 90
					}],
					xkey: 'y',
					ykeys: ['a', 'b'],
					labels: ['Series A', 'Series B'],
					hideHover: 'auto',
					resize: true
				});
			});
	}
]);