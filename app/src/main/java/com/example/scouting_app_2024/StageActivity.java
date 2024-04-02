package com.example.scouting_app_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class StageActivity extends AppCompatActivity {
    CheckBox harmonyCheck, trapCheck;
    RadioButton noPark, park, onstage, spotlit;
    EditText stageComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        harmonyCheck = findViewById(R.id.harmonyCheckBox);
        trapCheck = findViewById(R.id.trapCheckBox);
        noPark = findViewById(R.id.noParkRadioButton);
        park = findViewById(R.id.parkRadioButton);
        onstage = findViewById(R.id.onstageRadioButton);
        spotlit = findViewById(R.id.spotlitRadioButton);
        stageComments = findViewById(R.id.stageCommentsEditText);
        setPrevious();
    }

    /**
     * Moves the xml/page back to tele
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void backTele(View view){
        Intent next = new Intent(this, TeleActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Moves the xml/page to popup
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void toPopup(View view){
        Intent next = new Intent(this, PopupActivity.class);
        startActivity(next);
        saveData();
    }

    /**
     * Sets all values to the ones in RecordsActivity so pages don't change whenever you switch between them
     */
    public void setPrevious(){
        harmonyCheck.setChecked(RecordsActivity.Info.harmony);
        trapCheck.setChecked(RecordsActivity.Info.trap);
        switch (RecordsActivity.Info.stageLevel) {
            case "No Park":
                noPark.setChecked(true);
                break;
            case "Parked":
                park.setChecked(true);
                break;
            case "Onstage":
                onstage.setChecked(true);
                break;
            case "Spotlit":
                spotlit.setChecked(true);
                break;
            default:
                noPark.setChecked(false);
                park.setChecked(false);
                onstage.setChecked(false);
                spotlit.setChecked(false);
                break;
        }
        stageComments.setText(RecordsActivity.Info.stageComments);
    }

    /**
     * Stores all current data in RecordsActivity
     */
    public void saveData() {
        RecordsActivity.Info.harmony = harmonyCheck.isChecked();
        RecordsActivity.Info.trap = trapCheck.isChecked();
        if(noPark.isChecked()){
            RecordsActivity.Info.stageLevel = "No Park";
        } else if(park.isChecked()){
            RecordsActivity.Info.stageLevel = "Parked";
        } else if (onstage.isChecked()){
            RecordsActivity.Info.stageLevel = "Onstage";
        } else if (spotlit.isChecked()){
            RecordsActivity.Info.stageLevel = "Spotlit";
        } else {
            RecordsActivity.Info.stageLevel = "null";
        }
        RecordsActivity.Info.stageComments = stageComments.getText().toString();
    }
}
