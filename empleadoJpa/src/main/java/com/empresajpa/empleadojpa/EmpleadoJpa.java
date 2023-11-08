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
        Integer opcInt;
        String opcStr;
        Double opcDbl;
        Empleado empleEncontrado;
        ArrayList<Empleado> listaEmpleados;

        
        //Creo instancia de la clase Empleado
        Empleado empleado = new Empleado();

        //Creo Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);

        //Creamos la tabla empleado
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

       
        
        System.out.println("""
                           ------------Bienvenido a HRConnect------------
                           
                           Aquí encontrarás todas las herramientas necesarias 
                           para optimizar la administración de recursos humanos.                       
                           """);
        System.out.println("""                 
        Ingrese la opción que desea realizar:
                           
        1.Agregar un nuevo empleado 
                           
        2.Listar empleados
                           
        3.Actualizar información de un empleado
                           
        4.Eliminar un empleado
                           
        5.Buscar empleados por cargo
            
        Pulse 0 para salir               
            
        """);
        System.out.println("Ingrese su opcion: ");
        opcInt = teclado.nextInt();

        while (opcInt != 0) {

            //Evalúo si el número ingresado está dentro del rango de opciones 
            if (opcInt < 0 || opcInt > 5) {
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
            }
            //Crear empleado
            else if (opcInt == 1) {
                System.out.println("Ingrese el nombre: ");
                opcStr = teclado.next();
                empleado.setNombre(opcStr);

                System.out.println("Ingrese el apellido: ");
                opcStr = teclado.next();
                empleado.setApellido(opcStr);

                System.out.println("Ingrese el cargo: ");
                opcStr = teclado.next();
                empleado.setCargo(opcStr);

                System.out.println("Ingrese el salario: ");
                opcDbl = teclado.nextDouble();
                empleado.setSalario(  opcDbl);

                System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    opcStr = teclado.next();
                    Date fechaInit = sdf.parse(opcStr);
                    empleado.setFechaInicio(fechaInit);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha no válido. Introduce la fecha en el formato YYYY-MM-DD.");
                }
                controlPersis.crearEmpleado(empleado);
                //System.out.println(empleado.getId());
                System.out.println("El empleado se ha agregado con exito: " + empleado.toString());

                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
            }
            
            //Mostrar lista de empleados
            else if(opcInt == 2){
                
                System.out.println("Los empleados registrados son: ");
                listaEmpleados = controlPersis.traerEmpleados();
        
                for(Empleado emp : listaEmpleados){
                    System.out.println(emp.toString());
                }
                
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
            }
           
            //Modificar empleado
            else if(opcInt==3){
                
                System.out.println("Ingrese el id del empleado que desea modificar: ");
                opcInt = teclado.nextInt();
                
                //Mostrar el empleado a modificar
                System.out.println("El empleado a modificar es: "+ controlPersis.traerEmpleado(opcInt));
                empleEncontrado = controlPersis.traerEmpleado(opcInt);
                System.out.println("""
                    Ingrese el campo que desea modificar: 
                    1.Nombre
                    2.Apellido
                    3.Cargo
                    4.Salario
                    5.Fecha de inicio               
                    """);
                opcInt = teclado.nextInt();
                
                //Evalúo que el número esté dentro del rango de opciones
                if (opcInt < 0 || opcInt > 5) {
                    System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                    System.out.println("Ingrese su opcion: ");
                    opcInt = teclado.nextInt();
                }
                
               
                //Lógica para modificar el nombre
                if(opcInt == 1) {
                    System.out.println("Ha seleccionado modificar el nombre.");
                    System.out.println("Ingrese el valor a modificar: ");
                    opcStr= teclado.next();
                    
                    empleEncontrado.setNombre(opcStr);
                    controlPersis.modificarEmpleado(empleEncontrado);
                    System.out.println("El empleado se ha modificado con éxito: " +  empleEncontrado.toString());
               
                }    
                
                //Lógica para modificar el apellido
                if(opcInt == 2){
                    System.out.println("Ha seleccionado modificar el apellido.");
                    System.out.println("Ingrese el valor a modificar: ");
                    opcStr= teclado.next();
                    empleEncontrado.setApellido(opcStr);
                    controlPersis.modificarEmpleado(empleEncontrado);
                    System.out.println("El empleado se ha modificado con éxito: " +  empleEncontrado.toString());
                }
                
                // Lógica para modificar el cargo
                if(opcInt == 3){
                    System.out.println("Ha seleccionado modificar el cargo.");
                    System.out.println("Ingrese el valor a modificar: ");
                    opcStr= teclado.next();
                    empleEncontrado.setCargo(opcStr);
                    controlPersis.modificarEmpleado(empleEncontrado);
                    System.out.println("El empleado se ha modificado con éxito: " +  empleEncontrado.toString());
                }
                
                // Lógica para modificar el salario
                if(opcInt == 4){
                    System.out.println("Ha seleccionado modificar el salario.");
                    System.out.println("Ingrese el valor a modificar: ");
                    opcDbl= teclado.nextDouble();
                    empleEncontrado.setSalario(opcDbl);
                    controlPersis.modificarEmpleado(empleEncontrado);
                    System.out.println("El empleado se ha modificado con éxito: " +  empleEncontrado.toString());
                }
                // Lógica para modificar la fecha de inicio
                if(opcInt == 5){
                    System.out.println("Ha seleccionado modificar la fecha de inicio.");
                
                   System.out.println("Ingrese la fecha de inicio con el siguiente formato ('yyyy-MM-dd') : ");
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        opcStr = teclado.next();
                        Date fechaInit = sdf.parse(opcStr);
                        empleEncontrado.setFechaInicio(fechaInit);
                        controlPersis.modificarEmpleado(empleEncontrado);
                        System.out.println("El empleado se ha modificado con éxito: " +  empleEncontrado.toString());
                    }catch (ParseException e) {
                        System.out.println("Formato de fecha no válido. Introduce la fecha en el formato YYYY-MM-DD.");
                    }
                }
              
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
            }
            
            //Eliminar empleado
            if(opcInt ==4){
                System.out.println("Ingrese el id del empleado a eliminar: ");
                opcInt= teclado.nextInt();
                empleEncontrado = controlPersis.traerEmpleado(opcInt);
                System.out.println(empleEncontrado.toString());
                System.out.println("Está seguro que desea eliminar el empleado? Presione 'y' para borrar o cualquier otra tecla para salir: ");
               
                if(teclado.next().equalsIgnoreCase("y")){
                    controlPersis.eliminarEmpleado(opcInt);
                    System.out.println("El empleado ha sido eliminado correctamente.");
                }
                
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
                
            
            }
            
            //Filtrar empleados por cargo
            if(opcInt == 5){
                System.out.println("Ingrese el cargo por el cual desea filtrar: ");
                opcStr= teclado.next();
                listaEmpleados = controlPersis.traerEmpleados();
                
                //Recorro la lista de empleados fitrando por el cargo y comparo con el valor ingresado
                for (Empleado emple : listaEmpleados) {
                   
                    if (opcStr.equalsIgnoreCase(emple.getCargo())) {
                        System.out.println(emple.toString());
                    } 
                    
               
                }
                System.out.println("Debe ingresar un número del 1 al 5 o pulse 0 para salir");
                System.out.println("Ingrese su opcion: ");
                opcInt = teclado.nextInt();
            
            }

            System.out.println("Ha cerrado sesión. Gracias por usar nuestros servicios");

        }

    }
}

