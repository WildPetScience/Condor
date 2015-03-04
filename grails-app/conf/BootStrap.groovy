import uk.ac.cam.cl.wildpetscience.condor.models.Admin
import uk.ac.cam.cl.wildpetscience.condor.models.AnimalType
import uk.ac.cam.cl.wildpetscience.condor.models.ZoneType

class BootStrap {

    def init = { servletContext ->
        // Admin
        String accessKey = "Knx1Y1S2hc";
        Admin a = Admin.findByAccessKey(accessKey);
        if (a == null) {
            a = new Admin(name: "Main", accessKey: "Knx1Y1S2hc");
            a.save();
        }

        // Animal Types
        String[] types = ["Hamster", "Cat", "Dog"];
        for (String type : types) {
            AnimalType at = AnimalType.findByName(type);
            if (at != null) continue;
            at = new AnimalType(name: type);
            at.save();
        }

        // Zone Types
        types = ["Water", "Food", "Exercise", "Bed"];
        for (String type : types) {
            ZoneType zt = ZoneType.findByName(type);
            if (zt != null) continue;
            zt = new ZoneType(name: type);
            zt.save();
        }
    }
    def destroy = {
    }
}
