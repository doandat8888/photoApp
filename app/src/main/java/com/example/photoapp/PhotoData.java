package com.example.photoapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PhotoData {
    public static ArrayList<Photo> generatePhotoData(Context context) {
        ArrayList<Photo> photos = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("people.json");
            int size = inputStream.available();
            byte buffer[] = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json;
            String title, description, imgSrc;
            int max;
            int id;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            for(int i = 0; i < max; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getInt("id");
                imgSrc = jsonObject.getString("url");
                title = jsonObject.getString("title");
                description = jsonObject.getString("description");
                photos.add(new Photo(id, imgSrc, title, description));
            }
            return photos;

        }catch (IOException | JSONException e) {
            return null;
        }

    }

    public static Photo getPhotoFromId(int id, Context c) {
        ArrayList<Photo> phs = PhotoData.generatePhotoData(c);
        for(int i = 0; i < phs.size(); i++) {
            if(phs.get(i).getId() == id) {
                return phs.get(i);
            }
        }
        return null;
    }
}
