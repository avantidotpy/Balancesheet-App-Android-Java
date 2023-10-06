package com.example.gayatri.androidproject;

/**
 * Created by Avantika Mahalingam on 01/08/2018.
 */

public class Expense {

    private String _month1;
    private int _year1;
    private String _type1;
    private int _amount1;
    private String _description1;
    private String _date1;

    public Expense(){}

    public Expense(String month1,int year1,String type1,int amount1,String description1,String date1) {
        this._month1=month1;
        this._year1=year1;
        this._type1=type1;
        this._amount1=amount1;
        this._description1=description1;
        this._date1=date1;
    }

    public Expense(String type1,int amount1,String description1,String date1){
        this._type1=type1;
        this._amount1=amount1;
        this._description1=description1;
        this._date1=date1;
    }

    public Expense(String type1, int amount1){
        this._type1=type1;
        this._amount1=amount1;

    }

    public String get_month1() {
        return _month1;
    }

    public void set_month1(String _month1) {
        this._month1 = _month1;
    }

    public int get_year1() {
        return _year1;
    }

    public void set_year1(int _year1) {
        this._year1 = _year1;
    }

    public String get_type1() {
        return _type1;
    }

    public void set_type1(String _type1) {
        this._type1 = _type1;
    }

    public int get_amount1() {
        return _amount1;
    }

    public void set_amount1(int _amount1) {
        this._amount1 = _amount1;
    }

    public String get_description1() {
        return _description1;
    }

    public void set_description1(String _description1) {
        this._description1 = _description1;
    }

    public String get_date1() {
        return _date1;
    }

    public void set_date1(String _date1) {
        this._date1 = _date1;
    }


}
