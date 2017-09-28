package com.rramos.servicedesk.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rramos.servicedesk.R;

public class PrincipalActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
/*
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_registrar_ticket_nuevo:
                        Toast.makeText(PrincipalActivity.this, "Registrar ticket nuevo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultar_estado_ticket:
                        Toast.makeText(PrincipalActivity.this, "Consultar estado del ticket", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultar_todos_tickets:
                        Toast.makeText(PrincipalActivity.this, "Consultar todos los tickets", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignar_ticket_tecnico:
                        Toast.makeText(PrincipalActivity.this, "Asignar ticket a tecnico", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_reporte_tickets:
                        Toast.makeText(PrincipalActivity.this, "Reporte de tickets", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_consultar_tickets_asignados:
                        Toast.makeText(PrincipalActivity.this, "Consultar tickets asignados", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_atender_tickets_asignados:
                        Toast.makeText(PrincipalActivity.this, "Atender tickets asignados", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_perfil:
                        Toast.makeText(PrincipalActivity.this, "Seleccion de la opcion perfil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_configuracion:
                        Toast.makeText(PrincipalActivity.this, "Seleccion de la opcion configuracion", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_cerrar_sesion:
                        Toast.makeText(PrincipalActivity.this, "Seleccion de la opcion cerrar sesion", Toast.LENGTH_SHORT).show();
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;

            }
        });



        String nombre = getIntent().getStringExtra("nombre");
        String usuario = getIntent().getStringExtra("usuario");
        String rol = getIntent().getStringExtra("rol");

        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_perfil);
        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(nombre);
        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText(usuario);
        if (rol.equals("Cliente")){

            navigationView.getMenu().findItem(R.id.nav_consultar_todos_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_asignar_ticket_tecnico).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_reporte_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_consultar_tickets_asignados).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_atender_tickets_asignados).setVisible(false);
        }else if(rol.equals("Supervisor")){

            navigationView.getMenu().findItem(R.id.nav_registrar_ticket_nuevo).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_consultar_estado_ticket).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_consultar_tickets_asignados).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_atender_tickets_asignados).setVisible(false);
        }else{

            navigationView.getMenu().findItem(R.id.nav_registrar_ticket_nuevo).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_consultar_estado_ticket).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_consultar_todos_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_asignar_ticket_tecnico).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_reporte_tickets).setVisible(false);
        }


        // Change navigation header information









        //Ocultar la opcion cerrar sesion
        //navigationView.getMenu().findItem(R.id.nav_cerrar_sesion).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
