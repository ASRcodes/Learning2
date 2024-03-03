package com.example.wscubepractice2.AllAboutDatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityPracticeRoomDataBinding;

import java.util.ArrayList;

public class practiceRoomData extends AppCompatActivity {
    ActivityPracticeRoomDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityPracticeRoomDataBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        DbHelperExpense dbHelperExpense = DbHelperExpense.getDb(this);

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.title.getText().toString();
                String amount = binding.amount.getText().toString();
            if (title.isEmpty() && amount.isEmpty()) {
                Toast.makeText(practiceRoomData.this, "Enter the values first(Bahot tez ho rahe ho)", Toast.LENGTH_SHORT).show();
            }
            else {
//                 Here we have called method of expenseDao for adding the values of editText on click of button...
                dbHelperExpense.expenseDao().addTx(new expense(title, amount));
//          This code will add the fetched values from editText in an ArrayList....
                ArrayList<expense> arrExpense = (ArrayList<expense>) dbHelperExpense.expenseDao().getAllExpenses();
//                Now we'll fetch the value and see them in a Log.d
                for (int i = 0; i < arrExpense.size(); i++) {
                    Log.d("EXPENSES", "title = " + arrExpense.get(i).getTitle() + " amount = " + arrExpense.get(i).getAmount());
                }

                Toast.makeText(practiceRoomData.this, "Added to data base", Toast.LENGTH_SHORT).show();
                binding.title.setText("");
                binding.amount.setText("");
            }
            }
        });
        binding.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String del =  binding.del.getText().toString();
                if (del.isEmpty()){
                    Toast.makeText(practiceRoomData.this, "Enter the id first", Toast.LENGTH_SHORT).show();
                }
                else {
                    int delText = Integer.parseInt(del);
                    dbHelperExpense.expenseDao().deleteTx(new expense(delText));
                }
            }
        });
    }
}