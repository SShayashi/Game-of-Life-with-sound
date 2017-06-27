package com.sshayashi.musicgame;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.AdapterView;

import com.google.android.gms.plus.model.people.Person;

public class MainActivity extends AppCompatActivity {
    int width_length = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        int num = width_length;
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
        int view_id = 1;
        for(int i=1;i<=width_length;i++) {
            for(int j=1;j<= 50; j++) {
                LayoutInflater inflater = getLayoutInflater();
                View cellLayout = inflater.inflate(R.layout.cell_view, null);
                CellView cell = (CellView) cellLayout.findViewById(R.id.cell_view);
                list.add(cell);
                cell.setId(R.id.cell_view + view_id);
                cell.setTag("" + view_id);
                view_id++;
                cell.INDEX_X=i;
                cell.INDEX_Y=j;
            }
        }
        return list;
    }

}
