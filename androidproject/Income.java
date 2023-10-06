package com.example.gayatri.androidproject;

/**
 * Created by Avantika Mahalingam on 01/08/2018.
 */

public class Income {

    private String _month;
    private int _year;
    private String _type;
    private int _amount;
    private String _description;
    private String _date;

    public Income(){}

    public Income(String month,int year,String type,int amount,String description,String date) {
        this._month=month;
        this._year=year;
        this._type=type;
        this._amount=amount;
        this._description=description;
        this._date=date;

    }

    public Income(String type,int amount,String description,String date) {
        this._type=type;
        this._amount=amount;
        this._description=description;
        this._date=date;

    }

    public Income(String type, int amount) {
        this._type=type;
        this._amount=amount;

    }



    public String get_month() {
        return _month;
    }

    public void set_month(String _month) {
        this._month = _month;
    }

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
        this._year = _year;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public int get_amount() {
        return _amount;
    }

    public void set_amount(int _amount) {
        this._amount = _amount;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }



}
