package com.avaliacao.stoom.rest;

import com.avaliacao.stoom.exceptions.AddressNotFoundException;
import com.avaliacao.stoom.exceptions.AddressNotFoundOnGoogleAPIException;
import com.avaliacao.stoom.exceptions.MalformedBodyException;
import com.avaliacao.stoom.model.AddressDTO;

public interface AddressService {

    AddressDTO getAddressById(Long id) throws AddressNotFoundException;

    AddressDTO saveNewAddress(AddressDTO addressDTO) throws AddressNotFoundOnGoogleAPIException;

    AddressDTO editAddress(AddressDTO addressDTO, Long id) throws MalformedBodyException;

    void deleteAddressById(Long id) throws AddressNotFoundException;
}
