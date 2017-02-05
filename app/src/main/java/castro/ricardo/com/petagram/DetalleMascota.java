package castro.ricardo.com.petagram;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DetalleMascota extends AppCompatActivity {

    private RecyclerView listaDeMascotasSeleccionadas;
    private ArrayList<Mascota> mascotasPuntuadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setContentInsetStartWithNavigation(0);
        ImageView miActionView = (ImageView) miActionBar.findViewById(R.id.btnDarLike);
        miActionView.setVisibility(View.GONE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaDeMascotasSeleccionadas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        listaDeMascotasSeleccionadas.setLayoutManager(lm);
        inicializarListaDeMascotas();
        iniciarlizarAdaptador();
    }


    public void inicializarListaDeMascotas() {

        ArrayList mascotasSinOrdenar = MainActivity.mascotas;

        // Sorting
        Collections.sort(mascotasSinOrdenar, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota mascota2, Mascota mascota1)
            {
                return  String.valueOf(mascota1.getLikes()).compareTo(String.valueOf(mascota2.getLikes()));
            }
        });


        mascotasPuntuadas = new ArrayList<>(mascotasSinOrdenar.subList(0,5));

    }

    private void iniciarlizarAdaptador() {

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasPuntuadas, this);
        listaDeMascotasSeleccionadas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
