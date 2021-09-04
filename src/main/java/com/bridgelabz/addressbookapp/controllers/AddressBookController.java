package com.bridgelabz.addressbookapp.controllers;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    /**
     * This api handles request to get all the records.
     *
     * @return All Persons records.
     */
    @GetMapping("/persons")
    public ResponseEntity<ResponseDTO> getPersonsAddress()
    {
        AddressBookDTO addressBookDTO = new AddressBookDTO("Mihir Patil", "Shriwardhan",
                                    "Shriwardhan", "Maharashtra",402110,"9987884804");
        AddressBookData addressBookData = new AddressBookData(1,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Gel Call Success :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
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
        AddressBookDTO addressBookDTO = new AddressBookDTO("Mihir Patil", "Shriwardhan",
                "Shriwardhan", "Maharashtra",402110,"9987884804");
        AddressBookData addressBookData = new AddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Gel Call Success :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * This api handles request to create new record of person.
     *
     * @return If successfully created then returns same persons details with message.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addPersonsAddress(@RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = new AddressBookData(2,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Person Data Successfully :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * This api handles update persons details request.
     *
     * @return Appropriate message which updated persons details.
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updatePersonsAddress(@PathVariable("personId") int personId,
                                                       @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = new AddressBookData(personId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Persons Data Updated Successfully :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
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
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", "Deleted Id : "+ personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
