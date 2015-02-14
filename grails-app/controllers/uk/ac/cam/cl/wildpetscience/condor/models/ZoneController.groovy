package uk.ac.cam.cl.wildpetscience.condor.models

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class ZoneController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index() {
        respond Client.get(params.ClientId).zones, [status: OK];
    }

    @Transactional
    def save(Zone zone) {
        if (zone == null) {
            render status: NOT_FOUND;
            return;
        }

        zone.validate()
        if (zone.hasErrors()) {
            respond zone.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        Client c = Client.get(params.ClientId);
        c.addToZones(zone);
        c.save flush:true;
        respond zone, [status: CREATED];
    }

    @Transactional
    def update(Zone zone) {
        if (zone == null) {
            render status: NOT_FOUND;
            return;
        }

        zone.validate()
        if (zone.hasErrors()) {
            respond zone.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        zone.save flush:true
        respond zone, [status: OK];
    }

    @Transactional
    def delete(Zone zone) {
        if (zone == null) {
            render status: NOT_FOUND;
            return;
        }

        zone.delete flush:true
        render status: NO_CONTENT;
    }
}