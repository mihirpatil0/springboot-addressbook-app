package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {

    @NotEmpty(message = "Persons full-name cannot be null.")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$",message = "Persons full-name is Invalid")
    public String fullName;

    @NotBlank(message = "Address cannot be Empty")
    public String address;

    @NotBlank(message = "City cannot be Empty")
    public String city;

    @NotBlank(message = "State cannot be Empty")
    public String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "ZipCode is Invalid")
    public String zipcode;

    @Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$",
            message = "Only 10 Digit number valid")
    public String phoneNumber;

    public AddressBookDTO(String fullName, String address, String city, String state, String zipcode, String phoneNumber) {
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
