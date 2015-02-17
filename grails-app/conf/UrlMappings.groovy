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
		}

        // Put extra URL mappings here. String on the left is the URL, string
        // on the right is the name of the GSP file without .gsp
        "/test/"(view:"/test/index")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
