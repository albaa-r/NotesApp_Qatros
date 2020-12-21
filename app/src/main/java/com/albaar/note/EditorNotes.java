package com.albaar.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditorNotes extends AppCompatActivity {

    EditText editNote;
    int nodeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_item);

        editNote = findViewById(R.id.editNote);

        nodeId = this.getIntent().getIntExtra("nodeId", -1);

        if (nodeId != -1){
            editNote.setText(MainActivity.mNotes.get(nodeId).toString());
        } else {

            MainActivity.mNotes.add("");
            nodeId = MainActivity.mNotes.size() -1;
            MainActivity.mAdapterNote.notifyDataSetChanged();
        }

        editNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                MainActivity.mNotes.set(nodeId, String.valueOf(s));
                MainActivity.mAdapterNote.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}