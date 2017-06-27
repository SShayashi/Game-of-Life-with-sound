package com.sshayashi.musicgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by starprince on 2017/06/27.
 */

public class ViewAdapter extends ArrayAdapter<CellView> {
    private int resourceId;
    private Context mContext;

    public ViewAdapter(Context context, int resource, List<CellView> objects) {
        super(context, resource, objects);
        resourceId = resource;
        mContext = context;
    }

    @Override
    public CellView getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resourceId, null);
        }
        CellView view = (CellView) convertView;
        return view;
    }
}