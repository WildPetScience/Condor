# Triton

[![Build Status](https://travis-ci.org/WildPetScience/Condor.svg)](https://travis-ci.org/WildPetScience/Condor)

Condor is the code name for the portion of the project that will be hosted on a server

### Overview
Condor covers the server backend and user frontend. Condor is built with [Grails](https://grails.org/) which is a full-stack MVC framework.

[Triton](https://github.com/WildPetScience/Triton) needs to be able to communicate with Condor using an API and so it was reasonable to construct a RESTful API which could be accessed by both Triton and the web frontend. With this in mind, the web frontend uses the (AngularJS)[https://angularjs.org/] framework in order assist in consuming the REST resources. It is __strongly__ recommended to familiarise yourself with AngularJS by following [their fantastic tutorial](https://docs.angularjs.org/tutorial) before attempting to modify the codebase.

### Grails
The main purpose of Condor is to persist data from Triton into a database so it can be later analysed. MongoDB has been chosen as our database engine and the database is accessed via the REST API.

### API
The structure of the REST API is as follows:
```Controller: AnimalPosition
 |   GET    | /api/clients/${ClientId}/api/positions            | Action: index            |
 |   POST   | /api/clients/${ClientId}/api/positions            | Action: save             |
 |   PUT    | /api/clients/${ClientId}/api/positions/${id}      | Action: update           |
 |  DELETE  | /api/clients/${ClientId}/api/positions/${id}      | Action: delete           |

Controller: AnimalType
 |   GET    | /api/animals                                      | Action: index            |
 |   POST   | /api/animals                                      | Action: save             |
 |   PUT    | /api/animals/${id}                                | Action: update           |
 |  DELETE  | /api/animals/${id}                                | Action: delete           |

Controller: Client
 |   GET    | /api/clients                                      | Action: index            |
 |   POST   | /api/clients                                      | Action: save             |
 |   PUT    | /api/clients/${id}                                | Action: update           |
 |  DELETE  | /api/clients/${id}                                | Action: delete           |

Controller: Zone
 |   GET    | /api/clients/${ClientId}/api/zones                | Action: index            |
 |   POST   | /api/clients/${ClientId}/api/zones                | Action: save             |
 |   PUT    | /api/clients/${ClientId}/api/zones/${id}          | Action: update           |
 |  DELETE  | /api/clients/${ClientId}/api/zones/${id}          | Action: delete           |

Controller: ZoneType
 |   GET    | /api/zonetypes                                    | Action: index            |
 |   POST   | /api/zonetypes                                    | Action: save             |
 |   PUT    | /api/zonetypes/${id}                              | Action: update           |
 |  DELETE  | /api/zonetypes/${id}                              | Action: delete           |```

### AngularJS

### Testing
There are currently no unit tests or end-to-end tests. Unit tests for the Grails controllers will be written after the specified front-end features are implemented due to limited development resources.

### A note below
