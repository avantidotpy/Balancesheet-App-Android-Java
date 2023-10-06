package com.example.gayatri.androidproject;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoard extends Fragment {
    Spinner sp12;
    EditText addnewtype;
    DatabaseHelper myDb;
    Spinner spinnermonth;


    EditText editText_amount;
    EditText editText_descriptn;
    EditText editText_date;
    Button btn_addincome;
    Spinner spinner2;

    EditText editText_amount1;
    EditText editText_description1;
    EditText editText_date1;
    Button btn_addexpense;
    Spinner spinner1;

    ListView incomelist;
    ListView expenselist;

    ArrayList<Income> list1 = new ArrayList<>();;
    ArrayList<Expense> list2;

    Button btntemp;



    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        myDb = new DatabaseHelper(this.getContext());

        final View v =inflater.inflate(R.layout.fragment_dash_board,container,false);

        btntemp=v.findViewById(R.id.buttontemp);

        incomelist=v.findViewById(R.id.list_view);
        expenselist=v.findViewById(R.id.list_view3);

        //list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        sp12 =(Spinner) v.findViewById(R.id.spinner6);
        List<String> list10= new ArrayList<>();
        list10.add("YYYY");
        list10.add("2018");
        list10.add("2017");
        list10.add("2016");
        list10.add("2015");

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,list10);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp12.setAdapter(adapter1);

        sp12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue3 = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ImageButton Add =v.findViewById(R.id.btadd);
        ImageButton Adde =v.findViewById(R.id.btadde);


        String[] values={"Select Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        final Spinner spinnermonth =v.findViewById(R.id.spinner);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnermonth.setAdapter(adapter);

        spinnermonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               final String itemvalue31 = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btntemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewDataIncome();

                IncomeListAdapter adapter10= new IncomeListAdapter(getContext(), R.layout.listlayout, list1);
                incomelist.setAdapter(adapter10);

                Cursor cursor = myDb.getAll();

                if (cursor.getCount() == 0) {
                    Toast.makeText(getContext(), "No Data to show", Toast.LENGTH_SHORT).show();
                }
                else {
                    do{

                        Income income1= new Income (cursor.getString(2),cursor.getInt(3));
                    list1.add(income1);}
                    while (cursor.moveToNext()) ;
                    adapter10.notifyDataSetChanged();


                }
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View mView=getLayoutInflater().inflate(R.layout.fragment_layout__dialog,null);


                final EditText editText_amount = (EditText)mView.findViewById(R.id.editText);
                final EditText editText_descriptn = (EditText)mView.findViewById(R.id.editText2);
                final EditText editText_date = (EditText)mView.findViewById(R.id.editText3);
                final Button btn_addincome = (Button)mView.findViewById(R.id.button3);


                String[] values1={"Select Type","Salary","Tuition","PartTime"};
               AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());

               final Spinner spinner2=mView.findViewById(R.id.spinner1);
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,values1);
                adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner2.setAdapter(adapter1);

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       final String itemvalue32 = parent.getItemAtPosition(position).toString();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog=mBuilder.create();
                dialog.show();
                dialog.getWindow().setLayout(1000,1500);

                btn_addincome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View mView) {
                       boolean Isinserted= myDb.insertData(spinnermonth.getSelectedItem().toString(),sp12.getSelectedItem().toString(),spinner2.getSelectedItem().toString()
                                ,editText_amount.getText().toString(),
                                editText_descriptn.getText().toString(),editText_date.getText().toString());
                if(Isinserted)
                    Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Data Not Inserted", Toast.LENGTH_SHORT).show();


                    }
                });

                }
        });



        Adde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View m2View=getLayoutInflater().inflate(R.layout.fragment_layout__expense,null);

                final EditText editText_amount1 = (EditText)m2View.findViewById(R.id.editText00);
                final EditText editText_descriptn1 = (EditText)m2View.findViewById(R.id.editText20);
                final EditText editText_date1 = (EditText)m2View.findViewById(R.id.editText30);
                final Button btn_addexpense = (Button)m2View.findViewById(R.id.buttonadd);

                final Spinner spinner1=m2View.findViewById(R.id.spinner2);

                String[] values2={"Select Type","Fare","Rent","Food","Meds","+ New Type"};
                final List<String> valuesList  = new ArrayList<>(Arrays.asList(values2));
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());


                final ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,valuesList);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);

                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View mView, int pos, long id) {
                        int index=spinner1.getSelectedItemPosition();
                        AlertDialog.Builder mBuilder1=new AlertDialog.Builder(getActivity());
                        final View m1View=getLayoutInflater().inflate(R.layout.fragment_add_new_type,null);

                        if(index==5)
                        {
                            mBuilder1.setView(m1View);
                            AlertDialog dialog1=mBuilder1.create();
                            Button add =m1View.findViewById(R.id.button00);
                            dialog1.show();
                            dialog1.getWindow().setLayout(1000,1500);

                            add.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View arg0) {

                                    final EditText addnewtype =m1View.findViewById(R.id.editText4);

                                    final String myData = addnewtype.getText().toString();

                                    valuesList.add(myData);
                                    adapter1.notifyDataSetChanged();
                                    spinner1.setSelection(adapter1.getPosition(myData));
                                    Toast.makeText(getContext(), "New Type Added", Toast.LENGTH_SHORT).show();
                                }
                            });


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }

                });


                mBuilder.setView(m2View);
                AlertDialog dialog=mBuilder.create();
                dialog.show();
                dialog.getWindow().setLayout(1000,1500);

                btn_addexpense.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View m2View) {
                        boolean Is_inserted1= myDb.insertData1(spinnermonth.getSelectedItem().toString(), sp12.getSelectedItem().toString(), spinner1.getSelectedItem().toString()
                                , editText_amount1.getText().toString(),
                                editText_descriptn1.getText().toString(), editText_date1.getText().toString());
                        if(Is_inserted1)
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getContext(), "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


        return v;
        // Inflate the layout for this fragment


    }

    /*public void viewDataIncome() {
        Cursor cursor = myDb.getAll();

        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No Data to show", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {

                Income income1= new Income (cursor.getString(3),cursor.getInt(4));

                list1.add(income1);}

        }



        IncomeListAdapter adapter10= new IncomeListAdapter(getContext(), R.layout.listlayout, list1);
        incomelist.setAdapter(adapter10);
    }*/


}