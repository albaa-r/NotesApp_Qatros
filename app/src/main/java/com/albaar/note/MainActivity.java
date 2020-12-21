package com.albaar.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NotesClick {

    RecyclerView mRecyclerView;
    static AdapterNote mAdapterNote;
    static ArrayList<String> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAddItem =  (Button) findViewById(R.id.buttonAdd);
        mRecyclerView = findViewById(R.id.recyclerView);

        mNotes = new ArrayList<>();
        mNotes.add("test");

        mAdapterNote = new AdapterNote(mNotes, this, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (this,LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapterNote);


        buttonAddItem.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, EditorNotes.class);
            startActivity(intent);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DeleteNotes(mAdapterNote));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }


    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(this, EditorNotes.class);
        intent.putExtra("nodeId", position);
        startActivity(intent);
    }



}