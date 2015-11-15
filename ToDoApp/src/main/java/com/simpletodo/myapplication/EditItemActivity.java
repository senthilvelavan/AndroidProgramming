package com.simpletodo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    ArrayList<String> itemsList = new ArrayList<String>();
    String currentItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        populateEditNameWithItemNameToEdit();
    }

    public void populateEditNameWithItemNameToEdit(){
        EditText itemEdit = (EditText)findViewById(R.id.editText);
        currentItem = getIntent().getStringExtra("itemToEdit");
        itemEdit.setText(currentItem);
        itemEdit.setSelection(itemEdit.getText().length());
        itemsList = getIntent().getStringArrayListExtra("items");
        for(String item : itemsList){
            System.out.println(item);
        }
    }

    public void onSaveItem(View v){
        EditText editText = (EditText)findViewById(R.id.editText);
        String editedText = editText.getText().toString();

        Intent i = new Intent();
        itemsList.remove(currentItem);
        itemsList.add(editedText);
        i.putStringArrayListExtra("items", itemsList);
        setResult(RESULT_OK, i); // set result code and bundle data for response
        finish();
    }


}
