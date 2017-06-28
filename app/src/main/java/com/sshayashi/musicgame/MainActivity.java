package com.sshayashi.musicgame;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TimerTask;
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
import android.os.Handler;
import java.util.Timer;

import com.google.android.gms.plus.model.people.Person;
import com.sshayashi.musicgame.Models.CellularAutomata;

public class MainActivity extends AppCompatActivity {
    private Timer timer = null;
    private Handler handler = null;
    private MyTimerTask timerTask = null;
    private int count=0;
    ArrayList<CellView> list;
    CellularAutomata model;
    ViewAdapter adapter;
    GridView gridView;

    int width_length = 12;
    int height_lenght = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        model = new CellularAutomata(width_length,height_lenght);
        int num = width_length;
        gridView = (GridView)findViewById(R.id.main_table);
        gridView.setNumColumns(num);
        list = load(model);

        adapter = new ViewAdapter(getApplicationContext(), R.layout.cell_view, list);
        gridView.setAdapter(adapter);


//        BitmapAdapter adapter;
//        View v = inflater.inflate(R.layout.fragment_cells_world, container, false);
//        CellsWorldFragment fragment = new CellsWorldFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.main_container, fragment);
//        transaction.commit();
        handler = new Handler();
        timerTask = new MyTimerTask();
        timer = new Timer();
        timer.schedule(timerTask,500,500);
    }

    private ArrayList<CellView> load(CellularAutomata model) {
        ArrayList<CellView> list = new ArrayList<CellView>();
        for(int i=0;i<width_length;i++) {
            for(int j=0;j< height_lenght; j++) {
                LayoutInflater inflater = getLayoutInflater();
                View cellLayout = inflater.inflate(R.layout.cell_view, null);
                CellView cell = (CellView) cellLayout.findViewById(R.id.cell_view);
                cell.INDEX_X=i;
                cell.INDEX_Y=j;
                if(model.world[cell.INDEX_X][cell.INDEX_Y][1] == 1) {
                    cell.setChecked(true);
                }
                list.add(cell);
            }
        }
        return list;
    }

    public void reflectionModel(CellularAutomata model){
//        adapter.clear();
        for(CellView cell :list){
            if ((model.world[cell.INDEX_X][cell.INDEX_Y][1] == 1)
                    || (model.world[cell.INDEX_X][cell.INDEX_Y][1] == 0
                    && model.world[cell.INDEX_X][cell.INDEX_Y][0] == 1))
                cell.setChecked(true);

            if(model.world[cell.INDEX_X][cell.INDEX_Y][1] == 0)
                cell.setChecked(false);
        }
//        adapter.addAll(list);
//        adapter.notifyDataSetChanged();
    }

    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            handler.post( new Runnable() {
                public void run() {
                    model.update();
                    reflectionModel(model);
                    adapter.notifyDataSetChanged();
//                    gridView.invalidateViews();
                    count++;
                    Log.i("update","hoge" +count);
                }
            });
        }
    }
}

