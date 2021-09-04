package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getPersonsAddressData();
    AddressBookData getPersonsAddressDataById(int personId);
    AddressBookData createPersonsAddressData(AddressBookDTO addressBookDTO);
    AddressBookData updatePersonsAddressData(int personId, AddressBookDTO addressBookDTO);
    void deletePersonsAddressData(int personId);
}
