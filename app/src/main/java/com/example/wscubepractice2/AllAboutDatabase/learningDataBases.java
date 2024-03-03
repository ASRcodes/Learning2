package com.example.wscubepractice2.AllAboutDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.wscubepractice2.R;

import java.util.ArrayList;

public class learningDataBases extends AppCompatActivity {
    private static final String DATABASE_NAME ="ContactDB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_data_bases);

    dbHelperClass mydbHelper = new dbHelperClass(learningDataBases.this,DATABASE_NAME,null,1);

//    mydbHelper.addContact("Anubhav ","+919919199191");
//        mydbHelper.addContact("Sam","+919917199191");
//        mydbHelper.addContact("shubh ","+9109199191");
//        mydbHelper.addContact("Anushka ","+91989199191");
//        mydbHelper.addContact("Anu ","+91991967191");



//        Now we'll fetch data from here for that we'll comment the old data....
        ArrayList<ContactModel> arrayList = mydbHelper.fetchContact();

//        Now we'll fetch the stored data and show them in our UI by creating listView or RecyclerView but for practice purpose we'll do it in Lod.d
//        will use a for loop to get ArrayList
        for (int i=0;i<arrayList.size();i++){
            Log.d("CONTACT","Name"+arrayList.get(i).name+" ,Phone_no "+arrayList.get(i).phone_no);
        }

//        ContactModel contactModel = new ContactModel();
//        Here which id number you'll give it will be updated to the value you'll give to that
//        contactModel.id = 2;
//        contactModel.name = "SAM BAHADUR";
//        contactModel.phone_no = "+9192992732";
//        contactModel.id = 1;
//        contactModel.name = "Anubhav Rajput";
//        contactModel.phone_no = "+9192992730002";
//        mydbHelper.UpdateContact(contactModel);


//        code for deletion
//        mydbHelper.DeleteContact(4);


    }
}