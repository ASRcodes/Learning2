package com.example.wscubepractice2.NotesApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityNotesappBinding;

import java.util.ArrayList;

public class contentNtitle extends AppCompatActivity{
//    ActivityNotesappBinding binding;
//    NotesRoomdbHelper notesRoomdbHelper;
    transient ActivityNotesappBinding binding;
    transient NotesRoomdbHelper notesRoomdbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityNotesappBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.notesRecyclerV.setLayoutManager(layoutManager);

        notesRoomdbHelper = NotesRoomdbHelper.getDbb(this);
        showNotes();
        binding.notesCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(contentNtitle.this);
                dialog.setContentView(R.layout.notes_dialog);

                EditText noteTitle = dialog.findViewById(R.id.notetitle);
                EditText notesContent = dialog.findViewById(R.id.noteacontent);
                Button add = dialog.findViewById(R.id.addnotes);

//                Now we'll fetch the value from EditTexts and on the click of button we'll insert them on database
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = noteTitle.getText().toString();
                        String conTent = notesContent.getText().toString();

//                        NOW we'll check if it's not null
                        if (title.isEmpty() && conTent.isEmpty()){
                            Toast.makeText(contentNtitle.this, "Fill the details first", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            notesRoomdbHelper.nOtesInterface().addNote(new Notes(title,conTent));
                            showNotes();
                            dialog.dismiss();
                        }

                    }
                });
                dialog.show();

            }
        });
        binding.notesfloatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            binding.notesCreate.performClick();
            }
        });

    }

    public void showNotes() {

//        Fetching the  data from the notesClass in an ArrayList
        ArrayList<Notes> arrNotes = (ArrayList<Notes>) notesRoomdbHelper.nOtesInterface().getAllNotes();
        if (arrNotes.size()>0){
            binding.notesRecyclerV.setVisibility(View.VISIBLE);
            binding.notelLEmpty.setVisibility(View.GONE);
        RecycleAdapterNotes recycleAdapterNotes = new RecycleAdapterNotes(this,arrNotes,notesRoomdbHelper);
//        now we have to set the recyclerAdapter on recyclerView so find in's id
            binding.notesRecyclerV.setAdapter(recycleAdapterNotes);

        }
        else{
            binding.notesRecyclerV.setVisibility(View.GONE);
            binding.notelLEmpty.setVisibility(View.VISIBLE);
        }
    }
}