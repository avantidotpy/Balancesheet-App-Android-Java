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

public class ExpenseListAdapter extends ArrayAdapter<Expense> {
private Context mContext1;
private int mResource1;
private final ArrayList<Expense> objects1;

public ExpenseListAdapter(Context context1,int resource1,ArrayList<Expense> objects1){
        super(context1,resource1,objects1);
        mContext1=context1;
        mResource1=resource1;
        this.objects1=objects1;
        }

    @NonNull
    @Override
    public View getView(int position1, @Nullable View convertView1, @NonNull ViewGroup parent1) {
        String type1=getItem(position1).get_type1();
        Integer amount1=getItem(position1).get_amount1();

        Expense expense=new Expense(type1,amount1);

        LayoutInflater inflater1=LayoutInflater.from(mContext1);
        convertView1=inflater1.inflate(mResource1,parent1,false);

        TextView t_type1=(TextView)convertView1.findViewById(R.id.typetextView);
        TextView t_amount1=(TextView)convertView1.findViewById(R.id.amttextView);
        t_type1.setText(type1);
        t_amount1.setText(amount1);

        return convertView1;
    }
}
