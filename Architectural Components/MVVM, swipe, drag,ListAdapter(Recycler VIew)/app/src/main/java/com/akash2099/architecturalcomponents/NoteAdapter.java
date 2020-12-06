package com.akash2099.architecturalcomponents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ListAdapter<Note,NoteAdapter.NoteHolder> {
//    private List<Note> notes = new ArrayList<>(); // not needed in ListAdapter DiffUtil
    private OnItemClickListener listener;

    // Adding DiffUtil for comparing Item and content
    protected NoteAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(Note oldItem, Note newItem) {
            return oldItem.getId() == newItem.getId();
        }
        @Override
        public boolean areContentsTheSame(Note oldItem, Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription()) &&
                    oldItem.getPriority() == newItem.getPriority();
        }
    };

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
//        Note currentNote = notes.get(position); // directly accessing Note entity,not needed in ListAdapter DiffUtil
        Note currentNote =getItem(position); // directly accessing Note entity

        // Getting the notes entity column values using getters defined in Note.java
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescription.setText(currentNote.getDescription());
        holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));


    }

//    @Override
//    public int getItemCount() { //not needed in ListAdapter DiffUtil
//        return notes.size();
//    }

    // adding the notes into recycler view array list
//    public void setNotes(List<Note> notes) { // not needed in ListAdapter DiffUtil
//        this.notes = notes;
//
//        // better not to use notifyDataSetChanged() as it is less efficient and also don't have animation
//        notifyDataSetChanged(); // This destroys and recreate the who recycler view, which is redundant and not efficient
//        // So use one of the following as required int(position) where change has occured
//        /*
//         * @see #notifyItemChanged(int)
//         * @see #notifyItemInserted(int)
//         * @see #notifyItemRemoved(int)
//         * @see #notifyItemRangeChanged(int, int)
//         * @see #notifyItemRangeInserted(int, int)
//         * @see #notifyItemRangeRemoved(int, int)
//         */
//
//
//    }

    // getting the note at a particular position
    public Note getNoteAt(int position) {
        return getItem(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;
        public NoteHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);

            // Configuring OnItemClickListener dynamically for each items
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // getting the position of items using getAdapterPosition()
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }
    // FOR CREATING ON_ITEM_CLICK_LISTENER DO THE BELOW TWO THINGS
    // Creating an interface for onclick item
    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    // Creating setOnItemClickListener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
