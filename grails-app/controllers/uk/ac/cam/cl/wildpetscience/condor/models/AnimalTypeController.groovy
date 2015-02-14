package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnimalTypeController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Client.list(params), model:[clientInstanceCount: Client.count()]
    }

    @Transactional
    def save(AnimalType at) {
        if (at == null) {
            render status: NOT_FOUND;
            return;
        }

        at.validate()
        if (at.hasErrors()) {
            respond at.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        at.save flush:true;
        respond at, [status: CREATED];
    }

    @Transactional
    def update(AnimalType at) {
        if (at == null) {
            render status: NOT_FOUND;
            return;
        }

        at.validate()
        if (at.hasErrors()) {
            respond at.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        at.save flush:true
        respond at, [status: OK];
    }

    @Transactional
    def delete(AnimalType at) {
        if (at == null) {
            render status: NOT_FOUND;
            return;
        }

        at.delete flush:true
        render status: NO_CONTENT;
    }
}
