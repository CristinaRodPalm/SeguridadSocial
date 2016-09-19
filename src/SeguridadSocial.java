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

    public void altaPersona(Persona persona) {
        //añadimos a la persona (ya creada) al arrayList de personas en la SS

        personasList.add(persona);
    }

    public void bajaPersona(String dni) {
        /*for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getDni().equals(dni)){
                personasList.remove(i);
                i = personasList.size();
            }
        }*/

        personasList.removeIf(persona -> persona.getDni().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getDni() == dni) {
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return null;
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getNumSeguridadSocial() == numSS) {
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return null;
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        // creamos un arraylist en el que poder añadir a aquellas personas que estén en el rango
        List<Persona> personasRango = new ArrayList<>();

        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);

            if (aux.getSalario() > min && aux.getSalario() > min) {
                // si cumplen la condición se añade al arraylist
                personasRango.add(aux);
            }
        }
        // devolvemos el array con aquellas personas que lo cumplen
        return personasRango;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        // creamos un arraylist en el que poder añadir a aquellas personas que estén en el rango
        List<Persona> personasRango = new ArrayList<>();

        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);

            if (aux.getEdad() > edad){
                // si cumplen la condición se añade al arraylist
                personasRango.add(aux);
            }
        }
        // devolvemos el array con aquellas personas que lo cumplen
        return personasRango;
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    // Ej2
    public Persona obtenerSalarioMaximo(double max){
        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getSalario() > max) {
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return null;
    }
    // Ej2
    public Persona obtenerSalarioMinimo(double min){
        Persona aux = new Persona();
        for (int i = 0; i < personasList.size(); i++) {
            aux = personasList.get(i);
            if (aux.getSalario() < min){
                min = aux.getSalario();
                // si la encuentra devuelve a esa persona
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return aux;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}
