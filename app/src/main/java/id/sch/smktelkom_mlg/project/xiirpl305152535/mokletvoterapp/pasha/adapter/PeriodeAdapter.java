package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.pasha.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.R;
import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.pasha.model.Periode;

/**
 * Created by Pasha Anisa on 11/30/2016.
 */
public class PeriodeAdapter extends RecyclerView.Adapter<PeriodeAdapter.ViewHolder> {

    ArrayList<Periode> periodeList;

    public PeriodeAdapter(ArrayList<Periode> hotelList)
    {
        this.periodeList = hotelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_periode,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Periode periode = periodeList.get(position);
        holder.tvJudul.setText(periode.judul);
        holder.ivFoto.setImageDrawable(periode.foto);
    }

    @Override
    public int getItemCount() {
        if(periodeList!=null)
            return periodeList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
        }
    }
}
