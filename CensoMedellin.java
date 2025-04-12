
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CensoMedellin {
    private Queue<Persona> personas = new LinkedList<>();
    private final double SALARIO_MINIMO = 1300000; // Valor del salario mínimo

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n------ CENSO MEDELLÍN ------");
            System.out.println("1. Registrar persona");
            System.out.println("2. Ver personas censadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
         // Me falta el metodo validación
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarPersona(scanner);
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println(" ✘ Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void registrarPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        System.out.print("¿Es desplazado? (si/no): ");
        String desplazado = scanner.next();
        boolean esDesplazado = desplazado.equalsIgnoreCase("si");

        System.out.print("Estrato (1-6): ");
        int estrato = scanner.nextInt();

        Persona persona = new Persona(nombre, cedula, edad, esDesplazado, estrato);
        persona.setAuxilio(SALARIO_MINIMO);

        personas.add(persona);
        System.out.println("✔ Persona registrada exitosamente.\n");
    }



    private void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("✘ No hay personas registradas.\n");
        } else {
            for (Persona p : personas) {
                System.out.println("-------------------------------");
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Cédula: " + p.getCedula());
                System.out.println("Edad: " + p.getEdad());
                System.out.println("Desplazado: " + (p.getEsDesplazado() ? "Sí" : "No"));
                System.out.println("Estrato: " + p.getEstrato());
                System.out.println("Recibe Auxilio: " + (p.getRecibeAuxilio() ? "Sí" : "No"));
                System.out.println("Auxilio: $" + p.getAuxilio());
            }
            System.out.println("-------------------------------\n");
        }
    }


}
