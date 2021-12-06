package com.avaliacao.stoom.rest;

import com.avaliacao.stoom.exceptions.AddressNotFoundException;
import com.avaliacao.stoom.exceptions.AddressNotFoundOnGoogleAPIException;
import com.avaliacao.stoom.exceptions.MalformedBodyException;
import com.avaliacao.stoom.integration.GoogleAPIIntegration;
import com.avaliacao.stoom.integration.GoogleAPIModel;
import com.avaliacao.stoom.model.Address;
import com.avaliacao.stoom.model.AddressDTO;
import com.avaliacao.stoom.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;

    private final GoogleAPIIntegration googleAPIIntegration;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository,
                       GoogleAPIIntegration googleAPIIntegration) {
        this.addressRepository = addressRepository;
        this.googleAPIIntegration = googleAPIIntegration;
    }

    @Override
    public AddressDTO getAddressById(Long id) throws AddressNotFoundException {
        return AddressDTO.fromEntity(this.addressRepository.findById(id).orElseThrow(AddressNotFoundException::new));
    }

    @Override
    public AddressDTO saveNewAddress(AddressDTO addressDTO) throws AddressNotFoundOnGoogleAPIException {
        if (addressDTO.getLatitude() == null && addressDTO.getLongitude() == null) {
            GoogleAPIModel apiModel = this.googleAPIIntegration.getLongLatFromAddress(addressDTO);
            if (apiModel.getStatus().equals("ZERO_RESULTS")) {
                throw new AddressNotFoundOnGoogleAPIException();
            }
            addressDTO.setLongitude(apiModel.getResults().get(0).getGeometry().getLocation().getLng());
            addressDTO.setLatitude(apiModel.getResults().get(0).getGeometry().getLocation().getLat());
        }

        Address entity = this.addressRepository.save(AddressDTO.toEntity(addressDTO));

        return AddressDTO.fromEntity(entity);
    }

    @Override
    public AddressDTO editAddress(AddressDTO addressDTO, Long id) throws MalformedBodyException {
        if (!id.equals(addressDTO.getId())) {
            throw new MalformedBodyException();
        }

        Address entity = this.addressRepository.save(AddressDTO.toEntity(addressDTO));
        return AddressDTO.fromEntity(entity);
    }

    @Override
    public void deleteAddressById(Long id) throws AddressNotFoundException {
        this.addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        this.addressRepository.deleteById(id);
    }
}
