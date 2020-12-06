package com.akash2099.architecturalcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {

    // Setting keys for intents
    // The ID intent is only for update
    public static final String EXTRA_ID =
            "com.codinginflow.architectureexample.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.codinginflow.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.codinginflow.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.codinginflow.architectureexample.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        // Set the number picker min and max
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        // below require not null object, setting the back button
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        // Checking EXTRA_ID for update mode
        Intent intent = getIntent();// getting the received intent
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note"); // Edit mode
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");// By default Add Note is the title
        }

        // also the toolbar can be set using setActionBar
    }
    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue(); // get number picker values int format

        if (title.trim().isEmpty() || description.trim().isEmpty()) { // trim is used to trim starting and ending spaces
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        // set the result back for startActivityForResult Intent
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        // if id not received then set the id of the resultCode to -1
        int id=getIntent().getIntExtra(EXTRA_ID,-1); // if nothing  received
        if(id!=-1){
            data.putExtra(EXTRA_ID,id); // sending back the id data
        }

        setResult(RESULT_OK, data);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                // save the note using ViewModel
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
