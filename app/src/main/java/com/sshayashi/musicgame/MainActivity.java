package com.sshayashi.musicgame;

import java.util.ArrayList;
import java.util.TimerTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.os.Handler;
import java.util.Timer;
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
        handler = new Handler();
        timerTask = new MyTimerTask();
        timer = new Timer();
        timer.schedule(timerTask,500,500);
    }

    private ArrayList<CellView> load(final CellularAutomata model) {
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

                View.OnTouchListener oListener = (new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) return true;
                        if (event.getAction() != MotionEvent.ACTION_UP) return false;
                        CellView cv = (CellView)v;
                        if(cv.isChecked())
                            model.world[cv.INDEX_X][cv.INDEX_Y][1]=0;
                        else
                            model.world[cv.INDEX_X][cv.INDEX_Y][1]=1;
                        cv.toggle();
                        return true;
                    }
                });
                cell.setOnTouchListener(oListener);

            }
        }
        return list;
    }

    public void reflectionModel(CellularAutomata model){
        for(CellView cell :list){
            if ((model.world[cell.INDEX_X][cell.INDEX_Y][1] == 1)
                    || (model.world[cell.INDEX_X][cell.INDEX_Y][1] == 0
                    && model.world[cell.INDEX_X][cell.INDEX_Y][0] == 1))
                cell.setChecked(true);

            if(model.world[cell.INDEX_X][cell.INDEX_Y][1] == 0)
                cell.setChecked(false);
        }
    }

    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            handler.post( new Runnable() {
                public void run() {
                    model.update();
                    reflectionModel(model);
                    adapter.notifyDataSetChanged();
                    count++;
                    Log.i("update","hoge" +count);
                }
            });
        }
    }
}

