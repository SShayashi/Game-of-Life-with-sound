package com.sshayashi.musicgame;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;

public class BlankFragment extends Fragment {
    public BlankFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context c = getActivity();
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        TableLayout tableLayout = (TableLayout) v.findViewById(R.id.table_container);

        TableRow tableRow1 = new TableRow(c);
        tableLayout.addView(tableRow1);
        tableRow1.addView(new Button(c));
        tableRow1.addView(new Button(c));

        TableRow tableRow2 = new TableRow(c);
        tableLayout.addView(tableRow2);
        tableRow2.addView(new Button(c));
        tableRow2.addView(new Button(c));

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
