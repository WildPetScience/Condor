package uk.ac.cam.cl.wildpetscience.condor.models;

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
    double x;
    double y;
}

class Zone {
    int zoneId;
    ZoneType zoneType;
}