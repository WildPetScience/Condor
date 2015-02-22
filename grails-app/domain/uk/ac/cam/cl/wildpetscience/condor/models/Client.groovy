package uk.ac.cam.cl.wildpetscience.condor.models;

class Client {
    Date dateConnected;

    AnimalType animalType;
    double cageWidth;
    double cageHeight;

    List<AnimalPosition> positions;
    List<Zone> zones;

    static embedded = ['positions', 'zones'];
}

class AnimalPosition {
    Date time;
    double x;
    double y;
    double speed;
    String zoneName;
}

class Zone {
    String zoneName;
    ZoneType zoneType;
}