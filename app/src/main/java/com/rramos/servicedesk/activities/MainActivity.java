package com.rramos.servicedesk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rramos.servicedesk.R;
import com.rramos.servicedesk.models.Usuario;
import com.rramos.servicedesk.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
    private EditText text_usuario,text_contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarioRepository.AgregarUsuarios();


    }

    public void Inicio_sesion(View view) {

        text_usuario =(EditText)findViewById(R.id.text_usuario);
        text_contrasena=(EditText)findViewById(R.id.text_contrasena);

        String usuario_obtenido=text_usuario.getText().toString();
        String contrasena_obtenida=text_contrasena.getText().toString();

        List<Usuario> usuarios = usuarioRepository.getUsuarios();
        Usuario usuarioelegido = UsuarioRepository.validarUsuario(usuario_obtenido,contrasena_obtenida,usuarios);

        //Enviar el rol
        Log.d("tag",String.valueOf(usuarios.size()));


        if(usuarioelegido!= null){
            Toast.makeText(this, "Su nombre es: " + usuarioelegido.getNombres(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);
                intent.putExtra("nombre",usuarioelegido.getNombres());
                intent.putExtra("usuario",usuarioelegido.getUsuario());
                intent.putExtra("rol",usuarioelegido.getRol());
                startActivity(intent);
        }else{
            Toast.makeText(this,"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();
        }

    }
}
