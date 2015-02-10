package uk.ac.cam.cl.wildpetscience.condor.models



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnimalTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AnimalType.list(params), model:[animalTypeInstanceCount: AnimalType.count()]
    }

    def show(AnimalType animalTypeInstance) {
        respond animalTypeInstance
    }

    def create() {
        respond new AnimalType(params)
    }

    @Transactional
    def save(AnimalType animalTypeInstance) {
        if (animalTypeInstance == null) {
            notFound()
            return
        }

        if (animalTypeInstance.hasErrors()) {
            respond animalTypeInstance.errors, view:'create'
            return
        }

        animalTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'animalType.label', default: 'AnimalType'), animalTypeInstance.id])
                redirect animalTypeInstance
            }
            '*' { respond animalTypeInstance, [status: CREATED] }
        }
    }

    def edit(AnimalType animalTypeInstance) {
        respond animalTypeInstance
    }

    @Transactional
    def update(AnimalType animalTypeInstance) {
        if (animalTypeInstance == null) {
            notFound()
            return
        }

        if (animalTypeInstance.hasErrors()) {
            respond animalTypeInstance.errors, view:'edit'
            return
        }

        animalTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AnimalType.label', default: 'AnimalType'), animalTypeInstance.id])
                redirect animalTypeInstance
            }
            '*'{ respond animalTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AnimalType animalTypeInstance) {

        if (animalTypeInstance == null) {
            notFound()
            return
        }

        animalTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AnimalType.label', default: 'AnimalType'), animalTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'animalType.label', default: 'AnimalType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
