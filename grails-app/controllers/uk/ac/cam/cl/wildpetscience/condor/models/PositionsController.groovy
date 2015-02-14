package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PositionsController {
    static responseFormats = ['json', 'xml']

    static allowedMethods = [save: "POST"]

    def index() {
        int clientId = params.clientId;
        respond Client.get(clientId).positions, [status: OK];
    }

    @Transactional
    def save(AnimalPosition position) {
        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        position.validate()
        if (position.hasErrors()) {
            response position.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        int clientId = params.clientId;
        Client c = Client.get(clientId);
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
            response position.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
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
