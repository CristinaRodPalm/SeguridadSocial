/**
 * Created by Cristina on 19/09/2016.
 */
public class Persona {

    String dni;
    String numSeguridadSocial;
    String nombre;
    String apellidos;
    int edad;
    Double salario;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSegSocial) {
        this.numSeguridadSocial = numSegSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Persona(){
    }

    public Persona(String dni, String numSegSocial, String nombre, String apellidos, int edad, Double salario) {
        this.dni = dni;
        this.numSeguridadSocial = numSegSocial;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salario = salario;
    }
}
