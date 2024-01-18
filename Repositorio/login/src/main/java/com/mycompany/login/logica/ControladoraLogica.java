package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlP = null;

    public ControladoraLogica() {
        controlP = new ControladoraPersistencia();
    }
    
    //metodos rol
    public List<Rol> buscarListaRoles() {
        return controlP.buscarListaRoles();
    }

    private Rol buscarRol(String nombreRol) {
        List<Rol> listaRoles = controlP.buscarListaRoles();
        
        for(Rol rol : listaRoles) {
            if(rol.getNombreRol().equals(nombreRol)) {
                return rol;
            }
        }
        
        return null;
    }

    //metodos usuario
    public List<Usuario> buscarListaUsuarios() {
        return controlP.buscarListaUsuarios();
    }

    public Usuario validarUsuario(String nombreUsuario, String contrasenia) {
        List<Usuario> listaUsuarios = buscarListaUsuarios();
        Usuario usr = null;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                usr = usuario;
                return usr;
            } else {
                usr = null;
            }
        }

        return usr;
    }
    
    public void guardarUsuario(String nombre, String contrasenia, String nombreRol) {
        Usuario usr = new Usuario();
        usr.setNombreUsuario(nombre);
        usr.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.buscarRol(nombreRol);
        if (rolEncontrado != null) {
            usr.setUnRol(rolEncontrado);
        }
        
        controlP.guardarUsuario(usr);
    }

    public void eliminarUsuario(int id) {
        controlP.eliminarUsuario(id);
    }

    public Usuario buscarUsuario(int id) {
        return controlP.buscarUsuario(id);
    }

    public void editarUsuario(Usuario usr, String nombre, String contrasenia, String nombreRol) {
        usr.setNombreUsuario(nombre);
        usr.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.buscarRol(nombreRol);
        if (rolEncontrado != null) {
            usr.setUnRol(rolEncontrado);
        }
        
        controlP.editarUsuario(usr);
    }

    

    
}
