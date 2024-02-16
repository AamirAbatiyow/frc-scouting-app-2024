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
        public static byte autoNotes = 0;
        public static byte autoAmpNotes = 0;
        public static byte autoSpeakerNotes = 0;
        public static String autoComments = "";
        //tele activity
        public static byte teleNotes = 0;
        public static byte teleAmpNotes = 0;
        public static byte teleSpeakerNotes = 0;
        public static String teleComments = "";
        //stage activity
        public static byte stageLevel = 0;
        public static boolean harmony = false;
        public static boolean trap = false;
        public static String stageComments = "";

        public static double test = 3.737546328;
        public static double test1 = 0.7339546;
        public static double test2 = .7339465;
        public static double test3 = 3.7370837648723;

        /**
         * Turns a boolean into either a 1 or 0 for the JSON file
         *
         * @param checkBox boolean value being passed in from the checkboxes
         *
         * @return 1 or 0
         */
        public static int printBoolean(boolean checkBox) {
            if(checkBox){
                return 1;
            } else {
                return 0;
            }
        }

        /**
         * Takes all your values from Records.java and puts them into a formatted JSON file with titles
         *
         * @return full JSON file with all of the values
         */
        public static String CreateJSON() {
            //main activity
            String json = String.format("{\"Name\": \"%s\",",scoutName);
            json += String.format("\"Match\": \"%s\",",matchNumber);
            json += String.format("\"Team\": \"%s\",",teamNumber);
            json += String.format("\"Preload\": \"%d\",",printBoolean(preload));
            json += String.format("\"Station\": \"%s\",",driverStation);
            json += String.format("\"Pos\": \"%s\",",fieldPosition);
            //auto activity
            json += String.format("\"Leave\": \"%d\",",printBoolean(leave));
            json += String.format("\"AutoNote\": \"%s\",",autoNotes);
            json += String.format("\"AutoAmp\": \"%s\",",autoAmpNotes);
            json += String.format("\"AutoSpeaker\": \"%s\",",autoSpeakerNotes);
            json += String.format("\"AutoComment\": \"%s\",",autoComments);
            //tele activity
            json += String.format("\"TeleNote\": \"%s\",",teleNotes);
            json += String.format("\"TeleAmp\": \"%s\",",teleAmpNotes);
            json += String.format("\"TeleSpeaker\": \"%s\",",teleSpeakerNotes);
            json += String.format("\"TeleComment\": \"%s\",",teleComments);
            //stage activity
            json += String.format("\"Stage\": \"%s\",",stageLevel);
            json += String.format("\"Harmony\": \"%s\",",printBoolean(harmony));
            json += String.format("\"Trap\": \"%s\",",printBoolean(trap));
            json += String.format("\"StageComment\": \"%s\",}",stageComments);
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
            leave = false;
            autoNotes = 0;
            autoAmpNotes = 0;
            autoSpeakerNotes = 0;
            autoComments = "";
            //tele activity
            teleNotes = 0;
            teleAmpNotes = 0;
            teleSpeakerNotes = 0;
            teleComments = "";
            //stage activity
            stageLevel = 0;
            harmony = false;
            trap = false;
            stageComments = "";
        }
    }
}
