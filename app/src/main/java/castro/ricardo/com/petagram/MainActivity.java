package castro.ricardo.com.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   static ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        ImageView miActionView = (ImageView) miActionBar.findViewById(R.id.btnDarLike);
        setSupportActionBar(miActionBar);

        listaDeMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        listaDeMascotas.setLayoutManager(lm);

        inicializarListaDeMascotas();
        iniciarlizarAdaptador();

        miActionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, DetalleMascota.class);
                startActivity(intent);

            }
        });

    }

    public void inicializarListaDeMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,"Tiger",3));
        mascotas.add(new Mascota(R.drawable.perro2,"Pelusa",5));
        mascotas.add(new Mascota(R.drawable.perro3,"pirulai",2));
        mascotas.add(new Mascota(R.drawable.perro4,"Kaiser",8));
        mascotas.add(new Mascota(R.drawable.perro5,"Pepito",6));
        mascotas.add(new Mascota(R.drawable.perro6,"Guardian",4));
        mascotas.add(new Mascota(R.drawable.perro7,"Tobi",1));
    }

    public void iniciarlizarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaDeMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_BACK){
            Log.i("Mi mensaje", "Se va para atrás");
            finishAffinity();
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}

