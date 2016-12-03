package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.pasha.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.R;
import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.pasha.model.Siswa;

/**
 * Created by Pasha Anisa on 10/29/2016.
 */
public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder>
{
    ArrayList<Siswa> siswaList;
    ISiswaAdapter mISiswaAdapter;

    public interface ISiswaAdapter
    {
        void doClick(int pos);
        void doEdit(int pos);
        void doDelete(int pos);
        void doFav(int pos);
        void doShare(int pos);

    }

    public SiswaAdapter(Context context, ArrayList<Siswa> hotelList)
    {
        this.siswaList = hotelList;
        mISiswaAdapter = (ISiswaAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_siswa,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Siswa hotel = siswaList.get(position);
        holder.tvJudul.setText(hotel.judul);
        holder.tvDeskripsi.setText(hotel.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(hotel.foto));

    }

    @Override
    public int getItemCount() {
        if(siswaList!=null)
            return siswaList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;
        Button bEdit;
        Button bDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            bEdit = (Button) itemView.findViewById(R.id.buttonEdit);
            bDelete = (Button) itemView.findViewById(R.id.buttonDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   mISiswaAdapter.doClick(getAdapterPosition());
               }
           });

            bEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mISiswaAdapter.doEdit(getAdapterPosition());
                }
            });

            bDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mISiswaAdapter.doDelete(getAdapterPosition());
                }
            });


        }




    }
}
