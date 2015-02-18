package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClientController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Client.list(params), model:[clientInstanceCount: Client.count()]
    }

    @Transactional
    def save(Client client) {
        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        client.validate()
        if (client.hasErrors()) {
            respond client.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        client.save flush:true;
        respond client, [status: CREATED];
    }

    @Transactional
    def update(Client client) {
        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        client.validate()
        if (client.hasErrors()) {
            respond client.errors.getAllErrors(), [status: NOT_ACCEPTABLE];
            return;
        }

        client.save flush:true
        respond client, [status: OK];
    }

    @Transactional
    def delete(Client client) {
        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        client.delete flush:true
        render status: NO_CONTENT;
    }
}
