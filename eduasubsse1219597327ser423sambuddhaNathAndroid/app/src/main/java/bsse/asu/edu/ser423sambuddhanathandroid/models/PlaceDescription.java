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
 * org.json package in creating json string of a PlaceDescription object.
 *
 * Ser423 Mobile Applications
 * see http://pooh.poly.asu.edu/Mobile
 * @author Sambuddha Nath snath4@asu.edu
 *         Software Engineering, CIDSE, IAFSE, ASU Poly
 * @version January 2021
 */

import org.json.JSONObject;
import java.io.Serializable;

public class PlaceDescription implements Serializable {

    private String name;
    private String description;
    private String category;
    private String addressTitle;
    private Address address;
    private double elevation;
    private double latitude;
    private double longitude;

    PlaceDescription(JSONObject jsonObject) throws Exception {
        try {
            this.name = jsonObject.getString("name");
            this.description = jsonObject.getString("description");
            this.category = jsonObject.getString("category");
            this.addressTitle = jsonObject.getString("addressTitle");

            // get address object
            JSONObject jsonObjectAddress = jsonObject.getJSONObject("address");
            this.address.setStreet(jsonObjectAddress.getString("street"));
            this.address.setCity(jsonObjectAddress.getString("city"));
            this.address.setState(jsonObjectAddress.getString("state"));
            this.address.setCountry(jsonObjectAddress.getString("country"));
            this.address.setZipCode(jsonObjectAddress.getInt("zipCode"));

            this.elevation = jsonObject.getDouble("elevation");
            this.latitude = jsonObject.getDouble("latitude");
            this.longitude = jsonObject.getDouble("longitude");
        } catch (Exception e) {
            System.out.println("Unable to form PlaceDescription object from json format: " + e.getMessage());
            throw e;
        }
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

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
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
