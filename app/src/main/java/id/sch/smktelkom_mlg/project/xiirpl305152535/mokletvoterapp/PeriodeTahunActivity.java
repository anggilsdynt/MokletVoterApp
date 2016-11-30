package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.adapter.PeriodeAdapter;
import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.model.Periode;

public class PeriodeTahunActivity extends AppCompatActivity {

    ArrayList<Periode> mList = new ArrayList<>();
    PeriodeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode_tahun);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new PeriodeAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData()
    {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.places);
        String [] arDeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            mList.add(new Periode(arJudul[i],arDeskripsi[i],arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}
