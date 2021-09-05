package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> addressBookDataList = new ArrayList<>();

    /**
     * This method gives back all the records present in database.
     *
     * @return List of all the records.
     */
    @Override
    public List<AddressBookData> getPersonsAddressData() {
        return addressBookDataList;
    }

    /**
     * This method gives back single record which matches to given id.
     *
     * @param personId - holds id to which record is being match.
     * @return single record.
     */
    @Override
    public AddressBookData getPersonsAddressDataById(int personId) {
        return addressBookDataList.stream()
                .filter(addressBookData -> addressBookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Requested Persons Data For An Given Id Is Not Found."));
    }

    /**
     * This method create new record and store it into database.
     *
     * @param addressBookDTO - holds all the information of record to be saved.
     * @return same record with appropriate message.
     */
    @Override
    public AddressBookData createPersonsAddressData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDataList.size()+1,addressBookDTO);
        addressBookDataList.add(addressBookData);
        return addressBookData;
    }

    /**
     * This method updates the existing record with the given new properties value.
     *
     * @param personId - id is passed to check if the record is existed or not.
     * @param addressBookDTO holds information to be updated.
     * @return updated record.
     */
    @Override
    public AddressBookData updatePersonsAddressData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getPersonsAddressDataById(personId);
        addressBookData.setFullName(addressBookDTO.fullName);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setZipcode(addressBookDTO.zipcode);
        addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressBookDataList.set(personId-1,addressBookData);
        return addressBookData;
    }

    /**
     * This method delete record from database.
     *
     * @param personId - is passed to check if data is present, if yes delete the matching record.
     */
    @Override
    public void deletePersonsAddressData(int personId) {
        addressBookDataList.remove(personId-1);
    }
}
