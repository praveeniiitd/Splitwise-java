package Model;

import java.util.Objects;

public class Cab {
    private String model;
    private String cabId;
    private CabTypeEnum type;
    private int locationX;
    private int locationY;
    private String status;

    public Cab() {
    }

    public Cab(String model, String cabId, CabTypeEnum type) {
        this.model = model;
        this.cabId = cabId;
        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCabId() {
        return this.cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public CabTypeEnum getType() {
        return this.type;
    }

    public void setType(CabTypeEnum type) {
        this.type = type;
    }

    public Cab model(String model) {
        this.model = model;
        return this;
    }

    public Cab cabId(String cabId) {
        this.cabId = cabId;
        return this;
    }

    public Cab type(CabTypeEnum type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cab)) {
            return false;
        }
        Cab cab = (Cab) o;
        return Objects.equals(model, cab.model) && Objects.equals(cabId, cab.cabId) && Objects.equals(type, cab.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cabId, type);
    }

    @Override
    public String toString() {
        return "{" +
            " model='" + getModel() + "'" +
            ", cabId='" + getCabId() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }


    public Cab(String model, String cabId, CabTypeEnum type, int locationX, int locationY) {
        this.model = model;
        this.cabId = cabId;
        this.type = type;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int getLocationX() {
        return this.locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Cab locationX(int locationX) {
        this.locationX = locationX;
        return this;
    }

    public Cab locationY(int locationY) {
        this.locationY = locationY;
        return this;
    }


    public Cab(String model, String cabId, CabTypeEnum type, int locationX, int locationY, String status) {
        this.model = model;
        this.cabId = cabId;
        this.type = type;
        this.locationX = locationX;
        this.locationY = locationY;
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cab status(String status) {
        this.status = status;
        return this;
    }


}