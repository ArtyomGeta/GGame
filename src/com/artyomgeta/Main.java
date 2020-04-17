package com.artyomgeta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final int BOT_ANTON = 0;

    public static void main(String[] args) {
        new Menu();
    }

    public static String returnStory(int storyID) {
        StringBuilder stringBuilder = new StringBuilder();
        String returnable = "";
        try {
            Scanner myReader = new Scanner(new File("data/story.json"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();
            returnable = new JSONArray(stringBuilder.toString()).getJSONObject(storyID).getString("text");
        } catch (FileNotFoundException | JSONException e) {
            e.printStackTrace();
        }
        return returnable;
    }

    public static void saveGame(int heroType, int[] skills) throws IOException, JSONException {
        FileWriter fileWriter = new FileWriter(new File("saves/" + (Main.returnSavesLength() - 1) + "/hero.json" ));
        JSONArray heroArray = new JSONArray();
        JSONObject skillsObject = new JSONObject();
        skillsObject.put("hero-type", heroType);
        skillsObject.put("strength", skills[0]);
        skillsObject.put("agility", skills[1]);
        skillsObject.put("intellect", skills[2]);
        heroArray.put(skillsObject);
        //heroArray.put(new String[] {"aaa", "bbb", "ccc"});
        fileWriter.write(heroArray.toString());
        fileWriter.close();
    }

    public static int strength = returnSkill(0);
    public static int agility = returnSkill(1);
    public static int intellect = returnSkill(2);

    public static int changeSkill(int skill, int value) {
        int returnable = 0;
        if (skill == 0) {
            strength += value;
            returnable = strength;
        } else if (skill == 1) {
            agility += value;
            returnable = agility;
        } else if (skill == 2) {
            intellect += value;
            returnable = intellect;
        }
        return returnable;
    }

    public static int changeSkill(int skill) {
        int returnable = 0;
        if (skill == 0) {
            returnable = strength;
        } else if (skill == 1) {
            returnable = agility;
        } else if (skill == 2) {
            returnable = intellect;
        }
        return returnable;
    }

    public static int returnSkill(int skill) {
        StringBuilder stringBuilder = new StringBuilder();
        int returnable = 0;
        try {
            Scanner myReader = new Scanner(!Main.isNewGame() ? new File("hero.json") : new File("saves/0/hero.json"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();
            if (skill == 0)
                returnable = new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("strength");
            else if (skill == 1) {
                returnable = new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("agility");
            } else if (skill == 2) {
                returnable = new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("intellect");
            }
        } catch (FileNotFoundException | JSONException e) {
            e.printStackTrace();
        }
        return returnable;
    }

    public static String[] returnHuman(int id) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] returnable = new String[7];
        try {
            Scanner myReader = new Scanner(new File("data/people/" + id + ".json"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            returnable[0] = new JSONArray(stringBuilder.toString()).getJSONObject(0).getString("name");
            returnable[1] = String.valueOf(new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("character")).replace("0", "Верзила").replace("1", "Ловкач").replace("2", "Умный");
            returnable[2] = String.valueOf(new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("power"));
            returnable[3] = String.valueOf(new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("agility"));
            returnable[4] = String.valueOf(new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("intellect"));
            returnable[5] = String.valueOf(new JSONArray(stringBuilder.toString()).getJSONObject(0).getInt("weapon"));
            returnable[6] = (new JSONArray(stringBuilder.toString()).getJSONObject(0).getString("more"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return returnable;
    }

    public static int returnSavesLength() {
        return Objects.requireNonNull(new File("saves/").list()).length;
    }

    public static boolean isNewGame() {
        return Objects.requireNonNull(new File("saves/").list()).length != 0;
    }

}
