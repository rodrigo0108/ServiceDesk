package com.rramos.servicedesk.repositories;

import android.widget.Toast;

import com.rramos.servicedesk.activities.MainActivity;
import com.rramos.servicedesk.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RODRIGO on 25/09/2017.
 */

public class UsuarioRepository {

    private static UsuarioRepository _INSTANCE = null;

    public static UsuarioRepository getInstance() {
        if (_INSTANCE == null) {
            _INSTANCE = new UsuarioRepository();


        }
        return _INSTANCE;
    }

    List<Usuario> usuarios = new ArrayList<>();

    public void AgregarUsuarios() {
        Usuario usuario1 = new Usuario("rodrigo.ramos", "1234", "Rodrigo Ramos", "Cliente");
        Usuario usuario2 = new Usuario("sara.sanz", "1234", "Sara Sanz", "Supervisor");
        Usuario usuario3 = new Usuario("mushu.mulan", "1234", "Mushu Mulan", "Tecnico");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public static Usuario validarUsuario(String nusuario, String contrasena,List<Usuario> usuarioss ) {

       Usuario usuarioelegido = new Usuario();
        for (final Usuario usuario : usuarioss
                ) {
            if (usuario.getUsuario().equals(nusuario) && usuario.getContrasena().equals(contrasena)) {
                usuarioelegido= usuario;
                break;
            } else {
                usuarioelegido= null;
            }

        }
        return usuarioelegido;


    }
}
