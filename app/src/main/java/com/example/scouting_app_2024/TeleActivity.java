package com.example.scouting_app_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TeleActivity extends AppCompatActivity {
    TextView teleAmpNotesCountText, teleSpeakerNotesCountText, teleAmpNotesMissedCountText, teleSpeakerNotesMissedCountText;
    byte teleAmpNotesCount, teleSpeakerNotesCount, teleAmpNotesMissedCount, teleSpeakerNotesMissedCount;
    CheckBox diedCheck, brokeCheck, defenseCheck;
    EditText teleComments;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele);
        teleAmpNotesCountText = findViewById(R.id.teleAmpNotesCountTextView);
        teleSpeakerNotesCountText = findViewById(R.id.teleSpeakerNotesCountTextView);
        teleAmpNotesMissedCountText = findViewById(R.id.teleAmpNotesMissedCountTextView);
        teleSpeakerNotesMissedCountText = findViewById(R.id.teleSpeakerNotesMissedCountTextView);
        diedCheck = findViewById(R.id.diedCheckBox);
        brokeCheck = findViewById(R.id.brokeCheckBox);
        defenseCheck = findViewById(R.id.defenseCheckBox);
        teleComments = findViewById(R.id.teleCommentsEditText);
        setPrevious();
    }

    /**
     * Moves the xml/page back to auto
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void backAuto(View view){
        Intent next = new Intent(this, AutoActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Moves the xml/page to stage
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void toStage(View view){
        Intent next = new Intent(this, StageActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Increments the amp notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleIncrementAmpNotes(View view){
        teleAmpNotesCount++;
        teleAmpNotesCountText.setText(String.valueOf(teleAmpNotesCount));
    }

    /**
     * Decrements the amp notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleDecrementAmpNotes(View view){
        if (teleAmpNotesCount != 0) {
            teleAmpNotesCount--;
            teleAmpNotesCountText.setText(String.valueOf(teleAmpNotesCount));
        }
    }

    /**
     * Increments the speaker notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleIncrementSpeakerNotes(View view){
        teleSpeakerNotesCount++;
        teleSpeakerNotesCountText.setText(String.valueOf(teleSpeakerNotesCount));
    }

    /**
     * Decrements the speaker notes count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleDecrementSpeakerNotes(View view){
        if (teleSpeakerNotesCount != 0) {
            teleSpeakerNotesCount--;
            teleSpeakerNotesCountText.setText(String.valueOf(teleSpeakerNotesCount));
        }
    }

    /**
     * Increments the amp notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleIncrementAmpNotesMissed(View view){
        teleAmpNotesMissedCount++;
        teleAmpNotesMissedCountText.setText(String.valueOf(teleAmpNotesMissedCount));
    }

    /**
     * Decrements the amp notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleDecrementAmpNotesMissed(View view){
        if (teleAmpNotesMissedCount != 0) {
            teleAmpNotesMissedCount--;
            teleAmpNotesMissedCountText.setText(String.valueOf(teleAmpNotesMissedCount));
        }
    }

    /**
     * Increments the speaker notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleIncrementSpeakerNotesMissed(View view){
        teleSpeakerNotesMissedCount++;
        teleSpeakerNotesMissedCountText.setText(String.valueOf(teleSpeakerNotesMissedCount));
    }

    /**
     * Decrements the speaker notes missed count and updates the text
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void teleDecrementSpeakerNotesMissed(View view){
        if (teleSpeakerNotesMissedCount != 0) {
            teleSpeakerNotesMissedCount--;
            teleSpeakerNotesMissedCountText.setText(String.valueOf(teleSpeakerNotesMissedCount));
        }
    }

    /**
     * Sets all values to the ones in RecordsActivity so pages don't change whenever you switch between them
     */
    public void setPrevious(){
        teleAmpNotesCount = RecordsActivity.Info.teleAmpNotes;
        teleAmpNotesCountText.setText(String.valueOf(teleAmpNotesCount));
        teleSpeakerNotesCount = RecordsActivity.Info.teleSpeakerNotes;
        teleSpeakerNotesCountText.setText(String.valueOf(teleSpeakerNotesCount));
        teleAmpNotesMissedCount = RecordsActivity.Info.teleAmpNotesMissed;
        teleAmpNotesMissedCountText.setText(String.valueOf(teleAmpNotesMissedCount));
        teleSpeakerNotesMissedCount = RecordsActivity.Info.teleSpeakerNotesMissed;
        teleSpeakerNotesMissedCountText.setText(String.valueOf(teleSpeakerNotesMissedCount));
        diedCheck.setChecked(RecordsActivity.Info.died);
        brokeCheck.setChecked(RecordsActivity.Info.broke);
        defenseCheck.setChecked(RecordsActivity.Info.defense);
        teleComments.setText(RecordsActivity.Info.teleComments);
    }

    /**
     * Stores all current data in RecordsActivity
     */
    public void saveData(){
        RecordsActivity.Info.teleAmpNotes = teleAmpNotesCount;
        RecordsActivity.Info.teleSpeakerNotes = teleSpeakerNotesCount;
        RecordsActivity.Info.teleAmpNotesMissed = teleAmpNotesMissedCount;
        RecordsActivity.Info.teleSpeakerNotesMissed = teleSpeakerNotesMissedCount;
        RecordsActivity.Info.died= diedCheck.isChecked();
        RecordsActivity.Info.broke = brokeCheck.isChecked();
        RecordsActivity.Info.defense = defenseCheck.isChecked();
        RecordsActivity.Info.teleComments = teleComments.getText().toString();
    }
}