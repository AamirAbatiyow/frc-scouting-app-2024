package com.example.scouting_app_2024;

public class RecordsActivity {
    public static class Info {
        //main activity
        public static String scoutName = "";
        public static String matchNumber = ""; //could possibly set this to a byte value to save QR space
        public static String teamNumber = "";
        public static byte driverStation = 0;
        public static byte fieldPosition = 0;
        //auto activity
        public static boolean leave = false;
        public static byte autoNotes = 0;
        public static byte autoAmpNotes = 0;
        public static byte autoSpeakerNotes = 0;
        public static String autoComments = "";
        //tele activity
        public static int teleNotes = 0;
        public static int teleAmpNotes = 0;
        public static int teleSpeakerNotes = 0;
        public static String teleComments = "";
        public static boolean playedDefense = false;
        public static boolean facedDefense = false;
        public static boolean fellOver = false;
        public static boolean died = false;
        public static boolean ampScoring = false;
        public static boolean speakerScoring = false;
        //stage activity
        public static byte stageLevel = 0;
        public static boolean harmony = false;
        public static boolean trap = false;
        public static String stageComments = "";

        public static void clear(){

        }
    }
}
