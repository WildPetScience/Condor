# Triton

[![Build Status](https://travis-ci.org/WildPetScience/Condor.svg)](https://travis-ci.org/WildPetScience/Condor)

Condor is the code name for the portion of the project that will be hosted on a server

### Overview
Condor covers the server backend and user frontend. Condor is built with [Grails](https://grails.org/) which is a full-stack MVC framework.

[Triton](https://github.com/WildPetScience/Triton) needs to be able to communicate with Condor using an API and so it was reasonable to construct a RESTful API which could be accessed by both Triton and the web frontend. With this in mind, the web frontend uses the (AngularJS)[https://angularjs.org/] framework in order assist in consuming the REST resources. It is __strongly__ recommended to familiarise yourself with AngularJS by following [their fantastic tutorial](https://docs.angularjs.org/tutorial) before attempting to modify the codebase.

### Grails
The main purpose of Condor is to persist data from Triton into a database so it can be later analysed. MongoDB has been chosen as our database engine and the database is accessed via the REST API.

##### MongoDB Configuration
Prior to launching the application [MongoDB](http://www.mongodb.org/) must be installed and running and with access to the `condor` database configured. This can be done by launching the server, opening a MongoDB console window and entering:
```
using condor
db.addUser({user: "condor", pwd: "condor", roles: [ "readWrite" ]})
```
It should then be possible to launch the grails application.

### API
The structure of the REST API is as follows:
```
Controller: AnimalPosition
 |  GET   | /api/clients/${ClientId}/api/positions            | Action: index  |
 |  POST  | /api/clients/${ClientId}/api/positions            | Action: save   |
 |  PUT   | /api/clients/${ClientId}/api/positions/${id}      | Action: update |
 | DELETE | /api/clients/${ClientId}/api/positions/${id}      | Action: delete |

Controller: AnimalType
 |  GET   | /api/animals                                      | Action: index  |
 |  POST  | /api/animals                                      | Action: save   |
 |  PUT   | /api/animals/${id}                                | Action: update |
 | DELETE | /api/animals/${id}                                | Action: delete |

Controller: Client
 |  GET   | /api/clients                                      | Action: index  |
 |  POST  | /api/clients                                      | Action: save   |
 |  PUT   | /api/clients/${id}                                | Action: update |
 | DELETE | /api/clients/${id}                                | Action: delete |

Controller: Zone
 |  GET   | /api/clients/${ClientId}/api/zones                | Action: index  |
 |  POST  | /api/clients/${ClientId}/api/zones                | Action: save   |
 |  PUT   | /api/clients/${ClientId}/api/zones/${id}          | Action: update |
 | DELETE | /api/clients/${ClientId}/api/zones/${id}          | Action: delete |

Controller: ZoneType
 |  GET   | /api/zonetypes                                    | Action: index  |
 |  POST  | /api/zonetypes                                    | Action: save   |
 |  PUT   | /api/zonetypes/${id}                              | Action: update |
 | DELETE | /api/zonetypes/${id}                              | Action: delete |
```

### AngularJS
AngularJS was chosen due to its ease of use when it comes to consuming and iterating over rest resources. Integration of AngularJS with Grails means that the file structure of this project differs from typical just-AngularJS or just-Grails applications and is outlined below.

##### Integration with Grails
The AngularJS library resides in `/grails-app/assets/bower-components/angular/` (see "A Note Below") and is included in the project by the Grails asset-pipeline plugin which minifies and bundles javascript and stylesheet resources for production builds. The AngularJS library is explicitly included in the application's javascript bundle by including it in `/grails-app/assets/javascripts/application.js`.

The Grails routing defined in `/grails-app/conf/UrlMappings.groovy` means that the root address of the website (`/`) causes Grails index view to be loaded and displayed to the user (`index.gsp` found in `/grails-app/views/index.gsp`). This view utilises the asset-pipeline plugin to load the necessary AngularJS resources which allows us to instantiate the AngularJS application using the `ng-app` attribute as normal. The following lines are responsible for loading the JS/CSS resource bundles and are implemented by Grails.
```
    <asset:javascript src="application.js"/>
    <asset:stylesheet href="application.css"/>
```

##### Back to AngularJS
The application-specific javascript files reside in `/grails-app/assets/javascripts/angular/`. This is the folder where our AngularJS controllers, filters, views and directives will reside. The application-specific HTML view files reside in `/web-app/partials/` and are completely independent of grails' views. All front end work will concern files in these two directories. It should not be necessary to modify any files in `/grails-app/views/`.

Bootstrap is used to assist in UI design and is included in the same way as AngularJS. The bootstrap theme [SB Admin 2](http://startbootstrap.com/template-overviews/sb-admin-2/) is currently being used in this project and it is encouraged to explore the link to see what interactive libraries this provides.

##### A very brief example of consuming an API resource
Lets say we want to list all the types of animals in the system. We know from the REST API that sending a GET request to ` /api/animals` will return an array of the animals and the precise structure of the objects returned can be trivially inspected (either by looking at the domain classes or by inspecting the generated JSON). An example of the return response is:
```
[  
   {  
      "class":"uk.ac.cam.cl.wildpetscience.condor.models.AnimalType",
      "id":1,
      "name":"Hamster"
   }
]
```
An example AngularJS service for consuming the AnimalType resource can be seen at `/grails-app/assets/javascripts/angular/services.js`. This service is currently being used in the AnimalsCtrl AngularJS controller by the line:

```
$scope.animals = AnimalTypes.query();
```

Which loads the list of animals from the API and stores it in the scope. In the corresponding view `/web-app/partials/animals.html` this collection is iterated over by the lines:
```
<div class="list-group">
	<a href="#" class="list-group-item" ng-repeat="animal in animals">
		<i class="fa fa-tasks fa-fw"></i> {{animal.name}}
	</a>
</div>
```
Which results in the animal names being printed out as a list in the UI. Please see the [documentation on the ngRepeat directive](https://docs.angularjs.org/api/ng/directive/ngRepeat) for more information.

### Testing
There are currently no unit tests or end-to-end tests. Unit tests for the Grails controllers will be written after the specified front-end features are implemented due to limited development resources.

### A Note Below
For flexibility this project uses `bower` to manage front-end dependencies rather than Grails. For simplicity the `bower_components` directory is included in the repository, although these dependencies can be downloaded by running `bower install` in the root directory of the project.