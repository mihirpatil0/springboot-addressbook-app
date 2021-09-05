package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addressbook")
@Data
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "fullname")
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;

    public AddressBookData() {}

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO){
        this.fullName = addressBookDTO.fullName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipcode = addressBookDTO.zipcode;
        this.phoneNumber = addressBookDTO.phoneNumber;
    }
}
