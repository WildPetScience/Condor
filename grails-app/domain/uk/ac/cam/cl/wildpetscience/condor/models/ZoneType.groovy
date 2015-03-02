package uk.ac.cam.cl.wildpetscience.condor.models;

class ZoneType {
    String name;
    static constraints = {
        name blank: false, size: 2..150, unique: true
    }
}
