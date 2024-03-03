package com.example.wscubepractice2.AllAboutDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Extend this class with RoomDataBase and makke this class Abstract
@Database(entities = expense.class,exportSchema = false,version = 1)
public abstract class DbHelperExpense extends RoomDatabase {
    public static String DB_NAME = "expensedb";
//    We'll create class's obj because if it's instance is already created
//    then no need to create a new instance use this
    private static DbHelperExpense instance;
//    Now we'll create one method which work will be to create instance if found null
    public static synchronized DbHelperExpense getDb(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context, DbHelperExpense.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
//    call abstract of Dao
    public abstract expenseDao expenseDao();
}
