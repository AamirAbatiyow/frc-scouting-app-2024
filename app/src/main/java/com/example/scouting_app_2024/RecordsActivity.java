package com.example.scouting_app_2024;

public class RecordsActivity {
    public static class Info {
        //main activity
        public static String scoutName = "";
        public static String matchNumber = "";
        public static String teamNumber = "";
        public static boolean preload = false;
        public static byte driverStation = 0;
        public static byte fieldPosition = 0;
        //auto activity
        public static boolean leave = false;
        public static byte autoAmpNotes = 0;
        public static byte autoSpeakerNotes = 0;
        public static byte autoAmpNotesMissed = 0;
        public static byte autoSpeakerNotesMissed = 0;
        public static String autoComments = "";
        //tele activity
        public static byte teleAmpNotes = 0;
        public static byte teleSpeakerNotes = 0;
        public static byte teleAmpNotesMissed = 0;
        public static byte teleSpeakerNotesMissed = 0;
        public static String teleComments = "";
        //stage activity
        public static byte stageLevel = 0;
        public static boolean harmony = false;
        public static boolean trap = false;
        public static String stageComments = "";

        /**
         * Turns a boolean into either a yes or no for the JSON file
         *
         * @param checkBox boolean value being passed in from the checkboxes
         *
         * @return yes or no
         */
        public static String printBoolean(boolean checkBox) {
            if(checkBox){
                return "Yes";
            } else {
                return "No";
            }
        }

        /**
         * Calculates a percentage to the nearest hundredths place for the JSON file
         *
         * @param made number of made notes
         * @param missed number of missed notes
         *
         * @return percentage to the nearest hundredths
         */
        public static double getPercentage(byte made, byte missed) {
            return (double) Math.round(made * 100.0) / (made + missed);
        }

        /**
         * Takes all your values from Records.java and puts them into a formatted JSON file with titles
         *
         * @return full JSON file with all of the values
         */
        public static String CreateJSON() {
            //main activity
            String json = String.format("{\n\tScout Name: \"%s\",",scoutName);
            json += String.format("\tMatch Number: \"%s\",",matchNumber);
            json += String.format("\tTeam Number: \"%s\",",teamNumber);
            json += String.format("\tPreload: \"%s\",",printBoolean(preload));
            json += String.format("\tDriver Station: \"%s\",",driverStation);
            json += String.format("\tStarting Position: \"%s\",",fieldPosition);
            //auto activity
            json += String.format("\n\tLeave: \"%s\",",printBoolean(leave));
            json += String.format("\tAutoAmp: \"%s\",",autoAmpNotes);
            json += String.format("\tAutoSpeaker: \"%s\",",autoSpeakerNotes);
            json += String.format("\tAutoAmpMissed: \"%s\",",autoAmpNotesMissed);
            json += String.format("\tAutoSpeakerMissed: \"%s\",",autoSpeakerNotesMissed);
            json += String.format("\tAutoAmpPercentage: \"%s\",",getPercentage(autoAmpNotes, autoAmpNotesMissed));
            json += String.format("\tAutoSpeakerPercentage: \"%s\",",getPercentage(autoSpeakerNotes, autoSpeakerNotesMissed));
            json += String.format("\tAutoComment: \"%s\",",autoComments);
            //tele activity
            json += String.format("\tTeleAmp: \"%s\",",teleAmpNotes);
            json += String.format("\tTeleSpeaker: \"%s\",",teleSpeakerNotes);
            json += String.format("\tTeleAmpMissed: \"%s\",",teleAmpNotesMissed);
            json += String.format("\tTeleSpeakerMissed: \"%s\",",teleSpeakerNotesMissed);
            json += String.format("\tTeleAmpPercentage: \"%s\",",getPercentage(teleAmpNotes, teleAmpNotesMissed));
            json += String.format("\tTeleSpeakerPercentage: \"%s\",",getPercentage(teleSpeakerNotes, teleSpeakerNotesMissed));
            json += String.format("\tTeleComment: \"%s\",",teleComments);
            //stage activity
            json += String.format("\n\tStage: \"%s\",",stageLevel);
            json += String.format("\tHarmony: \"%s\",",printBoolean(harmony));
            json += String.format("\tTrap: \"%s\",",printBoolean(trap));
            json += String.format("\tStageComment: \"%s\",}\n",stageComments);
            return json;
        }

        /**
         * clears all values from Records.java
         */
        public static void clear(){
            //main activity
            //matchNumber = Integer.toString(Integer.decode(matchNumber)+1);
            matchNumber = "";
            teamNumber = "";
            preload = false;
            fieldPosition = 0;
            //auto activity
            leave = false;
            autoAmpNotes = 0;
            autoSpeakerNotes = 0;
            autoAmpNotesMissed = 0;
            autoSpeakerNotesMissed = 0;
            autoComments = "";
            //tele activity
            teleAmpNotes = 0;
            teleSpeakerNotes = 0;
            teleAmpNotesMissed = 0;
            teleSpeakerNotesMissed = 0;
            teleComments = "";
            //stage activity
            stageLevel = 0;
            harmony = false;
            trap = false;
            stageComments = "";
        }
    }
}