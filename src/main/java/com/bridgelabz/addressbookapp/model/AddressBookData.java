package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

@Data
public class AddressBookData {

    private int personId;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;

    public AddressBookData() {}

    public AddressBookData(int personId, AddressBookDTO addressBookDTO){
        this.personId = personId;
        this.fullName = addressBookDTO.fullName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipcode = addressBookDTO.zipcode;
        this.phoneNumber = addressBookDTO.phoneNumber;
    }
}
