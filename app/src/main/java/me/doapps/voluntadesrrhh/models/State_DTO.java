package me.doapps.voluntadesrrhh.models;

/**
 * Created by jonathan on 22/04/2015.
 */
public class State_DTO {
    private String name;
    private int state;

    public State_DTO() {
    }

    public State_DTO(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
