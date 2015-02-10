package uk.ac.cam.cl.wildpetscience.condor.models



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PositionsController {

    static responseFormats = ['json', 'xml']

    static allowedMethods = [save: "POST"]

    def index() {
        /*def clientId = params.ClientId;
        Client c = Client.get(clientId);
        AnimalPosition p = new AnimalPosition(time: 1, zoneId: 1, coordinates: new SpatialCoordinates());

        Zone z = new Zone(zoneType: ZoneType.first(), zoneId: 1);

        //c.addToZones(z);
        c.addToPositions(p);*/
        /*def clientId = params.ClientId;
        Client c = Client.get(clientId);
        Coordinate coo = new Coordinate(axis: "x", position: 1.0);
        AnimalPosition p = c.positions.first();
        p.addToCoordinates(coo);
        p.save();
        c.save();*/
        respond Client.get(params.ClientId).positions, [status: OK]
    }

    @Transactional
    def save(AnimalPosition position) {
        if (position == null) {
            render status: NOT_FOUND
            return
        }

        position.validate()
        if (position.hasErrors()) {
            response position.errors.getAllErrors(), [status: NOT_ACCEPTABLE]
            return
        }

        Client c = Client.get(params.ClientId);
        c.addToPositions(position);
        c.save flush:true
        respond position, [status: CREATED]
    }
}
