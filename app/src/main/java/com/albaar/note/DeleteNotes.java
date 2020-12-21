package com.albaar.note;

import android.content.ClipData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class DeleteNotes extends ItemTouchHelper.SimpleCallback {


    private AdapterNote mAdapterNote;

    public DeleteNotes(AdapterNote mAdapterNote) {
        super(0, ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT);
        this.mAdapterNote = mAdapterNote;
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        this.mAdapterNote.deleteNotes(position);
    }
}
