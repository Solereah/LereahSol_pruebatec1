package com.empresajpa.empleadojpa;

import com.empresajpa.empleadojpa.logica.Empleado;
import com.empresajpa.empleadojpa.persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class EmpleadoJpa {

    public static void main(String[] args) {

        //variables
        int opcion;
        String respuesta;
        Double opcDbl;
        boolean bandera = false;
        Empleado empleEncontrado;
        ArrayList<Empleado> listaEmpleados;

        //Creo instancia de la clase Empleado
        Empleado empleado = new Empleado();

        //Creo Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);

        //Creamos la tabla empleado
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        //Menu de inicio
        System.out.println("""
        ------------------- Bienvenido a HRConnect -------------------
                           
                Aquí encontrarás todas las herramientas necesarias 
                para optimizar la administración de recursos humanos.                       
              
                            """);
        System.out.println("""
        -------------- Menú inicio --------------         
        Ingrese la opción que desea realizar:
                           
        1.Agregar un nuevo empleado 
                           
        2.Listar empleados
                           
        3.Actualizar información de un empleado
                           
        4.Eliminar un empleado
                           
        5.Buscar empleados por cargo
            
        Pulse 0 para salir               
        """);

        do {

            //Comienzo del programa
            System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir:");
            opcion = teclado.nextInt();

            //Si la opción ingresada es salir cambia el estado de la bandera
            if (opcion == 0) {
                bandera = true;
            }

            //Evalúo si el número ingresado está dentro del rango de opciones 
            if (opcion < 0 || opcion > 5) {
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
            } //Crear empleado
            else if (opcion == 1) {
                System.out.println("Ingrese el nombre: ");
                respuesta = teclado.next();
                empleado.setNombre(respuesta);

                System.out.println("Ingrese el apellido: ");
                respuesta = teclado.next();
                empleado.setApellido(respuesta);

                System.out.println("Ingrese el cargo: ");
                respuesta = teclado.next();
                empleado.setCargo(respuesta);

                System.out.println("Ingrese el salario: ");
                opcDbl = teclado.nextDouble();
                empleado.setSalario(opcDbl);

                System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    respuesta = teclado.next();
                    Date fechaInit = sdf.parse(respuesta);
                    empleado.setFechaInicio(fechaInit);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha no válido. Introduce la fecha en el formato YYYY-MM-DD.");
                }
                controlPersis.crearEmpleado(empleado);

                System.out.println("El empleado se ha agregado con exito: " + empleado.toString());
            } //Mostrar lista de empleados
            else if (opcion == 2) {

                System.out.println("------------- Empleados Registrados-------------");
                listaEmpleados = controlPersis.traerEmpleados();

                for (Empleado emp : listaEmpleados) {
                    System.out.println(emp.toString());
                }
            } //Modificar empleado
            else if (opcion == 3) {

                while (opcion != 0) {

                    System.out.println("Ingrese el id del empleado que desea modificar o presione 0 para salir: ");
                    opcion = teclado.nextInt();

                    //Submenu para modificar los datos del empleado
                    //Mostrar el empleado a modificar
                    try {
                        empleEncontrado = controlPersis.traerEmpleado(opcion);
                        System.out.println("El empleado a modificar es: " + controlPersis.traerEmpleado(opcion));
                        System.out.println("""
                                ----------Editar Empleado------------   
                                Ingrese el campo que desea modificar:
                                1.Nombre
                                2.Apellido
                                3.Cargo
                                4.Salario
                                5.Fecha de inicio
                                Pulse 0 para volver al menú principal   
                                                   """);
                        opcion = teclado.nextInt();
                        //Evalúo que el número esté dentro del rango de opciones
                        if (opcion < 0 || opcion > 5) {
                            System.out.println("Debe ingresar un número del 1 al 5 o para volver al menú principal:");
                            System.out.println("Ingrese su opcion: ");
                            opcion = teclado.nextInt();
                        }
                        //Lógica para modificar el nombre
                        if (opcion == 1) {
                            System.out.println("Ha seleccionado modificar el nombre.");
                            System.out.println("Ingrese el valor a modificar: ");
                            respuesta = teclado.next();

                            empleEncontrado.setNombre(respuesta);
                            controlPersis.modificarEmpleado(empleEncontrado);
                        }
                        //Lógica para modificar el apellido
                        if (opcion == 2) {
                            System.out.println("Ha seleccionado modificar el apellido.");
                            System.out.println("Ingrese el valor a modificar: ");
                            respuesta = teclado.next();

                            empleEncontrado.setApellido(respuesta);
                            controlPersis.modificarEmpleado(empleEncontrado);
                        }
                        // Lógica para modificar el cargo
                        if (opcion == 3) {
                            System.out.println("Ha seleccionado modificar el cargo.");
                            System.out.println("Ingrese el valor a modificar: ");
                            respuesta = teclado.next();

                            empleEncontrado.setCargo(respuesta);
                            controlPersis.modificarEmpleado(empleEncontrado);
                        }
                        // Lógica para modificar el salario
                        if (opcion == 4) {
                            System.out.println("Ha seleccionado modificar el salario.");
                            System.out.println("Ingrese el valor a modificar: ");
                            opcDbl = teclado.nextDouble();

                            empleEncontrado.setSalario(opcDbl);
                            controlPersis.modificarEmpleado(empleEncontrado);
                        }
                        // Lógica para modificar la fecha de inicio
                        if (opcion == 5) {
                            System.out.println("Ha seleccionado modificar la fecha de inicio.");

                            System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                respuesta = teclado.next();
                                Date fechaInit = sdf.parse(respuesta);
                                empleEncontrado.setFechaInicio(fechaInit);
                                controlPersis.modificarEmpleado(empleEncontrado);
                            } catch (ParseException e) {
                                System.out.println("Formato de fecha no válido. Introduce la fecha en el formato YYYY-MM-DD.");
                            }
                        }
                        System.out.println("El empleado se ha modificado con éxito: " + empleEncontrado.toString());
                    } catch (Exception e) {
                        System.out.println("Error en el id, el empleado no existe.");
                    }
                }
            } //Eliminar empleado
            else if (opcion == 4) {
                try {
                    System.out.println("Ingrese el id del empleado a eliminar: ");
                    opcion = teclado.nextInt();
                    empleEncontrado = controlPersis.traerEmpleado(opcion);

                    System.out.println(empleEncontrado.toString());
                    System.out.println("Está seguro que desea eliminar el empleado? Presione 'y' para borrar o cualquier otra tecla para volver al menú principal:");

                    if (teclado.next().equalsIgnoreCase("y")) {
                        controlPersis.eliminarEmpleado(opcion);
                        System.out.println("El empleado ha sido eliminado correctamente.");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Error en el id, el empleado que intenta eliminar no existe.");
                }

            } //Filtrar empleados por cargo
            else if (opcion == 5) {
                System.out.println("Ingrese el cargo por el cual desea filtrar: ");
                respuesta = teclado.next();
                listaEmpleados = controlPersis.traerEmpleados();
                System.out.println("-------------Empleados filtrados por cargo-------------");

                //Recorro la lista de empleados fitrando por el cargo y comparo con el valor ingresado
                for (Empleado emple : listaEmpleados) {

                    if (respuesta.equalsIgnoreCase(emple.getCargo())) {
                        System.out.println(emple.toString());
                    }
                }
            }

        } while (!bandera);

        //Finalizo programa
        System.out.println("Ha cerrado sesión. Gracias por usar nuestros servicios");
    }
}
