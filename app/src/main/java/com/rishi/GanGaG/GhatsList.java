package com.rishi.GanGaG;

public class GhatsList {
    String Name,Location,About,Specific,Time;
    public GhatsList()
    {

    }

    public GhatsList(String name, String location, String about, String specific,String time) {
        Name = name;
        Location = location;
        About = about;
        Specific = specific;
        Time=time;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getSpecific() {
        return Specific;
    }

    public void setSpecific(String specific) {
        Specific = specific;
    }
}
