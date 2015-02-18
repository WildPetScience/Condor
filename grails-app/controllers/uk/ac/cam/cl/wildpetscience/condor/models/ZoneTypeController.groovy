package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ZoneTypeController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ZoneType.list(params), model:[clientInstanceCount: Client.count()]
    }

    @Transactional
    def save(ZoneType zt) {
        if (zt == null) {
            render status: NOT_FOUND;
            return;
        }

        zt.validate()
        if (zt.hasErrors()) {
            respond zt.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        zt.save flush:true;
        respond zt, [status: CREATED];
    }

    @Transactional
    def update(ZoneType zt) {
        if (zt == null) {
            render status: NOT_FOUND;
            return;
        }

        zt.validate()
        if (zt.hasErrors()) {
            respond zt.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        zt.save flush:true
        respond zt, [status: OK];
    }

    @Transactional
    def delete(ZoneType zt) {
        if (zt == null) {
            render status: NOT_FOUND;
            return;
        }

        zt.delete flush:true
        render status: NO_CONTENT;
    }
}