package uk.ac.cam.cl.wildpetscience.condor.models;

class Client {
    Date dateConnected;

    AnimalType animalType;
    double cageWidth;
    double cageHeight;

    String identifier;
    String accessKey;

    List<AnimalPosition> positions;
    List<Zone> zones;

    static embedded = ['positions', 'zones'];
    static constraints = {
        identifier blank: false, size: 5..150, unique: true
        accessKey display: false, blank: false, size: 5..150
        animalType nullable: false
    }

    static {
        grails.converters.JSON.registerObjectMarshaller(Client) {
            return it.properties.findAll {k,v -> k != 'accessKey'}
        }
    }
}

class AnimalPosition {
    Date time;
    double x;
    double y;
    double speed;
    Zone zone;
}

class Zone {
    String zoneName;
    ZoneType zoneType;

    static constraints = {
        zoneName unique:true
        zoneType unique:true
    }
}