<%@ page import="uk.ac.cam.cl.wildpetscience.condor.models.ZoneType" %>



<div class="fieldcontain ${hasErrors(bean: zoneTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="zoneType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${zoneTypeInstance?.name}" />

</div>

