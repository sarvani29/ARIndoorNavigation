package com.ustglobal.arcloudanchors;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  The "‚‗‚" character is not a comma, it is the SINGLE LOW-9 QUOTATION MARK unicode 201A
 *  and unicode 2017 that are used for separating the items in a list.
 */
public class DB {

    /**
     * Shared Preferences allows us to save and retrieve data in the form of key,value pair.
     */

    private SharedPreferences preferences;

    public DB(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    /**
     * Add ArrayList of String into SharedPreferences with 'key' and save
     *
     * @param key        SharedPreferences key
     * @param stringList ArrayList of String to be added
     */
    public void addListString(String key, ArrayList<String> stringList) {
        if (key == null) {
            throw new NullPointerException();
        } else {
            String[] myStringList = stringList.toArray(new String[stringList.size()]);
            preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
        }
    }

    /**
     * Get parsed ArrayList of String from SharedPreferences at 'key'
     *
     * @param key SharedPreferences key
     * @return ArrayList of String
     */
    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }


}