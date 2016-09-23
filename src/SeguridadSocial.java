/**
 * Created by Cristina on 19/09/2016.
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeguridadSocial {

    private List<Persona> personasList;

    HashMap<String, Persona> dniHashMap;
    HashMap<String, Persona> ssHashMap;

    public SeguridadSocial() {
        personasList = new ArrayList<>();
        dniHashMap = new HashMap<>();
        ssHashMap = new HashMap<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {

        boolean repetida = personasList.stream().anyMatch(p -> p.getDni().equals(persona.getDni())
                  || p.getNumSeguridadSocial().equals(persona.getNumSeguridadSocial()));

        if(!repetida){
            dniHashMap.put(persona.getDni(), persona);
            ssHashMap.put(persona.getNumSeguridadSocial(), persona);
        }

        /*boolean alta = true;

        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getDni().equals(persona.getDni())){
                System.out.println("DNI "+persona.getDni()+" en uso");
                alta = false;
            }
            if (aux.getNombre().equals(persona.getNombre())) {
                System.out.println("Nombre "+persona.getNombre()+" en uso");
                alta = false;
            }
        }

        if(alta == true) personasList.add(persona);
        */

    }

    public void bajaPersona(String dni) {
        /*for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getDni().equals(dni)){
                personasList.remove(i);
                i = personasList.size();
            }
        }*/

        //personasList.removeIf(persona -> persona.getDni().equals(dni));

        // CON HASHMAP
        dniHashMap.remove(dni);

    }

    public Persona obtenerPersonaPorDNI(String dni) {
        /*
        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getDni() == dni) {
                return aux;
            }
        }
        return null;
        */

        // CON HASHMAP
        return dniHashMap.get(dni);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        /*
        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getNumSeguridadSocial() == numSS) {
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return null;
        */

        // CON HASHMAP
        return ssHashMap.get(numSS);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        // coje los valores del hashmap de dni (como pillar la lista),
        return dniHashMap.values().stream().filter(p -> p.getSalario() > min && p.getSalario() < max).collect(Collectors.toList());

        /*
        List<Persona> personasRango = new ArrayList<>();

        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);

            if (aux.getSalario() > min && aux.getSalario() > min) {
                personasRango.add(aux);
            }
        }
        return personasRango;
        */
    }

    public Collection<Persona> obtenerPersonasMayoresQue(int edad){
        return dniHashMap.values().stream().filter(p -> p.getEdad() > edad).collect(Collectors.toList());

        /*
        List<Persona> personasRango = new ArrayList<>();

        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);

            if (aux.getEdad() > edad){
                personasRango.add(aux);
            }
        }
        return personasRango;
        */
    }

    public Collection<Persona> obtenerTodas(){
        return dniHashMap.values();
    }

    public void obtenerSalarioMaximo(){
         dniHashMap.values().stream().max(Comparator.comparing(Persona::getSalario)).ifPresent(maxInt -> System.out.println("El salario máximo es "+maxInt));

        /*
        double max = Double.MIN_VALUE;


        for (int i = 0; i < personasList.size(); i++) {
            Persona aux = personasList.get(i);
            if (aux.getSalario() > max) {
                max = aux.getSalario();
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return null;
        */

    }

    public void obtenerSalarioMinimo(){
        dniHashMap.values().stream().min(Comparator.comparing(Persona::getSalario)).ifPresent(min -> System.out.println("El salario mínimo es "+min));

        /*
        double min = Double.MAX_VALUE;

        Persona aux = new Persona();
        for (int i = 0; i < personasList.size(); i++) {
            aux = personasList.get(i);
            if (aux.getSalario() < min){
                min = aux.getSalario();
                // si la encuentra devuelve a esa persona
                return aux;
            }
        }
        //si acaba y no la encuentra, devuelve null (no encontrado)
        return aux;
        */
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}
