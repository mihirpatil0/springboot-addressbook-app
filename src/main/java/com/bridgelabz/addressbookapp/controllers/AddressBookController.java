package com.bridgelabz.addressbookapp.controllers;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * This api handles request to get all the records.
     *
     * @return All Persons records.
     */
    @GetMapping("/persons")
    public ResponseEntity<ResponseDTO> getPersonsAddress()
    {
        List<AddressBookData> addressList = addressBookService.getPersonsAddressData();
        ResponseDTO responseDTO =  new ResponseDTO("Get Call Success : ", addressList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles request for specific person by its id.
     *
     * @param personId - Specifies which record to get.
     * @return Person details.
     */
    @GetMapping("/person/{personId}")
    public ResponseEntity<ResponseDTO> getPersonsAddress(@PathVariable("personId") int personId)
    {
        AddressBookData addressBookData = addressBookService.getPersonsAddressDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles request to create new record of person.
     *
     * @return If successfully created then returns same persons details with message.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addPersonsAddress(@Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookService.createPersonsAddressData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Persons AddressBook Data Successfully :",
                                    addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles update persons details request.
     *
     * @return Appropriate message which updated persons details.
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updatePersonsAddress(@PathVariable("personId") int personId,
                                                       @Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookService.updatePersonsAddressData(personId, addressBookDTO);
        ResponseDTO responseDTO =  new ResponseDTO("Persons AddressBook Data Updated Successfully: ",
                                                    addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This api handles delete request which delete person record.
     *
     * @param personId - specified which record to be deleted.
     * @return appropriate message.
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deletePersonsAddress(@PathVariable("personId") int personId)
    {
        addressBookService.deletePersonsAddressData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", "Deleted Id : "+ personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
