class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/clients"(resources:"Client", excludes:['create', 'show', 'edit', 'patch']) {
            "/positions"(controller:"Position", method:"GET", action:"index")
            "/positions"(controller:"Position", method:"POST", action:"save")
            "/positions"(controller:"Position", method:"PUT", action:"update")
            "/positions"(controller:"Position", method:"DELETE", action:"delete")
            "/zones"(controller:"Zone", method:"GET", action:"index")
            "/zones"(controller:"Zone", method:"POST", action:"save")
            "/zones"(controller:"Zone", method:"PUT", action:"update")
            "/zones"(controller:"Zone", method:"DELETE", action:"delete")
		}

        "/animals"(resources:"AnimalType",  excludes:['create', 'show', 'edit', 'patch'])
        "/zonetypes"(resources:"ZoneType",  excludes:['create', 'show', 'edit', 'patch'])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
