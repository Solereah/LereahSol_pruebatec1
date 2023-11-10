package com.empresajpa.empleadojpa;

import com.empresajpa.empleadojpa.logica.Empleado;
import com.empresajpa.empleadojpa.persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;

public class EmpleadoJpa {

    public static void main(String[] args) {

        //variables
        int opcion;
        String respuesta = "";
        double opcDbl;
        boolean bandera = false;
        Date fechaInit = null;
        Empleado empleEncontrado;
        ArrayList<Empleado> listaEmpleados;

        //Creo instancia de la clase Empleado
        Empleado empleado = new Empleado();

        //Creo Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in);

        //Creamos la tabla empleado
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        //Menu de inicio
        System.out.println("""
        ------------------- Bienvenido a HRSoft -------------------
                           
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
        //Comienzo del programa
       

      while (!bandera){
            System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir:");
            opcion = teclado.nextInt();
            //Si la opción ingresada es salir cambia el estado de la bandera
            switch (opcion) {
                case 0:
                    bandera = true;
                    break;
            //Mostrar lista de empleados
                case 1:
                    //Evaluo que el dato sea string, ni esté vacío
                    do {
                        System.out.println("Por favor, ingrese un texto válido, el campo es requerido.");
                        System.out.println("Ingrese el nombre: ");
                        respuesta = teclado.next();
                        empleado.setNombre(respuesta);
                        
                        System.out.println("Ingrese el apellido: ");
                        respuesta = teclado.next();
                        empleado.setApellido(respuesta);
                        
                        System.out.println("Ingrese el cargo: ");
                        respuesta = teclado.next();
                        empleado.setCargo(respuesta);
                        
                    } while (respuesta.equals(" ") || !respuesta.matches("^[a-zA-Z]+$"));
                    do {
                        System.out.println("Ingrese el salario: ");
                        respuesta = teclado.next();
                        try {
                            opcDbl = Double.parseDouble(respuesta);
                            empleado.setSalario(opcDbl);
                            
                        } catch (NumberFormatException ex) {
                            System.out.println("Por favor, ingrese un número decimal válido:");
                        }
                    } while (!respuesta.matches("^[0-9]+(\\.[0-9]+)$"));
                    while (fechaInit == null) {
                        
                        System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            respuesta = teclado.next();
                            fechaInit = sdf.parse(respuesta);
                            empleado.setFechaInicio(fechaInit);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha no válido.");
                        }
                        
                    }   controlPersis.crearEmpleado(empleado);
                    System.out.println("El empleado se ha agregado con exito: " + empleado.toString());
                    break;
            //Modificar empleado
                case 2:
                    System.out.println("------------- Empleados Registrados-------------");
                    listaEmpleados = controlPersis.traerEmpleados();
                    for (Empleado emp : listaEmpleados) {
                        System.out.println(emp.toString());
                    }   break;
            //Eliminar empleado
                case 3:
                    while (opcion != 0) {
                        System.out.println("Ingrese el id del empleado que desea modificar o presione 0 para salir: ");
                        opcion = teclado.nextInt();
                        
                        //Busco el empleado a modificar para saber si existe
                        empleEncontrado = controlPersis.traerEmpleado(opcion);
                        //Sub menu para modificar los datos del empleado
                        
                        if (empleEncontrado != null) {
                            
                            System.out.println("El empleado a modificar es: " + empleEncontrado);
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
                            } //Lógica para modificar el nombre
                            else if (opcion == 1) {
                                while (respuesta.equals(" ") || !respuesta.matches("^[a-zA-Z]+$")) {
                                    System.out.println("Ha seleccionado modificar el nombre.");
                                    System.out.println("Ingrese un valor de tipo texto: ");
                                    respuesta = teclado.next();
                                    
                                    empleEncontrado.setNombre(respuesta);
                                    controlPersis.modificarEmpleado(empleEncontrado);
                                }
                            } //Lógica para modificar el apellido
                            else if (opcion == 2) {
                                while (respuesta.equals(" ") || !respuesta.matches("^[a-zA-Z]+$")) {
                                    System.out.println("Ha seleccionado modificar el apellido.");
                                    System.out.println("Ingrese un valor de tipo texto: ");
                                    respuesta = teclado.next();
                                    
                                    empleEncontrado.setApellido(respuesta);
                                    controlPersis.modificarEmpleado(empleEncontrado);
                                }
                            } // Lógica para modificar el cargo
                            else if (opcion == 3) {
                                while (respuesta.equals(" ") || !respuesta.matches("^[a-zA-Z]+$")) {
                                    System.out.println("Ha seleccionado modificar el cargo.");
                                    System.out.println("Ingrese un valor de tipo texto: ");
                                    respuesta = teclado.next();
                                    
                                    empleEncontrado.setCargo(respuesta);
                                    controlPersis.modificarEmpleado(empleEncontrado);
                                }
                            } // Lógica para modificar el salario
                            else if (opcion == 4) {
                                while (!respuesta.matches("^[0-9]+(\\.[0-9]+)$")) {
                                    try {
                                        System.out.println("Ha seleccionado modificar el salario.");
                                        System.out.println("Ingrese un valor decimal: ");
                                        
                                        respuesta = teclado.next();
                                        opcDbl = Double.parseDouble(respuesta);
                                        
                                        empleEncontrado.setSalario(opcDbl);
                                        controlPersis.modificarEmpleado(empleEncontrado);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error debe ingresar un número decimal.");
                                    }
                                }
                            } // Lógica para modificar la fecha de inicio
                            else if (opcion == 5) {
                                while (fechaInit == null) {
                                    System.out.println("Ha seleccionado modificar la fecha de inicio.");
                                    
                                    System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                                    try {
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        respuesta = teclado.next();
                                        fechaInit = sdf.parse(respuesta);
                                        empleEncontrado.setFechaInicio(fechaInit);
                                        controlPersis.modificarEmpleado(empleEncontrado);
                                    } catch (ParseException e) {
                                        System.out.println("Formato de fecha no válido. Introduce la fecha en el formato YYYY-MM-DD.");
                                    }
                                }
                                
                            }

                            System.out.println("El empleado se ha modificado con éxito: " + empleEncontrado.toString());
                        } else {
                            System.out.println("El id que ingresó no es valido.");
                        }
                        
                    }   break;
            //Filtrar empleados por cargo
                case 4:
                    try {
                        System.out.println("Ingrese el id del empleado a eliminar: ");
                        opcion = teclado.nextInt();
                        empleEncontrado = controlPersis.traerEmpleado(opcion);
                        
                        System.out.println(empleEncontrado.toString());
                        System.out.println("Está seguro que desea eliminar el empleado? Presione 'y' para borrar o cualquier otra tecla para volver al menú principal:");
                        respuesta = teclado.next();
                        
                        if (respuesta.equalsIgnoreCase("y")) {
                            controlPersis.eliminarEmpleado(opcion);
                            System.out.println("El empleado ha sido eliminado correctamente.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Error en el id, el empleado que intenta eliminar no existe.");
                    }   break;
                case 5:
                    System.out.println("Ingrese el cargo por el cual desea filtrar: ");
                    respuesta = teclado.next();
                    listaEmpleados = controlPersis.traerEmpleados();
                    System.out.println("-------------Empleados filtrados por cargo-------------");
                    //Recorro la lista de empleados fitrando por el cargo y comparo con el valor ingresado
                    for (Empleado emple : listaEmpleados) {
                        
                        if (respuesta.equalsIgnoreCase(emple.getCargo())) {
                            System.out.println(emple.toString());
                        }
                    }   break;
                default:
                    break;
            }

        
        }

        //Finalizo programa
        System.out.println("Ha cerrado sesión. Gracias por usar nuestros servicios");
        teclado.close();
    }
}
