/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoprogramado2;

import javax.swing.JOptionPane;

/**
 *
 * @author alvarados
 */
public class CasoProgramado2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Habitaciones[][] habitacion = new Habitaciones[5][5];
        habitacion[0][0] = new Habitaciones(102, "Doble", 70, "Disponible");
        habitacion[0][1] = new Habitaciones(103, "Suite", 120, "Sucia");
        habitacion[0][2] = new Habitaciones(104, "Doble", 70, "Disponible");
        habitacion[0][3] = new Habitaciones(105, "Sencilla", 50, "Ocupada");
        habitacion[0][4] = new Habitaciones(101, "Suite", 120, "Ocupada");
        
        habitacion[1][0] = new Habitaciones(203, "Suite", 120, "Sucia");
        habitacion[1][1] = new Habitaciones(204, "Doble", 70, "Disponible");
        habitacion[1][2] = new Habitaciones(205, "Sencilla", 50, "Disponible");
        habitacion[1][3] = new Habitaciones(201, "Suite", 120, "Disponible");
        habitacion[1][4] = new Habitaciones(202, "Doble", 70, "Ocupada");
        
        habitacion[2][0] = new Habitaciones(304, "Doble", 70, "Disponible");
        habitacion[2][1] = new Habitaciones(305, "Sencilla", 50, "Sucia");
        habitacion[2][2] = new Habitaciones(303, "Suite", 120, "Disponible");
        habitacion[2][3] = new Habitaciones(302, "Doble", 70, "Disponible");
        habitacion[2][4] = new Habitaciones(301, "Suite", 120, "Disponible");
        
        habitacion[3][0] = new Habitaciones(405, "Sencilla", 50, "Ocupada");
        habitacion[3][1] = new Habitaciones(403, "Suite", 120, "Ocupada");
        habitacion[3][2] = new Habitaciones(402, "Doble", 70, "Ocupada");
        habitacion[3][3] = new Habitaciones(401, "Suite", 120, "Disponible");
        habitacion[3][4] = new Habitaciones(404, "Doble", 70, "Disponible");
        
        habitacion[4][0] = new Habitaciones(503, "Suite", 120, "Disponible");
        habitacion[4][1] = new Habitaciones(502, "Doble", 70, "Disponible");
        habitacion[4][2] = new Habitaciones(501, "Suite", 120, "Ocupada");
        habitacion[4][3] = new Habitaciones(504, "Doble", 70, "Disponible");
        habitacion[4][4] = new Habitaciones(505, "Sencilla", 50, "Ocupada");
       
        int opcion;
        do {
            // Menu 
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Hotel Ruta 66\n\n"
                    + "1. Ver habitaciones por piso\n"
                    + "2. Reservar habitacion\n"
                    + "3. Informe de habitaciones\n"
                    + "4. Salir\n"
                    + "Seleccione una opcion:"
            ));

            switch (opcion) {
                case 1:
                    verHabitaciones(habitacion); 
                    break;
                case 2:
                    reservarHabitacion(habitacion); 
                    break;
                case 3:
                    //informe(habitaciones);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "hasta luego ");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "por favor seleccione una opcion de la lista");
            }

        } while (opcion != 3);
    }

    
    public static void verHabitaciones(Habitaciones[][] hotel) {
        int opcionPiso = Integer.parseInt(JOptionPane.showInputDialog(
            "Ingrese el numero de piso (1-5) para ver sus habitaciones disponibles:"));

        if (opcionPiso < 1 || opcionPiso > 5) {
            JOptionPane.showMessageDialog(null, "Numero de piso inválido. Debe ser entre 1 y 5.");
            return;
        }

        String mensaje = "Habitaciones del piso " + opcionPiso + ":\n";
        int piso = opcionPiso - 1;  

        
        for (int i = 0; i < hotel[piso].length; i++) {
            Habitaciones habitacion = hotel[piso][i];
            mensaje += "Habitacion " + habitacion.getNumero() + " - Tipo: " + habitacion.getTipo() +
                       ", Estado: " + habitacion.getEstado() + ", Precio: $" + habitacion.getPrecio() + "\n";
        }

        
        JOptionPane.showMessageDialog(null, mensaje);
    }

    
    public static void reservarHabitacion(Habitaciones[][] hotel) {
        int opcionPiso = Integer.parseInt(JOptionPane.showInputDialog(
            "Seleccione el numero de piso para ver las habitaciones disponibles:"));

        if (opcionPiso < 1 || opcionPiso > 5) {
            JOptionPane.showMessageDialog(null, "Numero de piso no existe. Seleccione entre 1 y 5.");
            return;
        }

        int piso = opcionPiso - 1;  
        String mensaje = "Habitaciones disponibles " + opcionPiso + ":\n";
        boolean hayDisponibles = false;

        
        for (int i = 0; i < hotel[piso].length; i++) {
            Habitaciones habitacion = hotel[piso][i];
            if (habitacion.getEstado().equals("Disponible")) {
                mensaje += "Habitacion " + habitacion.getNumero() + " - Tipo: " + habitacion.getTipo() +
                           ", Precio: $" + habitacion.getPrecio() + "\n";
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles en este piso");
            return;
        }

        
        int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog(
            mensaje + "\nIngrese el numero de habitacion que desea reservar:"));

        boolean habitacionReservada = false;

        
        for (int i = 0; i < hotel[piso].length; i++) {
            Habitaciones habitacion = hotel[piso][i];
            if (habitacion.getNumero() == numeroHabitacion && habitacion.getEstado().equals("Disponible")) {
                habitacion.setEstado("Ocupada");
                habitacionReservada = true;
                JOptionPane.showMessageDialog(null, "La habitacion " + numeroHabitacion + " ha sido reservada.");
                break;
            }
        }

        if (!habitacionReservada) {
            JOptionPane.showMessageDialog(null, "Habitacion no disponible");
        }
    }
    public static void informe(Habitaciones[][] hotel){
        int habitacionesDisponibles = 0;
        int habitacionesOcupadas = 0;
        int habitacionesSucias = 0;
        int ganancias = 0;
        
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; i < hotel.length; j++){
                Habitaciones habitaciones = hotel[i][j];
                
            }
            
        }
        
    }
    
}
                
            
        
                
    

