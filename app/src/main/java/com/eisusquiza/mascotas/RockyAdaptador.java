package com.eisusquiza.mascotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 04/12/2016.
 */

public class RockyAdaptador extends RecyclerView.Adapter<RockyAdaptador.RockyViewHolder>{

    public RockyAdaptador(ArrayList<Rockys> rockys){
        this.rockys=rockys;
    }

    ArrayList<Rockys> rockys;

    @Override
    public RockyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View y = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_rocky, parent, false);
        return new RockyViewHolder(y);
    }

    @Override
    public void onBindViewHolder(RockyViewHolder rockyViewHolder, int position) {
        Rockys rocky = rockys.get(position);
        rockyViewHolder.imgfotoRocky.setImageResource(rocky.getImgfotoRocky());
        rockyViewHolder.tvhuesosRocky.setText(rocky.getTvhuesosRocky());

    }

    @Override
    public int getItemCount() {
        return rockys.size();
    }

    public static class RockyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgfotoRocky;
        private TextView tvhuesosRocky;

        public RockyViewHolder(View itemView) {
            super(itemView);
            imgfotoRocky = (ImageView) itemView.findViewById(R.id.imgfotoRocky);
            tvhuesosRocky = (TextView) itemView.findViewById(R.id.tvhuesosRocky);
        }
    }
}
