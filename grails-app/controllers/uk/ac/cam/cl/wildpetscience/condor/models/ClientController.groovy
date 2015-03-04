package uk.ac.cam.cl.wildpetscience.condor.models

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClientController {
    static responseFormats = ['json', 'xml'];
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"];

    def index() {
        AnimalType at = AnimalType.findByName(params.animalType);
        if (at != null) {
            respond Client.findAllByAnimalType(at, [sort: "identifier"]);
            return;
        }

        respond Client.list();
    }

    def show() {
        Client client = Client.findByIdentifier(params.id);

        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        respond client;
    }

    @Transactional
    def save(Client client) {
        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        if (client.animalType != null) {
            AnimalType at = AnimalType.findByName(client.animalType.name);
            if (client.animalType.name.isEmpty() || at == null) {
                render status: NOT_ACCEPTABLE
            }

            client.animalType = at;
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
        Client c = Client.get(client.id);
        if (c == null || !c.accessKey.equals(params.accessKey)) {
            render status: UNAUTHORIZED;
            return;
        }

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
        Client c = Client.get(client.id);
        if (c == null || !c.accessKey.equals(params.accessKey)) {
            render status: UNAUTHORIZED;
            return;
        }

        if (client == null) {
            render status: NOT_FOUND;
            return;
        }

        client.delete flush:true
        render status: NO_CONTENT;
    }
}
