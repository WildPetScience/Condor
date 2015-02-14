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
		}

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
