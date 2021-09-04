package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

    public String fullName;
    public String address;
    public String city;
    public String state;
    public long zipcode;
    public String phoneNumber;

    public AddressBookDTO(String fullName, String address, String city, String state, long zipcode, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
