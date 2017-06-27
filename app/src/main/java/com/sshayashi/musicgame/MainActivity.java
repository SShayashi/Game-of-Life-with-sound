package com.sshayashi.musicgame;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        int num = 5;
        GridView gridView = (GridView)findViewById(R.id.main_table);
        gridView.setNumColumns(num);
        ArrayList<CellView> list = load();
        ViewAdapter adapter = new ViewAdapter(getApplicationContext(), R.layout.cell_view, list);
        gridView.setAdapter(adapter);

//        BitmapAdapter adapter;
//        View v = inflater.inflate(R.layout.fragment_cells_world, container, false);
//        CellsWorldFragment fragment = new CellsWorldFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.main_container, fragment);
//        transaction.commit();
    }

    private ArrayList<CellView> load() {
        ArrayList<CellView> list = new ArrayList<CellView>();
        for(int i=1;i<=6;i++) {
            LayoutInflater inflater = getLayoutInflater();
            View cellLayout = inflater.inflate(R.layout.cell_view, null);
            CellView cell = (CellView) cellLayout.findViewById(R.id.cell_view);
            list.add(cell);
        }
//        for (int i = 0; i < c.getCount(); i++) {
//            long id = c.getLong(c.getColumnIndexOrThrow("_id"));
//            Bitmap bmp = MediaStore.Images.Thumbnails.getThumbnail(cr, id, MediaStore.Images.Thumbnails.MICRO_KIND, null);
//            list.add(bmp);
//            c.moveToNext();
//        }
        return list;
    }

}
