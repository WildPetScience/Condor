<%@ page import="uk.ac.cam.cl.wildpetscience.condor.models.AnimalType" %>



<div class="fieldcontain ${hasErrors(bean: animalTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="animalType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${animalTypeInstance?.name}" />

</div>

