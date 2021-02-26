package bsse.asu.edu.ser423sambuddhanathandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import bsse.asu.edu.eduasubsse1219597327ser423sambuddhanathandroid.R;
import bsse.asu.edu.ser423sambuddhanathandroid.models.PlaceDescriptionPOJO;

public class PlaceDescriptionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public PlaceLibrary placeLibrary;
    private ListView placeDescriptionAdapterListView;
    private ArrayList<HashMap<String, String>> placeDescriptionList;

    private static final String placeDescriptionKey = "_placeDescriptionKey";
    private static final String placeDescriptionValue = "_placeDescriptionValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_description_list);

        placeLibrary = new PlaceLibrary(this);
        placeDescriptionAdapterListView = (ListView) findViewById(R.id.place_description_list);
        prepareListData();
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, placeDescriptionList, R.layout.place_description,
                                                        new String[]{placeDescriptionKey, placeDescriptionValue},
                                                        new int[]{R.id.descriptionKey, R.id.descriptionValue});
        placeDescriptionAdapterListView.setAdapter(simpleAdapter);
        placeDescriptionAdapterListView.setOnItemClickListener(this);

    }

    private void prepareListData() {
        HashMap<String, PlaceDescriptionPOJO> placeDescriptionPOJOHashTable = placeLibrary.getPlaceDescriptionPOJOHashMap();
        placeDescriptionList = new ArrayList<>();

        Iterator it = placeDescriptionPOJOHashTable.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            PlaceDescriptionPOJO placeDescriptionPOJO = (PlaceDescriptionPOJO) pair.getValue();

            // Place Name
            HashMap<String, String> data1 = new HashMap<>();
            data1.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeName));
            data1.put(placeDescriptionValue, placeDescriptionPOJO.getName());
            placeDescriptionList.add(data1);

            // Place Description
            HashMap<String, String> data2 = new HashMap<>();
            data2.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeDescription));
            data2.put(placeDescriptionValue, placeDescriptionPOJO.getDescription());
            placeDescriptionList.add(data2);

            // Place Category
            HashMap<String, String> data3 = new HashMap<>();
            data3.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeCategory));
            data3.put(placeDescriptionValue, placeDescriptionPOJO.getCategory());
            placeDescriptionList.add(data3);

            // Place Address Title
            HashMap<String, String> data4 = new HashMap<>();
            data4.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeAddressTitle));
            data4.put(placeDescriptionValue, placeDescriptionPOJO.getAddressTitle());
            placeDescriptionList.add(data4);

            // Place Elevation
            HashMap<String, String> data5 = new HashMap<>();
            data5.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeElevation));
            data5.put(placeDescriptionValue, placeDescriptionPOJO.getElevation());
            placeDescriptionList.add(data5);

            // Place Latitude
            HashMap<String, String> data6 = new HashMap<>();
            data6.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeLatitude));
            data6.put(placeDescriptionValue, placeDescriptionPOJO.getLatitude());
            placeDescriptionList.add(data6);

            // Place Longitude
            HashMap<String, String> data7 = new HashMap<>();
            data7.put(placeDescriptionKey, PlaceDescriptionActivity.this.getResources().getString(R.string.placeLongitude));
            data7.put(placeDescriptionValue, placeDescriptionPOJO.getLongitude());
            placeDescriptionList.add(data7);

            it.remove();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, placeDescriptionList.get(i).get(placeDescriptionKey) + " : " + placeDescriptionList.get(i).get(placeDescriptionValue), Toast.LENGTH_SHORT).show();
    }
}
