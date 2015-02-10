package uk.ac.cam.cl.wildpetscience.condor.models



import grails.test.mixin.*
import spock.lang.*

@TestFor(ZoneTypeController)
@Mock(ZoneType)
class ZoneTypeControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.zoneTypeInstanceList
            model.zoneTypeInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.zoneTypeInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def zoneType = new ZoneType()
            zoneType.validate()
            controller.save(zoneType)

        then:"The create view is rendered again with the correct model"
            model.zoneTypeInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            zoneType = new ZoneType(params)

            controller.save(zoneType)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/zoneType/show/1'
            controller.flash.message != null
            ZoneType.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def zoneType = new ZoneType(params)
            controller.show(zoneType)

        then:"A model is populated containing the domain instance"
            model.zoneTypeInstance == zoneType
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def zoneType = new ZoneType(params)
            controller.edit(zoneType)

        then:"A model is populated containing the domain instance"
            model.zoneTypeInstance == zoneType
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/zoneType/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def zoneType = new ZoneType()
            zoneType.validate()
            controller.update(zoneType)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.zoneTypeInstance == zoneType

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            zoneType = new ZoneType(params).save(flush: true)
            controller.update(zoneType)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/zoneType/show/$zoneType.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/zoneType/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def zoneType = new ZoneType(params).save(flush: true)

        then:"It exists"
            ZoneType.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(zoneType)

        then:"The instance is deleted"
            ZoneType.count() == 0
            response.redirectedUrl == '/zoneType/index'
            flash.message != null
    }
}
