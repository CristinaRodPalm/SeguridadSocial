import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristina on 19/09/2016.
 */

public class Main {
    public static void main(String[] args) {
        SeguridadSocial seguridadSocial = new SeguridadSocial();

        Persona jose = new Persona("39425364H", "111111111", "Jose", "Tomás", 35, 45000.00);
        Persona maria =  new Persona("39425654W", "33333333", "Maria", "Gallego", 55, 61300.20);
        Persona carlos = new Persona("39425355Q", "22222222", "Carlos", "Torres", 22, 23000.00);
        Persona anna = new Persona("39425987J", "444444444", "Anna", "Pina", 26, 17654.88);

        seguridadSocial.altaPersona(jose);
        seguridadSocial.altaPersona(maria);
        seguridadSocial.altaPersona(carlos);
        seguridadSocial.altaPersona(anna);

        System.out.println("\nAltas a la seguridad social: " + seguridadSocial.obtenerTodas());

        System.out.println("\nBaja a la seguridad social: " + anna.toString());
        seguridadSocial.bajaPersona(anna.getDni());

        System.out.println("\nLista de afiliados a la S.S.: " + seguridadSocial.obtenerTodas());

        System.out.println("\nobtenerPersonaPorDNI: " + seguridadSocial.obtenerPersonaPorDNI(jose.getDni()));

        System.out.println("\nobtenerPersonaPorNumSS: " + seguridadSocial.obtenerPersonaPorNumSS(maria.getNumSeguridadSocial()));

        System.out.println("\nobtenerPersonasRangoSalarial: " + seguridadSocial.obtenerPersonasRangoSalarial(23000.00, 61300.20));

        System.out.println("\nobtenerPersonasMayoresQue: " + seguridadSocial.obtenerPersonasMayoresQue(25));

        System.out.println("\nobtenerSalarioMaximo: "+ seguridadSocial.obtenerSalarioMaximo());

        System.out.println("\nobtenerSalarioMinimo: "+ seguridadSocial.obtenerSalarioMinimo());
    }
}
