class UrlMappings {

	static mappings = {
        "/api/clients"(resources:"Client", excludes:['create', 'show', 'edit', 'patch']) {
            "/positions"(resources:"AnimalPosition", excludes:['create', 'show', 'edit', 'patch'])
            "/zones"(resources:"Zone", excludes:['create', 'show', 'edit', 'patch'])
		}
        "/api/animals"(resources:"AnimalType",  excludes:['create', 'show', 'edit', 'patch'])
        "/api/zonetypes"(resources:"ZoneType",  excludes:['create', 'show', 'edit', 'patch'])

        "/"(view:"/index")
	}
}
