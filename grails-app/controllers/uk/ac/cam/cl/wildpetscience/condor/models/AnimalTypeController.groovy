package uk.ac.cam.cl.wildpetscience.condor.models

import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnimalTypeController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index() {
        respond AnimalType.listOrderByName();
    }

    @Transactional
    def save(AnimalType at) {
        if (Admin.findByAccessKey(params.accessKey) == null) {
            render status: UNAUTHORIZED;
            return;
        }

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
        if (Admin.findByAccessKey(params.accessKey) == null) {
            render status: UNAUTHORIZED;
            return;
        }

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
        if (Admin.findByAccessKey(params.accessKey) == null) {
            render status: UNAUTHORIZED;
            return;
        }

        if (at == null) {
            render status: NOT_FOUND;
            return;
        }

        at.delete flush:true
        render status: NO_CONTENT;
    }
}
