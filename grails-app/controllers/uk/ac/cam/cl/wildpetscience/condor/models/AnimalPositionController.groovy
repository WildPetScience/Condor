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
        Client c = Client.get(params.ClientId);
        if (c == null || !c.accessKey.equals(params.accessKey)) {
            render status: UNAUTHORIZED;
            return;
        }

        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        if (position.zone != null) {
            Zone z = c.zones.find { it.zoneName.equals(position.zone.zoneName) };
            if (z == null) {
                render status: NOT_ACCEPTABLE
                return;
            }
            position.zone = z;
        }

        position.validate()
        if (position.hasErrors()) {
            respond position.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        c.addToPositions(position);
        c.save flush:true;
        respond position, [status: CREATED];
    }

    @Transactional
    def update(AnimalPosition position) {
        Client c = Client.get(params.ClientId);
        if (c == null || !c.accessKey.equals(params.accessKey)) {
            render status: UNAUTHORIZED;
            return;
        }

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
    def delete(AnimalPosition position) {
        Client c = Client.get(params.ClientId);
        if (c == null || !c.accessKey.equals(params.accessKey)) {
            render status: UNAUTHORIZED;
            return;
        }

        if (position == null) {
            render status: NOT_FOUND;
            return;
        }

        position.delete flush:true
        render status: NO_CONTENT;
    }
}