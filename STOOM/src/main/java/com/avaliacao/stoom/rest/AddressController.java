package com.avaliacao.stoom.rest;

import com.avaliacao.stoom.exceptions.AddressNotFoundException;
import com.avaliacao.stoom.exceptions.MalformedBodyException;
import com.avaliacao.stoom.model.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(value = AddressController._PATH)
public class AddressController {

    public static final String _PATH = "/addresses";

    private final AddressService addressService;

    @Autowired
    AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(value = "id", name = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.addressService.getAddressById(id));
        } catch (AddressNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDTO> saveNewAddress(@Valid @RequestBody AddressDTO addressDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.addressService.saveNewAddress(addressDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDTO> saveNewAddress(@Valid @RequestBody AddressDTO addressDTO, @PathVariable(value = "id", name = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.addressService.editAddress(addressDTO, id));
        } catch (MalformedBodyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable(value = "id", name = "id") Long id) {
        try {
            this.addressService.deleteAddressById(id);
            return ResponseEntity.ok().build();
        } catch (AddressNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
