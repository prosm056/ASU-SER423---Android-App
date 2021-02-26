package bsse.asu.edu.ser423sambuddhanathandroid.models;

/*
 * Copyright 2021 Sambuddha Nath,
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: Example classes conversion to/from json
 * This example shows the use of Android's
 * org.json package in creating json string of a PlaceDescriptionPOJO object.
 *
 * Ser423 Mobile Applications
 * see http://pooh.poly.asu.edu/Mobile
 * @author Sambuddha Nath snath4@asu.edu
 *         Software Engineering, CIDSE, IAFSE, ASU Poly
 * @version January 2021
 */

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.Serializable;

public class PlaceDescriptionPOJO implements Serializable {

    private String name;
    private String description;
    private String category;
    private String addressTitle;
    private Address address;
    private String elevation;
    private String latitude;
    private String longitude;

    public PlaceDescriptionPOJO(JSONObject jsonObject) throws Exception {
        try {
            this.name = jsonObject.optString("name","unknown");
            this.description = jsonObject.optString("description","unknown");
            this.category = jsonObject.optString("category","unknown");
            this.addressTitle = jsonObject.optString("addressTitle","unknown");

            // get address object
//            JSONObject jsonObjectAddress = jsonObject.getJSONObject("address");
//            this.address.setStreet(jsonObjectAddress.optString("street","unknown"));
//            this.address.setCity(jsonObjectAddress.optString("city","unknown"));
//            this.address.setState(jsonObjectAddress.optString("state","unknown"));
//            this.address.setCountry(jsonObjectAddress.optString("country","unknown"));
//            this.address.setZipCode(jsonObjectAddress.optString("zipCode"));

            this.elevation = jsonObject.optString("elevation");
            this.latitude = jsonObject.optString("latitude");
            this.longitude = jsonObject.optString("longitude");
        } catch (Exception e) {
            System.out.println("Unable to form PlaceDescriptionPOJO object from json format: " + e.getMessage());
            throw e;
        }
    }

    public PlaceDescriptionPOJO getObjectFromString(String sObject) throws Exception {
        JSONObject pdJson = new JSONObject(new JSONTokener(sObject));
        return new PlaceDescriptionPOJO(pdJson);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getAddress() {
        return address.getCompleteAddress();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String toJsonString() throws Exception {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", getName());
            jsonObject.put("description", getDescription());
            jsonObject.put("category", getCategory());
            jsonObject.put("addressTitle", getAddressTitle());
            jsonObject.put("address", getAddress());
            jsonObject.put("elevation", getElevation());
            jsonObject.put("latitude", getLatitude());
            jsonObject.put("longitude", getLongitude());
            return jsonObject.toString();
        } catch (Exception e) {
            System.out.println("Unable to form json string: " + e.getMessage());
            throw e;
        }
    }
}
