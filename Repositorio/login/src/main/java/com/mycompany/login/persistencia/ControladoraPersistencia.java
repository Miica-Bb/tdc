package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.Usuario;
import com.mycompany.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = null;
    RolJpaController rolJpa = null;

    public ControladoraPersistencia() {
        usuarioJpa = new UsuarioJpaController();
        rolJpa = new RolJpaController();
    }
    
    //metodos rol
    public List<Rol> buscarListaRoles() {
        return rolJpa.findRolEntities();
    }
    
    //metodos usuario
    public List<Usuario> buscarListaUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void guardarUsuario(Usuario usr) {
        usuarioJpa.create(usr);
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscarUsuario(int id) {
        return usuarioJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usr) {
        try {
            usuarioJpa.edit(usr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
