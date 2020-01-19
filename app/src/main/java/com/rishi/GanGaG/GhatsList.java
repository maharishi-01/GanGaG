package com.rishi.GanGaG;

public class GhatsList {
    String name,location,about,specific;
    public GhatsList()
    {

    }


    public GhatsList(String name, String location, String about, String specific) {
        this.name = name;
        this.location = location;
        this.about = about;
        this.specific = specific;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }
}
