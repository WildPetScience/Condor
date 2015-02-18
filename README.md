# Triton

[![Build Status](https://travis-ci.org/WildPetScience/Condor.svg)](https://travis-ci.org/WildPetScience/Condor)

Condor is the code name for the portion of the project that will be hosted on a server

### Overview
Condor covers the server backend and user frontend. Condor is built with [Grails](https://grails.org/) which is a full-stack MVC framework.

[Triton](https://github.com/WildPetScience/Triton) needs to be able to communicate with Condor using an API and so it was reasonable to construct a RESTful API which could be accessed by both Triton and the web frontend. With this in mind, the web frontend uses the (AngularJS)[https://angularjs.org/] framework in order assist in consuming the REST resources. It is __strongly__ recommended to familiarise yourself with AngularJS by following [their fantastic tutorial](https://docs.angularjs.org/tutorial) before attempting to modify the codebase.

### Grails

### AngularJS

### Testing
There are currently no unit tests or end-to-end tests. Unit tests for the Grails controllers will be written after the specified front-end features are implemented due to limited development resources.

### A note below
