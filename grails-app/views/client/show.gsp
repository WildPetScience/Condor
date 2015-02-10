
<%@ page import="uk.ac.cam.cl.wildpetscience.condor.models.Client" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-client" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-client" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list client">
			
				<g:if test="${clientInstance?.animalType}">
				<li class="fieldcontain">
					<span id="animalType-label" class="property-label"><g:message code="client.animalType.label" default="Animal Type" /></span>
					
						<span class="property-value" aria-labelledby="animalType-label"><g:link controller="animalType" action="show" id="${clientInstance?.animalType?.id}">${clientInstance?.animalType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${clientInstance?.dateConnected}">
				<li class="fieldcontain">
					<span id="dateConnected-label" class="property-label"><g:message code="client.dateConnected.label" default="Date Connected" /></span>
					
						<span class="property-value" aria-labelledby="dateConnected-label"><g:formatDate date="${clientInstance?.dateConnected}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${clientInstance?.positions}">
				<li class="fieldcontain">
					<span id="positions-label" class="property-label"><g:message code="client.positions.label" default="Positions" /></span>
					
						<span class="property-value" aria-labelledby="positions-label"><g:fieldValue bean="${clientInstance}" field="positions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${clientInstance?.zones}">
				<li class="fieldcontain">
					<span id="zones-label" class="property-label"><g:message code="client.zones.label" default="Zones" /></span>
					
						<span class="property-value" aria-labelledby="zones-label"><g:fieldValue bean="${clientInstance}" field="zones"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:clientInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${clientInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
