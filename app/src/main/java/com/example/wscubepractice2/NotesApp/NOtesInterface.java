package com.example.wscubepractice2.NotesApp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NOtesInterface {
    @Query("Select * from notes")
    List<Notes>getAllNotes();

    @Insert
    void addNote(Notes notes);
    @Update
    void updateNotes(Notes notes);
    @Delete
    void deleteNotes(Notes notes);
}
