package com.example.gayatri.androidproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Avantika Mahalingam on 01/08/2018.
 */

public class IncomeListAdapter extends ArrayAdapter<Income> {
    private Context mContext;
    private int mResource;
    private final ArrayList<Income> objects;

    public IncomeListAdapter(Context context, int resource, ArrayList<Income> objects){
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
        this.objects = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String type=getItem(position).get_type();
        int amount=getItem(position).get_amount();

        Income income= new Income(type,amount);

        LayoutInflater inflater0= LayoutInflater.from(mContext);
        convertView=inflater0.inflate(mResource,parent,false);

        TextView t_type=(TextView)convertView.findViewById(R.id.typetextView);
        TextView t_amount=(TextView)convertView.findViewById(R.id.amttextView);
        t_type.setText(type);
        t_amount.setText(String.valueOf(amount));

        return convertView;
    }
}
