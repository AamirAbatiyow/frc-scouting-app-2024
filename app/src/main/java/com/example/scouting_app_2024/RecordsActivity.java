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
        public static String teleComments = "";
        public static byte cycles = 0;
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
            cycles = (byte)(teleAmpNotes+teleAmpNotesMissed+teleSpeakerNotes+teleSpeakerNotesMissed);
            //main activity
            String json = String.format("%s",matchNumber);
            json += String.format("\t%s",teamNumber);
            json += String.format("\t%s",printBoolean(preload));
            json += String.format("\t%s",driverStation);
            json += String.format("\t%s",fieldPosition);
            //auto activity
            json += String.format("\t%s",autoNotesMissed);
            json += String.format("\t%s",printBoolean(leave));
            json += String.format("\t%s",autoAmpNotes);
            json += String.format("\t%s",autoAmpNotesMissed);
            json += String.format("\t%s",getPercentage(autoAmpNotes, autoAmpNotesMissed));
            json += String.format("\t%s",autoSpeakerNotes);
            json += String.format("\t%s",autoSpeakerNotesMissed);
            json += String.format("\t%s",getPercentage(autoSpeakerNotes, autoSpeakerNotesMissed));
            json += String.format("\t%s",autoComments);
            //tele activity
            json += String.format("\t%s",teleAmpNotes);
            json += String.format("\t%s",teleAmpNotesMissed);
            json += String.format("\t%s",getPercentage(teleAmpNotes, teleAmpNotesMissed));
            json += String.format("\t%s",teleSpeakerNotes);
            json += String.format("\t%s",teleSpeakerNotesMissed);
            json += String.format("\t%s",getPercentage(teleSpeakerNotes, teleSpeakerNotesMissed));
            json += String.format("\t%s",teleComments);
            json += String.format("\t%s",cycles);
            //stage activity
            json += String.format("\t%s",stageLevel);
            json += String.format("\t%s",printBoolean(harmony));
            json += String.format("\t%s",printBoolean(trap));
            json += String.format("\t%s",stageComments);
            json += String.format("\t%s",scoutName);
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
            teleComments = "";
            cycles = 0;
            //stage activity
            stageLevel = 0;
            harmony = false;
            trap = false;
            stageComments = "";
        }
    }
}