/**
 * Created by Cristina on 19/09/2016.
 */

import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial {

    private HashMap<String, Persona> dniHashMap;
    private HashMap<String, Persona> ssHashMap;


    public SeguridadSocial() {
        dniHashMap = new HashMap<>();
        ssHashMap = new HashMap<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {

        boolean repetida = dniHashMap.values().stream().anyMatch(p -> p.getDni().equals(persona.getDni())
                  || p.getNumSeguridadSocial().equals(persona.getNumSeguridadSocial()));

        if(!repetida){
            dniHashMap.put(persona.getDni(), persona);
            ssHashMap.put(persona.getNumSeguridadSocial(), persona);
        }
    }

    public void bajaPersona(String dni) {
        dniHashMap.remove(dni);
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        return dniHashMap.get(dni);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        return ssHashMap.get(numSS);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        return dniHashMap.values().stream().filter(p -> p.getSalario() > min && p.getSalario() < max).collect(Collectors.toList());
    }

    public Collection<Persona> obtenerPersonasMayoresQue(int edad){
        return dniHashMap.values().stream().filter(p -> p.getEdad() > edad).collect(Collectors.toList());
    }

    public Collection<Persona> obtenerTodas(){
        return dniHashMap.values();
    }

    // EJERCICIO 2
    //dniHashMap.values().stream().max(Comparator.comparing(Persona::getSalario)).ifPresent(maxInt -> System.out.println("El salario máximo es "+maxInt));
    //dniHashMap.values().stream().min(Comparator.comparing(Persona::getSalario)).ifPresent(min -> System.out.println("El salario mínimo es "+min));
    // .ifPresent nos permite, si se encuentra, guardar el resultado en una variable sin tipo y tratarla, en este caso, imprimir.
    // Para obtener el dato devuelto como variable, debemos hacer un .get()

    public Persona obtenerSalarioMaximo(){
        return dniHashMap.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }

    public Persona obtenerSalarioMinimo(){
        return dniHashMap.values().stream().min(Comparator.comparing(Persona::getSalario)).get();
    }

    // EJERCICIO 3

    public List<Persona> obtenerOrdenDni(){
        ArrayList<Persona> ordenDni = new ArrayList<>(dniHashMap.values());

        ordenDni.sort(Comparator.comparing(Persona::getDni));

        return ordenDni;

    }

/*
    public Collection<Persona> obtenerOrdenNumSS(){

    }

    public Collection<Persona> obtenerOrdenNombre(){

    }

    public Collection<Persona> obtenerOrdenApellidos(){

    }

    public Collection<Persona> obtenerOrdenEdad(){

    }

    public Collection<Persona> obtenerOrdenSalario(){

    }
*/
}
