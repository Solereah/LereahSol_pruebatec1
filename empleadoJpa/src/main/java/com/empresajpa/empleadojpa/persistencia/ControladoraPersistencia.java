package com.empresajpa.empleadojpa.persistencia;

import com.empresajpa.empleadojpa.logica.Empleado;
import com.empresajpa.empleadojpa.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public ControladoraPersistencia() {
    }
    
    
    
    public void crearEmpleado(Empleado emple){  
        empleadoJpa.create(emple);
    }
    
    public void modificarEmpleado(Empleado empleado){
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Empleado> traerEmpleados(){
        List<Empleado> listaEmp = empleadoJpa.findEmpleadoEntities();
        return new ArrayList<>(listaEmp); 
    }
    
    public Empleado traerEmpleado(int id){
        return empleadoJpa.findEmpleado(id);
    }
    
    public void eliminarEmpleado(int id){
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
