package uk.ac.cam.cl.wildpetscience.condor.models



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ZoneTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ZoneType.list(params), model:[zoneTypeInstanceCount: ZoneType.count()]
    }

    def show(ZoneType zoneTypeInstance) {
        respond zoneTypeInstance
    }

    def create() {
        respond new ZoneType(params)
    }

    @Transactional
    def save(ZoneType zoneTypeInstance) {
        if (zoneTypeInstance == null) {
            notFound()
            return
        }

        if (zoneTypeInstance.hasErrors()) {
            respond zoneTypeInstance.errors, view:'create'
            return
        }

        zoneTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'zoneType.label', default: 'ZoneType'), zoneTypeInstance.id])
                redirect zoneTypeInstance
            }
            '*' { respond zoneTypeInstance, [status: CREATED] }
        }
    }

    def edit(ZoneType zoneTypeInstance) {
        respond zoneTypeInstance
    }

    @Transactional
    def update(ZoneType zoneTypeInstance) {
        if (zoneTypeInstance == null) {
            notFound()
            return
        }

        if (zoneTypeInstance.hasErrors()) {
            respond zoneTypeInstance.errors, view:'edit'
            return
        }

        zoneTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ZoneType.label', default: 'ZoneType'), zoneTypeInstance.id])
                redirect zoneTypeInstance
            }
            '*'{ respond zoneTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ZoneType zoneTypeInstance) {

        if (zoneTypeInstance == null) {
            notFound()
            return
        }

        zoneTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ZoneType.label', default: 'ZoneType'), zoneTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'zoneType.label', default: 'ZoneType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
