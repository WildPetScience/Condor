package uk.ac.cam.cl.wildpetscience.condor.models;

class AnimalType {
    String name;
    static constraints = {
        name blank: false, size: 2..150, unique: true
    }
}
