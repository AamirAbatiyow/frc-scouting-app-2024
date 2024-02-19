package com.example.scouting_app_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AutoActivity extends AppCompatActivity {
    CheckBox leaveCheck;
    TextView autoAmpNotesCountText, autoSpeakerNotesCountText, autoAmpNotesMissedCountText, autoSpeakerNotesMissedCountText;
    byte autoAmpNotesCount, autoSpeakerNotesCount, autoAmpNotesMissedCount, autoSpeakerNotesMissedCount;
    EditText autoComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        leaveCheck = findViewById(R.id.leaveCheckBox);
        autoAmpNotesCountText = findViewById(R.id.autoAmpNotesCountTextView);
        autoSpeakerNotesCountText = findViewById(R.id.autoSpeakerNotesCountTextView);
        autoAmpNotesMissedCountText = findViewById(R.id.autoAmpNotesMissedCountTextView);
        autoSpeakerNotesMissedCountText = findViewById(R.id.autoSpeakerNotesMissedCountTextView);
        autoComments = findViewById(R.id.autoCommentsEditText);
        setPrevious();
    }

    /**
     * Increments the amp notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoIncrementAmpNotes(View view){
        autoAmpNotesCount++;
        autoAmpNotesCountText.setText(String.valueOf(autoAmpNotesCount));
    }

    /**
     * Decrements the amp notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoDecrementAmpNotes(View view){
        if (autoAmpNotesCount != 0) {
            autoAmpNotesCount--;
            autoAmpNotesCountText.setText(String.valueOf(autoAmpNotesCount));
        }
    }

    /**
     * Increments the speaker notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoIncrementSpeakerNotes(View view){
        autoSpeakerNotesCount++;
        autoSpeakerNotesCountText.setText(String.valueOf(autoSpeakerNotesCount));
    }

    /**
     * Decrements the speaker notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoDecrementSpeakerNotes(View view){
        if (autoSpeakerNotesCount != 0) {
            autoSpeakerNotesCount--;
            autoSpeakerNotesCountText.setText(String.valueOf(autoSpeakerNotesCount));
        }
    }

    /**
     * Increments the amp notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoIncrementAmpNotesMissed(View view){
        autoAmpNotesMissedCount++;
        autoAmpNotesMissedCountText.setText(String.valueOf(autoAmpNotesMissedCount));
    }

    /**
     * Decrements the amp notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoDecrementAmpNotesMissed(View view){
        if (autoAmpNotesMissedCount != 0) {
            autoAmpNotesMissedCount--;
            autoAmpNotesMissedCountText.setText(String.valueOf(autoAmpNotesMissedCount));
        }
    }

    /**
     * Increments the speaker notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoIncrementSpeakerNotesMissed(View view){
        autoSpeakerNotesMissedCount++;
        autoSpeakerNotesMissedCountText.setText(String.valueOf(autoSpeakerNotesMissedCount));
    }

    /**
     * Decrements the speaker notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void autoDecrementSpeakerNotesMissed(View view){
        if (autoSpeakerNotesMissedCount != 0) {
            autoSpeakerNotesMissedCount--;
            autoSpeakerNotesMissedCountText.setText(String.valueOf(autoSpeakerNotesMissedCount));
        }
    }

    /**
     * Moves the xml/page back to main
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void backMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Moves the xml/page to tele
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void toTele(View view){
        Intent next = new Intent(this, TeleActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Sets all values to the ones in RecordsActivity so pages don't change whenever you switch between them
     */
    public void setPrevious(){
        leaveCheck.setChecked(RecordsActivity.Info.leave);
        autoAmpNotesCount = RecordsActivity.Info.autoAmpNotes;
        autoAmpNotesCountText.setText(String.valueOf(autoAmpNotesCount));
        autoSpeakerNotesCount = RecordsActivity.Info.autoSpeakerNotes;
        autoSpeakerNotesCountText.setText(String.valueOf(autoSpeakerNotesCount));
        autoAmpNotesMissedCount = RecordsActivity.Info.autoAmpNotesMissed;
        autoAmpNotesMissedCountText.setText(String.valueOf(autoAmpNotesMissedCount));
        autoSpeakerNotesMissedCount = RecordsActivity.Info.autoSpeakerNotesMissed;
        autoSpeakerNotesMissedCountText.setText(String.valueOf(autoSpeakerNotesMissedCount));
        autoComments.setText(RecordsActivity.Info.autoComments);
    }

    /**
     * Stores all current data in RecordsActivity
     */
    public void saveData(){
        RecordsActivity.Info.leave = leaveCheck.isChecked();
        RecordsActivity.Info.autoAmpNotes = autoAmpNotesCount;
        RecordsActivity.Info.autoSpeakerNotes = autoSpeakerNotesCount;
        RecordsActivity.Info.autoAmpNotesMissed = autoAmpNotesMissedCount;
        RecordsActivity.Info.autoSpeakerNotesMissed = autoSpeakerNotesMissedCount;
        RecordsActivity.Info.autoComments = autoComments.getText().toString();
    }
}
