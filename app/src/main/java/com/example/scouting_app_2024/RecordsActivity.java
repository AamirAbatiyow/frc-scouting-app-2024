package com.example.scouting_app_2024;

public class RecordsActivity {
    public static class Info {
        //main activity
        public static String scoutName = "";
        public static String matchNumber = "";
        public static String teamNumber = "";
        public static boolean preload = false;
        public static String driverStation = "";
        public static byte fieldPosition = 0;
        //auto activity
        public static byte autoNotesMissed = 0;
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
        public static byte passes = 0;
        public static boolean died = false;
        public static boolean broke = false;
        public static boolean defense = false;
        public static String teleComments = "";
        public static byte cycles = 0;
        //stage activity
        public static String stageLevel = "";
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
            cycles = (byte)(teleAmpNotes+teleAmpNotesMissed+teleSpeakerNotes+teleSpeakerNotesMissed);
            //main activity
            String json = String.format("%s",teamNumber);
            json += String.format("*%s",matchNumber);
            json += String.format("*%s",printBoolean(preload));
            json += String.format("*%s",driverStation);
            json += String.format("*%s",fieldPosition);
            //auto activity
            json += String.format("*%s",autoNotesMissed);
            json += String.format("*%s",printBoolean(leave));
            json += String.format("*%s",autoAmpNotes);
            json += String.format("*%s",autoAmpNotesMissed);
            json += String.format("*%s",(int)getPercentage(autoAmpNotes, autoAmpNotesMissed));
            json += String.format("*%s",autoSpeakerNotes);
            json += String.format("*%s",autoSpeakerNotesMissed);
            json += String.format("*%s",(int)getPercentage(autoSpeakerNotes, autoSpeakerNotesMissed));
            json += String.format("*%s",autoComments);
            //tele activity
            json += String.format("*%s",teleAmpNotes);
            json += String.format("*%s",teleAmpNotesMissed);
            json += String.format("*%s",(int)getPercentage(teleAmpNotes, teleAmpNotesMissed));
            json += String.format("*%s",teleSpeakerNotes);
            json += String.format("*%s",teleSpeakerNotesMissed);
            json += String.format("*%s",(int)getPercentage(teleSpeakerNotes, teleSpeakerNotesMissed));
            json += String.format("*%s",printBoolean(died));
            json += String.format("*%s",printBoolean(broke));
            json += String.format("*%s",printBoolean(defense));
            json += String.format("*%s",teleComments);
            json += String.format("*%s",cycles);
            json += String.format("*%s",passes);

            //stage activity
            json += String.format("*%s",stageLevel);
            json += String.format("*%s",printBoolean(harmony));
            json += String.format("*%s",printBoolean(trap));
            json += String.format("*%s",stageComments);
            json += String.format("*%s",scoutName);
            return json;
        }

        /**
         * clears all values from Records.java
         */
        public static void clear(){
            //main activity
            matchNumber = Integer.toString(Integer.decode(matchNumber)+1);
            teamNumber = "";
            preload = false;
            fieldPosition = 0;
            //auto activity
            autoNotesMissed = 0;
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
            passes = 0;
            died = false;
            broke = false;
            defense = false;
            teleComments = "";
            cycles = 0;
            //stage activity
            stageLevel = "";
            harmony = false;
            trap = false;
            stageComments = "";
        }
    }
}