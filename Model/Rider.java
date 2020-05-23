package Uber.Model;

import java.util.Objects;

public class Rider extends Person {
    private String riderId;
    private Account account;
    private int locationX;
    private int locationY;

    public Rider() {
        account = new Account();
        locationX = 0;
        locationY = 0;
    }

    public Rider(String riderId, Account account) {
        this.riderId = riderId;
        this.account = account;
    }

    public String getRiderId() {
        return this.riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Rider riderId(String riderId) {
        this.riderId = riderId;
        return this;
    }

    public Rider account(Account account) {
        this.account = account;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rider)) {
            return false;
        }
        Rider rider = (Rider) o;
        return Objects.equals(riderId, rider.riderId) && Objects.equals(account, rider.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(riderId, account);
    }

    @Override
    public String toString() {
        return "{" +
            " riderId='" + getRiderId() + "'" +
            ", account='" + getAccount() + "'" +
            "}";
    }


    public Rider(String riderId, Account account, int locationX, int locationY) {
        this.riderId = riderId;
        this.account = account;
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

    public Rider locationX(int locationX) {
        this.locationX = locationX;
        return this;
    }

    public Rider locationY(int locationY) {
        this.locationY = locationY;
        return this;
    }

}