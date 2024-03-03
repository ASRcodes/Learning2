package com.example.wscubepractice2.NotesApp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Notes.class,exportSchema = false,version = 1)
public abstract class NotesRoomdbHelper extends RoomDatabase {
    public static String DATABASE_NAME = "notes_DB";
    //    We'll create class's obj because if it's instance is already created
//    then no need to create a new instance use this
    private static NotesRoomdbHelper instance;
    //    Now we'll create one method which work will be to create instance if found null
    public static synchronized NotesRoomdbHelper getDbb(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context, NotesRoomdbHelper.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    //    call abstract of Dao
    public abstract NOtesInterface nOtesInterface();
}
