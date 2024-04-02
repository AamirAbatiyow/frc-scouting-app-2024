package com.example.scouting_app_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
public class MainActivity extends AppCompatActivity {
    CheckBox preloadCheck;
    EditText scoutName, matchNumber, teamNumber;
    RadioButton red1, red2, red3, pos1, pos2, pos3, pos4;
    RadioButton[] positions;
    int checkedPosition = -1;
    int[] teamList = {935, 937, 1710, 1723, 1730, 1763, 1764, 1769, 1775, 1827, 1847, 1986, 1987, 1994, 2345, 2357, 2410, 2457, 2470, 2560, 3061, 3184, 4809, 4959, 5098, 5119, 5126, 5141, 5189, 5268, 5801, 7421, 8719, 8825, 9445, 9551};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoutName = findViewById(R.id.scoutNameEditText);
        matchNumber = findViewById(R.id.matchNumberEditText);
        teamNumber = findViewById(R.id.teamNumberEditText);
        preloadCheck = findViewById(R.id.preloadCheckBox);
        red1 = findViewById(R.id.redOneRadioButton);
        red2 = findViewById(R.id.redTwoRadioButton);
        red3 = findViewById(R.id.redThreeRadioButton);
        pos1 = findViewById(R.id.fieldPositionOne);
        pos2 = findViewById(R.id.fieldPositionTwo);
        pos3 = findViewById(R.id.fieldPositionThree);
        pos4 = findViewById(R.id.fieldPositionFour);
        positions = new RadioButton[]{pos1,pos2,pos3,pos4};
        setPrevious();
    }

    /**
     * Moves the xml/page to auto as long as the team number is a valid team number
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void toAuto(View view){
        if (checkTeams(Integer.decode(teamNumber.getText().toString()))){
            Intent next = new Intent(this, AutoActivity.class);
            startActivity(next);
            saveData();
        }
    }

    /**
     * Checks the entered team number in the team list to see if the team is a valid team
     *
     * @param teamNum team number entered by scout
     *
     * @return true or false
     */
    public boolean checkTeams(int teamNum) {
        for (int i = 0; i < teamList.length; i++){
            if (teamList[i] == teamNum){
                return true;
            }
        }
        return false;
    }

    /**
     * Clears all the field positions
     */
    private void clearPositions(){
        for(RadioButton pos: positions){
            pos.setChecked(false);
        }
    }

    /**
     * Acts as a radio group by only allowing you to select one radio button
     *
     * @param view Makes the method viewable to the xml and allows you to assign the method to a button
     */
    public void clicked(View view) {
        for(int i = 0; i < positions.length;i++) {
            if(positions[i].isChecked()) {
                if(checkedPosition != i) {
                    checkedPosition = i;
                    break;
                }
            }
        }
        clearPositions();
        positions[checkedPosition].setChecked(true);
    }

    /**
     * Sets all values to the ones in RecordsActivity so pages don't change whenever you switch between them
     */
    public void setPrevious(){
        scoutName.setText(RecordsActivity.Info.scoutName);
        matchNumber.setText(RecordsActivity.Info.matchNumber);
        teamNumber.setText(RecordsActivity.Info.teamNumber);
        preloadCheck.setChecked(RecordsActivity.Info.preload);

        switch (RecordsActivity.Info.driverStation) {
            case "Red 1":
                red1.setChecked(true);
                break;
            case "Red 2":
                red2.setChecked(true);
                break;
            case "Red 3":
                red3.setChecked(true);
                break;
            default:
                red1.setChecked(false);
                red2.setChecked(false);
                red3.setChecked(false);
                break;
        }

        switch (RecordsActivity.Info.fieldPosition){
            case 1:
                pos1.setChecked(true);
                break;
            case 2:
                pos2.setChecked(true);
                break;
            case 3:
                pos3.setChecked(true);
                break;
            case 4:
                pos4.setChecked(true);
                break;
            default:
                clearPositions();
                break;
        }
    }

    /**
     * Stores all current data in RecordsActivity
     */
    public void saveData(){
        RecordsActivity.Info.scoutName = scoutName.getText().toString();
        RecordsActivity.Info.matchNumber = matchNumber.getText().toString();
        RecordsActivity.Info.teamNumber = teamNumber.getText().toString();
        RecordsActivity.Info.preload = preloadCheck.isChecked();

        if(red1.isChecked()){
            RecordsActivity.Info.driverStation = "Red 1";
        } else if (red2.isChecked()){
            RecordsActivity.Info.driverStation = "Red 2";
        } else if (red3.isChecked()){
            RecordsActivity.Info.driverStation = "Red 3";
        } else {
            RecordsActivity.Info.driverStation = "";
        }

        switch (checkedPosition){
            case 0:
                RecordsActivity.Info.fieldPosition = 1;
                break;
            case 1:
                RecordsActivity.Info.fieldPosition = 2;
                break;
            case 2:
                RecordsActivity.Info.fieldPosition = 3;
                break;
            case 3:
                RecordsActivity.Info.fieldPosition = 4;
                break;
            default:
                RecordsActivity.Info.fieldPosition = 0;
                break;

        }
    }
}