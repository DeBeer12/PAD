package sample.models;

public class Game {
    private int punten;
    private int balls;

    private int id;

    private int sensor1;
    private int sensor2;
    private int sensor3;
    private int sensor4;
    private int sensor5;

    public Game(int id, int sensor1, int sensor2, int sensor3, int sensor4, int sensor5) {
        this.id = id;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.sensor4 = sensor4;
        this.sensor5 = sensor5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSensor1() {
        return sensor1;
    }

    public void setSensor1(int sensor1) {
        this.sensor1 = sensor1;
    }

    public int getSensor2() {
        return sensor2;
    }

    public void setSensor2(int sensor2) {
        this.sensor2 = sensor2;
    }

    public int getSensor3() {
        return sensor3;
    }

    public void setSensor3(int sensor3) {
        this.sensor3 = sensor3;
    }

    public int getSensor4() {
        return sensor4;
    }

    public void setSensor4(int sensor4) {
        this.sensor4 = sensor4;
    }

    public int getSensor5() {
        return sensor5;
    }

    public void setSensor5(int sensor5) {
        this.sensor5 = sensor5;
    }


}
