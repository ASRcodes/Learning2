package com.example.wscubepractice2.AllAboutDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelperClass extends SQLiteOpenHelper {
//    we are making it static and final so that no other values can be
//    assigned to them and static so that memory will assigned before it's actual run
    private static final String DATABASE_NAME ="ContactDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT ="contact";
    private static final String  KEY_ID ="id";
    private static final String KEY_NAME ="name";
    private static final String KEY_PHONE_NO ="Phone_no";
    public dbHelperClass(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    This method will create DataBase for the App for the first time it will be opened
    @Override
    public void onCreate(SQLiteDatabase db) {
//        this code will give access to SQL in our app Here we'll write the queries

//        ERROR RELATED TO COMMAS AND SPACES IN THIS CODE
//        db.execSQL("CREATE TABLE "+TABLE_CONTACT +"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT" +
//                " ,"+ KEY_NAME+ "TEXT,"+KEY_PHONE_NO+"TEXT "+ ")");

//        Here look how you have to put spaces and commas between the SQl queries
        db.execSQL("CREATE TABLE " + TABLE_CONTACT + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " +
                KEY_PHONE_NO + " TEXT)");
//        This is how the table will be create

//        This code is used to open the Database for insertion,Deletion,Upgradation,etc
//        SQLiteDatabase database = this.getWritableDatabase();

//        This code is used to close the database
//        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//Here we have to update the newer version for that we first have to delete the older one.
//        This code will delete the older version
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
//        And further new version will be created..
        onCreate(db);
    }

//    Now we'll create methods for insertion & deletion of data..
//    Method for insertion...
    public void addContact(String name , String phoneNo){
        SQLiteDatabase database =  this.getWritableDatabase();
//        The insertion of data will be done through this particular ContentValues...
        ContentValues values = new ContentValues();
//        Here we put values in KEY and the value for that ex name,roll,etc
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phoneNo);
//        Code for insertion
        database.insert(TABLE_CONTACT,null,values);

//        Now we'll insert data from our main Activity.
    }


    //    Method for data fetching
    public ArrayList<ContactModel> fetchContact(){
        SQLiteDatabase database = this.getReadableDatabase();

//        this will return cursor for data retrieval
//    It will take two values first SQL queries and 2nd query with where keyWord when we are needed selected amount of data.....

        //        Now we'll create cursor variable to move it for data retrieval..  and the select query to fetch the data
        Cursor cursor= database.rawQuery("SELECT * FROM "+TABLE_CONTACT, null);

//        We'll create an ArrayList with variable arrContac
        ArrayList<ContactModel> arrContact = new ArrayList<>();
        while (cursor.moveToNext()){
//            And will create variable of ContactModel and inside that variable the data will be stored..
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            arrContact.add(model);
        }
//    retuning the ArrayList variable at last
        return arrContact;
    }

//    Method to update the table
//    And in this method we are needed all the data id,name.ph_no so we'll directly take the contactModel in our class
    public void UpdateContact(ContactModel contactModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
//        We can directly from here also but by giving the variable's reference we will be able to update the different values when needed..
        cv.put(KEY_PHONE_NO,contactModel.phone_no);
        cv.put(KEY_NAME,contactModel.name);
//        This update methods needs 4 values to update which table,What values wanna update,where condition,where condi^n arguments......
//        for the values update we'll create a ContentValue above here
        db.update(TABLE_CONTACT,cv,KEY_ID+"="+contactModel.id,null);

//        Now go to Main Activity for data Updation..

    }

//    NOw codes for Methods deletion of data
    public void DeleteContact(int id){
//        Here if we want to delete a single data then the code for that
//        Bulk main bhi delete karna ho skta hai example in a school we have to delete the data of the students who have not paid fees
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_CONTACT,KEY_ID+"=?",new String[]{String.valueOf(id)});


//        Now in main Activity call it and give the id whose details you want to delete

    }
}
