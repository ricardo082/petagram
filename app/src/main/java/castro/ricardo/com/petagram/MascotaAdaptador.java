package castro.ricardo.com.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ricardo Castro Tapia on 9/01/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout y lo pasará al viewholder para que el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesDados.setText( String.valueOf(mascota.getLikes()));
        mascotaViewHolder.btnDarLikes.setImageResource(R.drawable.huesosinrelleno);
        mascotaViewHolder.btnLikesDados.setImageResource(R.drawable.huesoconrelleno);

    }

    @Override
    public int getItemCount() { // cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoMascota;
        private ImageButton btnDarLikes;
        private TextView tvNombreMascota;
        private TextView tvLikesDados;
        private ImageButton btnLikesDados;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            btnDarLikes = (ImageButton) itemView.findViewById(R.id.btnDarLike);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikesDados = (TextView) itemView.findViewById(R.id.numeroLikes);
            btnLikesDados = (ImageButton) itemView.findViewById(R.id.btnLikesDados);
        }

    }
}
