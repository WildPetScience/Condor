package uk.ac.cam.cl.wildpetscience.condor.models;

import uk.ac.cam.cl.wildpetscience.condor.models.SpatialCoordinates;

class AnimalPosition {
    double time;
    int zoneId;
    SpatialCoordinates coordinates;

    static embedded = ['coordinates'];
}