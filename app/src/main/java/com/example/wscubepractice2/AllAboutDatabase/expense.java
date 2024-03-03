package com.example.wscubepractice2.AllAboutDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//This class is made for defining the entitySET
@Entity(tableName = "expense")
public class expense {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "amount")
    private String amount;
//    Here after doing this all our Entity is ready..
//    Now we'll create a interface class in which all insertion,deletion,etc methods will be implemented

//    We'll create constructors here
    @Ignore
    expense(int id){
        this.id=id;
    }
    expense(int id,String title,String amount){
        this.id = id;
        this.title = title;
        this.amount = amount;
    }
//    We'll create one Ignorable constructor
    @Ignore
    expense(String title,String amount){
        this.title = title;
        this.amount = amount;
    }

//    Now we'll create getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

//    After this we are going to create a DBHelper class Which will create the database

}
