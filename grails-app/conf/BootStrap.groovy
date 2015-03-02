import uk.ac.cam.cl.wildpetscience.condor.models.Admin

class BootStrap {

    def init = { servletContext ->
        String accessKey = "Knx1Y1S2hc";
        Admin a = Admin.findByAccessKey(accessKey);
        if (a == null) {
            a = new Admin(name: "Main", accessKey: "Knx1Y1S2hc");
            a.save();
        }
    }
    def destroy = {
    }
}
