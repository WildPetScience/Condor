package uk.ac.cam.cl.wildpetscience.condor.models;

import uk.ac.cam.cl.wildpetscience.condor.models.ZoneType;

class Zone {
    int zoneId;
    ZoneType zoneType;
    static embedded = ['zoneType'];
}