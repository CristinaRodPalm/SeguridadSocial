/**
 * Created by Cristina on 19/09/2016.
 */

import java.util.ArrayList;
import java.util.List;

public class SeguridadSocial {

    private List<Persona> personasList;

    public SeguridadSocial() {

        personasList = new ArrayList<>();

    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social

    public void altaPersona(Persona persona) {}

    public void bajaPersona(String dni) {}

    public Persona obtenerPersonaPorDNI(String dni) {
        return;
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        return;
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        return;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return;
    }

    public List<Persona> obtenerTodas(){
        return;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}
