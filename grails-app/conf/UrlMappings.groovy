class UrlMappings {

	static mappings = {
        "/api/clients"(resources:"Client", excludes:['create', 'show', 'edit', 'patch']) {
            "/api/positions"(resources:"AnimalPosition", excludes:['create', 'show', 'edit', 'patch'])
            "/api/zones"(resources:"Zone", excludes:['create', 'show', 'edit', 'patch'])
		}
        "/api/animals"(resources:"AnimalType",  excludes:['create', 'show', 'edit', 'patch'])
        "/api/zonetypes"(resources:"ZoneType",  excludes:['create', 'show', 'edit', 'patch'])

        // Put extra URL mappings here. String on the left is the URL, string
        // on the right is the name of the GSP file without .gsp
        "/test/"(view:"/test/index")

        "/"(view:"/index")
	}
}
