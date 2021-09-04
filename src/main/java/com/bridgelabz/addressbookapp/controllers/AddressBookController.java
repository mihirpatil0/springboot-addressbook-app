package com.bridgelabz.addressbookapp.controllers;

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
    public ResponseEntity<String> getPersonsAddress()
    {
        return new ResponseEntity<String>("Get Call Success: ", HttpStatus.OK);
    }

    /**
     * This api handles request for specific person by its id.
     *
     * @param personId - Specifies which record to get.
     * @return Person details.
     */
    @GetMapping("/person/{personId}")
    public ResponseEntity<String> getPersonsAddress(@PathVariable("personId") int personId)
    {
        return new ResponseEntity<String>("Get Call Success: " + personId,HttpStatus.OK);
    }

    /**
     * This api handles request to create new record of person.
     *
     * @return If successfully created then returns same persons details with message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> addPersonsAddress()
    {
        return new ResponseEntity<String>("Created Person : ",HttpStatus.OK);
    }

    /**
     * This api handles update persons details request.
     *
     * @return Appropriate message which updated persons details.
     */
    @PutMapping("/update")
    public ResponseEntity<String> updatePersonsAddress()
    {
        return new ResponseEntity<String>("Updated Persons Details :",HttpStatus.OK);
    }

    /**
     * This api handles delete request which delete person record.
     *
     * @param personId - specified which record to be deleted.
     * @return appropriate message.
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deletePersonsAddress(@PathVariable("personId") int personId)
    {
        return new ResponseEntity<String>("Delete Call Success For Id : " + personId,HttpStatus.OK);
    }
}
