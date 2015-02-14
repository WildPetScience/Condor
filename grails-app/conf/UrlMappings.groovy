class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/clients"(resources:"Client") {
            "/positions"(controller:"Positions", method:"GET", action:"index")
            "/positions"(controller:"Positions", method:"POST", action:"save")
            "/positions"(controller:"Positions", method:"PUT", action:"update")
            "/positions"(controller:"Positions", method:"DELETE", action:"delete")
            "/zones"(controller:"Positions", method:"GET", action:"index")
            "/zones"(controller:"Positions", method:"POST", action:"save")
            "/zones"(controller:"Positions", method:"PUT", action:"update")
            "/zones"(controller:"Positions", method:"DELETE", action:"delete")
		}

        "/animals"(resources:"AnimalType")
        "/zonetypes"(resources:"ZoneType")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
