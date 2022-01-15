package com.neyonfna;
// The Used as to record the resident information
public class Resident {
    private String name;
    private String id ;
    private int block;
    private int  phone_number;
    Resident (String name, String id, int block, int phone_number){
        this.name = name;
        this.id = id;
        this.block = block;
        this.phone_number = phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getBlock() {
        return block;
    }

    public int getPhone_number() {
        return phone_number;
    }
    public void rent_States(){
    }
}
