package com.tsi.tom.crosby.Cocktail_webservice;

public class Storage {

    String Name;
    String Type;
    int Size;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        this.Size = size;
    }

    public Storage(String name, String type, int size) {
        Name = name;
        Type = type;
        Size = size;
    }
}
