package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.adapter.SiswaAdapter;
import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.model.Siswa;

public class DetailSiswaActivity extends AppCompatActivity implements SiswaAdapter.ISiswaAdapter{

    public static final String SISWA = "siswa";
    private static final int REQUEST_CODE_ADD = 88;
    private static final int REQUEST_CODE_EDIT = 99;
    ArrayList<Siswa> mList = new ArrayList<>();
    SiswaAdapter mAdapter;
    int itemPos;
    ArrayList<Siswa> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_siswa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SiswaAdapter(this,mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

    }

    private void goAdd()
    {
        startActivityForResult(new Intent(this,InputSiswaActivity.class), REQUEST_CODE_ADD);
    }

    private void fillData()
    {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.places);
        String [] arDeskripsi = resources.getStringArray(R.array.place_desc);
        String [] arDetail = resources.getStringArray(R.array.place_details);
        String [] arLokasi = resources.getStringArray(R.array.place_locations);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            int id = a.getResourceId(i, 0);

            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                    +resources.getResourcePackageName(id)+'/'
                    +resources.getResourceTypeName(id)+'/'
                    +resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            mList.add(new Siswa(arJudul[i],arDeskripsi[i],arDetail[i],arLokasi[i] ,arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detaill_siswa, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });
        return true;
    }

    private void doFilter(String query)
    {
        if(!isFiltered)
        {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }

        mList.clear();
        if(query == null || query.isEmpty())
        {
            mList.addAll(mListAll);
            isFiltered = false;
        }

        else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++)
            {
                Siswa siswa = mListAll.get(i);
                if (siswa.judul.toLowerCase().contains(query) ||
                        siswa.deskripsi.toLowerCase().contains(query) ||
                        siswa.lokasi.toLowerCase().contains(query))
                {
                    mList.add(siswa);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetaillSiswaActivity.class);
        intent.putExtra(SISWA,mList.get(pos));
        startActivity(intent);
    }

    @Override
    public void doEdit(int pos) {
        itemPos = pos;
        Intent intent = new Intent(this, InputSiswaActivity.class);
        intent.putExtra(SISWA, mList.get(pos));
        startActivityForResult(intent, REQUEST_CODE_EDIT);

    }

    @Override
    public void doDelete(int pos) {
        itemPos = pos;
        final Siswa siswa = mList.get(pos);
        mList.remove(itemPos);
        if (isFiltered) mListAll.remove(mListMapFilter.get(itemPos).intValue());
        mAdapter.notifyDataSetChanged();
        Snackbar.make(findViewById(R.id.fab),siswa.judul+" Terhapus",Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mList.add(itemPos, siswa);
                        if (isFiltered) mListAll.add(mListMapFilter.get(itemPos), siswa);
                        mAdapter.notifyDataSetChanged();
                    }
                })
                .show();

    }

    @Override
    public void doFav(int pos) {

    }

    @Override
    public void doShare(int pos) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK)
        {
            Siswa siswa = (Siswa) data.getSerializableExtra(SISWA);
            mList.add(siswa);
            if(isFiltered ) mListAll.add(siswa);
            doFilter(mQuery);
            //mAdapter.notifyDataSetChanged();
        }

        else if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK)
        {
            Siswa siswa = (Siswa) data.getSerializableExtra(SISWA);
            mList.remove(itemPos);
            if(isFiltered) mListAll.remove(mListMapFilter.get(itemPos).intValue());
            mList.add(itemPos,siswa);
            if (isFiltered) mListAll.add(mListMapFilter.get(itemPos), siswa);
            mAdapter.notifyDataSetChanged();
        }
    }
}
