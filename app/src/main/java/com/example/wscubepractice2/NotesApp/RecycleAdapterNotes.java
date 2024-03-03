package com.example.wscubepractice2.NotesApp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscubepractice2.R;

import java.util.ArrayList;

public class RecycleAdapterNotes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Notes> arrNotes;
    NotesRoomdbHelper notesRoomdbHelper;

//    Creating constructors
    RecycleAdapterNotes(Context context, ArrayList<Notes> arrNotes,NotesRoomdbHelper notesRoomdbHelper){
        this.context = context;
        this.arrNotes = arrNotes;
        this.notesRoomdbHelper = notesRoomdbHelper;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.add_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
// Now after finding there id's we'll set the text from the EditText of dialog box here which is stored in ArrayList arrNotes
//        Before that set the link between the adapter class and the add_notes xml files in onCreateViewHolder method
        TextView title =  holder.itemView.findViewById(R.id.textTitle);
        LinearLayout ll = holder.itemView.findViewById(R.id.llNotes);
        TextView content = holder.itemView.findViewById(R.id.textContent);
        title.setText(arrNotes.get(position).getTitle());
        content.setText(arrNotes.get(position).getContent());

        ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteItem(position);

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
// we'll return the size of our arrayList here
        return arrNotes.size();
    }
//    We'll make a new view Holder class which will hold our views or the editText,btn,etc.
    public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout ll = itemView.findViewById(R.id.llNotes);
        TextView title = itemView.findViewById(R.id.textTitle);
        TextView content = itemView.findViewById(R.id.textContent);

    }
}
public void deleteItem(int position){
    AlertDialog alertDialog = new AlertDialog.Builder(context)
            .setTitle("Delete")
            .setMessage("Are you sure you want to delete")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    notesRoomdbHelper.nOtesInterface().deleteNotes(new Notes(arrNotes.get(position).getId(),
                            arrNotes.get(position).getTitle(),arrNotes.get(position).getContent()));
//                    Call showNotes from MainActivity make it public
                    ((contentNtitle)context).showNotes();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            })
            .show();
}

}
