package com.sshayashi.musicgame;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import com.sshayashi.musicgame.CellView;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.content.res.Resources;

public class CellsWorldFragment extends Fragment {
    public CellsWorldFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context c = getActivity();
        View v = inflater.inflate(R.layout.fragment_cells_world, container, false);


//        GridView gridView = (GridView) findViewById(R.id.main_table);
//        gridView.setAdapter(adapter);


//        TableLayout tableLayout = (TableLayout) v.findViewById(R.id.table_container);
//
//        for(int i=1;i<=6;i++){
//            TableRow tableRow = new TableRow(c);
//            tableRow.setLayoutParams(new ViewGroup.LayoutParams());
//            TableRow.LayoutParams lp = new TableRow.LayoutParams(10, TableRow.LayoutParams.MATCH_PARENT);
//            tableRow.setLayoutParams(lp);
//            TableRow.LayoutParams l = (TableRow.LayoutParams) tableRow.getLayoutParams();
//            TableRow.LayoutParams lp = new TableRow.LayoutParams(10);

//            DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
//
//            tableLayout.setLayoutParams(lp);
//            for(int j=1;j<=6;j++) {
//                View cellLayout = inflater.inflate(R.layout.cell_view, null);
//                CellView cell = (CellView) cellLayout.findViewById(R.id.cell_view);
//
//                tableRow.addView(cell);
//            }
//            tableLayout.addView(tableRow);
//        }


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
