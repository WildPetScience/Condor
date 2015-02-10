package uk.ac.cam.cl.wildpetscience.condor.models;

import uk.ac.cam.cl.wildpetscience.condor.models.AnimalType;

class Client {
    AnimalType animalType;
    Date dateConnected;

    List<AnimalPosition> positions;
    List<Zone> zones;

    static embedded = ['positions', 'zones'];
}

class AnimalPosition {
    double time;
    int zoneId;
    List<Coordinate> coordinates;

    static embedded = ['coordinates'];
}

class Coordinate {
    String axis;
    double position;
}

class Zone {
    int zoneId;
    ZoneType zoneType;
}