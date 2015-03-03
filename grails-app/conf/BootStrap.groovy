import uk.ac.cam.cl.wildpetscience.condor.models.Admin
import uk.ac.cam.cl.wildpetscience.condor.models.AnimalType

class BootStrap {

    def init = { servletContext ->
        String accessKey = "Knx1Y1S2hc";
        Admin a = Admin.findByAccessKey(accessKey);
        if (a == null) {
            a = new Admin(name: "Main", accessKey: "Knx1Y1S2hc");
            a.save();
        }

        String[] types = ["Hamster", "Cat", "Dog"];
        for (String type : types) {
            AnimalType at = AnimalType.findByName(type);
            if (at != null) continue;
            at = new AnimalType(name: type);
            at.save();
        }
    }
    def destroy = {
    }
}
