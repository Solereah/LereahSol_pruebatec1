package com.empresajpa.empleadojpa;

import com.empresajpa.empleadojpa.logica.Empleado;
import com.empresajpa.empleadojpa.persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class EmpleadoJpa {

    public static void main(String[] args) throws ParseException {
        
      
        //Creo Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        
        //Creamos la tabla empleado
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();  //Formateo de fechas
        
        //Formate de fechas
        SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy/mm/dd"); 
         
        
        
        
        //Creamos un emleado
        Empleado emple1 = new Empleado(1,"Sol", "Lereah","developer",18000.00,new Date());
        Empleado emple2 = new Empleado(2,"James", "Gosling","Tech Lead",30000.00,fechaFormat.parse("1979/07/30"));
        Empleado emple3 = new Empleado(3,"Ada", "Lovelace","Software Engineer",33000.00,fechaFormat.parse("2015/03/17"));
        
        controlPersis.crearEmpleado(emple1);
        controlPersis.crearEmpleado(emple2);
        controlPersis.crearEmpleado(emple3);
        
        System.out.println("-------Lista empleados-------");
        
        //Mostrar un solo empleado
        controlPersis.traerEmpleado(1);
        
        //Mostrar lista de empleados
        System.out.println("Los empleados registrados son: ");
        ArrayList<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        
        for(Empleado emp : listaEmpleados){
            System.out.println(emp.toString());
        }
        
        //Modificar empleado
        emple1.setCargo("Scrum Master");
        controlPersis.modificarEmpleado(emple1);
        
        //Borrar empleado
        controlPersis.eliminarEmpleado(2);
        
        System.out.println("-------Lista empleados-------");
        
        listaEmpleados = controlPersis.traerEmpleados();
        
        for(Empleado emp : listaEmpleados){
            System.out.println(emp.toString());
        }
        
    }
   
}
