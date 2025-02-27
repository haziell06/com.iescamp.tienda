import java.util.ArrayList;
import java.util.Objects;

public class Plantilla {
    private ArrayList<Empleado> plantillas = new ArrayList<>();

    public Plantilla(ArrayList<Empleado> plantillas) {
        this.plantillas = plantillas;
    }

    public ArrayList<Empleado> getPlantillas() {
        return plantillas;
    }

    public void setPlantillas(ArrayList<Empleado> plantillas) {
        this.plantillas = plantillas;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plantillas);
    }

    public boolean buscarDNI(String DNI) {
        for (Empleado e : plantillas) {
            if (e.getDNI().equals(DNI)) {
                return true;
            }
        }
        return false;
    }

    public boolean filtarDep(String Dep) {
        for (Empleado e : plantillas) {
            if (e.getDepartamento().equals(Dep)) {
                return true;
            }
        }
        return false;
    }
    public boolean filtarAdmin(String Admin) {
        for (Empleado e : plantillas) {
            if (e.isTienePrivilegios()) {
                return true;
            }
        }
        return false;
    }
    public boolean filtarNom(String Nom, String Apellidos) {
        for (Empleado e : plantillas) {
            if ((e.getNombre().equals(Nom) && (e.getApellidos().equals(Apellidos)))) {
                return true;
            }
        }
        return false;
    }
}