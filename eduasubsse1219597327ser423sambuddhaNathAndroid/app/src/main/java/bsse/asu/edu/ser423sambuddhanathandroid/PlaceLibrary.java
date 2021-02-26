package bsse.asu.edu.ser423sambuddhanathandroid;

import android.app.Activity;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import bsse.asu.edu.eduasubsse1219597327ser423sambuddhanathandroid.R;
import bsse.asu.edu.ser423sambuddhanathandroid.models.PlaceDescriptionPOJO;

public class PlaceLibrary extends Object implements Serializable {
    HashMap<String, PlaceDescriptionPOJO> placeDescriptionPOJOHashTable = new HashMap<>();

    public PlaceLibrary(Activity parent) {
        try {
            this.getDataFromJson(parent);
        } catch (Exception e) {
            android.util.Log.d(this.getClass().getSimpleName(), "error resetting from places json file" + e.getMessage());
        }
    }

    public HashMap<String, PlaceDescriptionPOJO> getPlaceDescriptionPOJOHashMap() {
        return this.placeDescriptionPOJOHashTable;
    }

    private Boolean getDataFromJson(Activity parent) {
        Boolean ret = true;
        try {
            InputStream is = parent.getApplicationContext().getResources().openRawResource(R.raw.places);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            while (br.ready()) {
                sb.append(br.readLine());
            }
            String placesJsonStr = sb.toString();
            JSONObject studentsJson = new JSONObject(new JSONTokener(placesJsonStr));
            Iterator<String> it = studentsJson.keys();
            while (it.hasNext()) {
                String sName = it.next();
                JSONObject aStud = studentsJson.optJSONObject(sName);
                if (aStud != null) {
                    PlaceDescriptionPOJO stu = new PlaceDescriptionPOJO(aStud);
                    placeDescriptionPOJOHashTable.put(sName, stu);
                }
            }
        }catch (Exception e) {
            android.util.Log.d(this.getClass().getSimpleName(), "Exception reading json file: " + e.getMessage());
            ret = false;
        }
        return ret;
    }
}
