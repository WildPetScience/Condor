package uk.ac.cam.cl.wildpetscience.condor.models;

import uk.ac.cam.cl.wildpetscience.condor.models.AnimalPosition;
import uk.ac.cam.cl.wildpetscience.condor.models.AnimalType;
import uk.ac.cam.cl.wildpetscience.condor.models.Zone;

class Client {
    AnimalType animalType;
    Date dateConnected;

    static embedded = ['animalType'];
    static hasMany = [positions: AnimalPosition, zones: Zone];
}
