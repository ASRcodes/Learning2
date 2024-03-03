package com.example.wscubepractice2.AllAboutDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//NOw make this class @Dao
@Dao
public interface expenseDao {
    @Query("Select * from expense")
//    Getting all values from expense class in a List
    List<expense>getAllExpenses();

    //    Methods definitions
    @Insert
    Void addTx(expense expense);
    @Update
    void updateTx(expense expense);
    @Delete
    void deleteTx(expense expense);
}
