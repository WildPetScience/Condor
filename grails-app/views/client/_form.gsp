<%@ page import="uk.ac.cam.cl.wildpetscience.condor.models.Client" %>



<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'animalType', 'error')} ">
	<label for="animalType">
		<g:message code="client.animalType.label" default="Animal Type" />
		
	</label>
	<g:select id="animalType" name="animalType.id" from="${uk.ac.cam.cl.wildpetscience.condor.models.AnimalType.list()}" optionKey="id" required="" value="${clientInstance?.animalType?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'dateConnected', 'error')} ">
	<label for="dateConnected">
		<g:message code="client.dateConnected.label" default="Date Connected" />
		
	</label>
	<g:datePicker name="dateConnected" precision="day" value="${clientInstance?.dateConnected}" />

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'positions', 'error')} ">
	<label for="positions">
		<g:message code="client.positions.label" default="Positions" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'zones', 'error')} ">
	<label for="zones">
		<g:message code="client.zones.label" default="Zones" />
		
	</label>
	

</div>

