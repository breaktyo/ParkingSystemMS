package com.cityservice.model;

public class ParkingZone {
    private int id;
    private String nazwa;
    private boolean czyLegalna;

    public ParkingZone() {
    }

    public ParkingZone(int id, String nazwa, boolean czyLegalna) {
        this.id = id;
        this.nazwa = nazwa;
        this.czyLegalna = czyLegalna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean isCzyLegalna() {
        return czyLegalna;
    }

    public void setCzyLegalna(boolean czyLegalna) {
        this.czyLegalna = czyLegalna;
    }

    @Override
    public String toString() {
        return "ParkingZone{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", czyLegalna=" + czyLegalna +
                '}';
    }
}