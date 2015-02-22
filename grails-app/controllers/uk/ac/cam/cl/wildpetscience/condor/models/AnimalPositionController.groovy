package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnimalPositionController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index() {
        respond Client.get(params.ClientId).positions, [status: OK];
    }

    @Transactional
    def save(AnimalPosition position) {
        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        position.validate()
        if (position.hasErrors()) {
            respond position.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        Client c = Client.get(params.ClientId);
        c.addToPositions(position);
        c.save flush:true;
        respond position, [status: CREATED];
    }

    @Transactional
    def update(AnimalPosition position) {
        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        position.validate()
        if (position.hasErrors()) {
            respond position.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        position.save flush:true
        respond position, [status: OK];
    }

    @Transactional
    def delete(AnimalPosition positon) {
        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        position.delete flush:true
        render status: NO_CONTENT;
    }
}