package com.avaliacao.stoom.address;

import com.avaliacao.stoom.exceptions.AddressNotFoundException;
import com.avaliacao.stoom.exceptions.AddressNotFoundOnGoogleAPIException;
import com.avaliacao.stoom.integration.GoogleAPIIntegration;
import com.avaliacao.stoom.integration.GoogleAPIModel;
import com.avaliacao.stoom.model.Address;
import com.avaliacao.stoom.model.AddressDTO;
import com.avaliacao.stoom.repository.AddressRepository;
import com.avaliacao.stoom.rest.AddressServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTests {

    @Mock
    AddressRepository addressRepository;

    @Mock
    GoogleAPIIntegration googleAPIIntegration;

    @InjectMocks
    AddressServiceImpl addressService;

    AddressDTO addressDTO;

    @Before
    public void init() {
        this.addressDTO = AddressDTO.builder()
                .id(null)
                .streetName("CASA DO ATOR")
                .number("294")
                .complement("")
                .neighbourhood("VILA OLIMPIA")
                .city("São Paulo")
                .state("SP")
                .country("Brazil")
                .zipcode("04546001")
                .latitude(-23.5997629)
                .longitude(-46.6764523)
                .build();
    }


    @Test
    public void getAddressByIdWithValidId() throws AddressNotFoundException {
        this.addressDTO.setId(1L);
        Address address = AddressDTO.toEntity(this.addressDTO);

        Mockito.when(this.addressRepository.findById(1L)).thenReturn(Optional.of(address));

        AddressDTO returnTest = this.addressService.getAddressById(1L);

        Assert.assertNotNull(returnTest);
        Assert.assertEquals(returnTest, this.addressDTO);
    }

    @Test(expected = AddressNotFoundException.class)
    public void getAddressByIdWithInvalidId() throws AddressNotFoundException {
        this.addressService.getAddressById(2L);
    }

    @Test
    public void deleteAddress() throws AddressNotFoundException {
        this.addressDTO.setId(1L);
        Address address = AddressDTO.toEntity(this.addressDTO);
        Mockito.when(this.addressRepository.findById(1L)).thenReturn(Optional.of(address));
        this.addressService.deleteAddressById(1L);
    }

    @Test(expected = AddressNotFoundException.class)
    public void deleteAddressWithInvalidID() throws AddressNotFoundException {
        this.addressService.deleteAddressById(1L);
    }

}
