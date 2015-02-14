class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/clients"(resources:"Client", excludes:['create', 'show', 'edit', 'patch']) {
            "/positions"(resources:"AnimalPosition", excludes:['create', 'show', 'edit', 'patch'])
            "/zones"(resources:"Zone", excludes:['create', 'show', 'edit', 'patch'])
		}

        "/animals"(resources:"AnimalType",  excludes:['create', 'show', 'edit', 'patch'])
        "/zonetypes"(resources:"ZoneType",  excludes:['create', 'show', 'edit', 'patch'])

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
