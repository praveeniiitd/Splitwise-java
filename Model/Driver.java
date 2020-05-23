package Model;

import java.util.Objects;

public class Driver extends Person {
    private String licenseNo;
    private String driverId;
    private Account account;
    private String availability;

    public Driver() {
        account = new Account();
    }

    public Driver(String licenseNo, String driverId, Account account) {
        this.licenseNo = licenseNo;
        this.driverId = driverId;
        this.account = account;
    }

    public String getLicenseNo() {
        return this.licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getDriverId() {
        return this.driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Driver licenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
        return this;
    }

    public Driver driverId(String driverId) {
        this.driverId = driverId;
        return this;
    }

    public Driver account(Account account) {
        this.account = account;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Driver)) {
            return false;
        }
        Driver driver = (Driver) o;
        return Objects.equals(licenseNo, driver.licenseNo) && Objects.equals(driverId, driver.driverId) && Objects.equals(account, driver.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseNo, driverId, account);
    }

    @Override
    public String toString() {
        return "{" +
            " licenseNo='" + getLicenseNo() + "'" +
            ", driverId='" + getDriverId() + "'" +
            ", account='" + getAccount() + "'" +
            "}";
    }


    public Driver(String licenseNo, String driverId, Account account, String availability) {
        this.licenseNo = licenseNo;
        this.driverId = driverId;
        this.account = account;
        this.availability = availability;
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Driver availability(String availability) {
        this.availability = availability;
        return this;
    }

}