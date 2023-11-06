package com.empresajpa.empleadojpa;

import com.empresajpa.empleadojpa.logica.Empleado;
import com.empresajpa.empleadojpa.persistencia.ControladoraPersistencia;
import java.util.List;


public class EmpleadoJpa {

    public static void main(String[] args) {
        
        //Creamos la tabla empleado
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        //Creamos un emleado
        Empleado emple1 = new Empleado(1,"Sol", "Lereah","developer",18000.00,"04-11-2023");
        Empleado emple2 = new Empleado(2,"James", "Gosling","Tech Lead",30000.00,"04-11-2023");
        Empleado emple3 = new Empleado(3,"Ada", "Lovelace","Software Engineer",33000.00,"01-04-1999");
        
        controlPersis.crearEmpleado(emple1);
        controlPersis.crearEmpleado(emple2);
        controlPersis.crearEmpleado(emple3);
        
        System.out.println("-------Lista empleados-------");
        
        //Mostrar lista de empleados
        System.out.println("Los empleados registrados son: ");
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        
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
