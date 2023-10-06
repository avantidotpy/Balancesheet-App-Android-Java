package com.example.gayatri.androidproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseFilter extends Fragment {
    Spinner sp11;


    public ExpenseFilter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v12=inflater.inflate(R.layout.fragment_expense_filter,container,false);


        sp11 =(Spinner) v12.findViewById(R.id.spinner5);
        List<String> list11= new ArrayList<>();
        list11.add("Select Type");
        list11.add("Fare");
        list11.add("Rent");
        list11.add("Food");
        list11.add("Meds");
        //here mparam1 and param2 should also come

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,list11);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp11.setAdapter(adapter);
        sp11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue1 = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        // Inflate the layout for this fragment
        return v12;
    }

}
