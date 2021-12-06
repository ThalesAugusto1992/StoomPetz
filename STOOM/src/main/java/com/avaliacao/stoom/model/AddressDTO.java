package com.avaliacao.stoom.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {

    private Long id;

    @NotBlank(message = "Street Name is required")
    private String streetName;

    @NotBlank(message = "Number is required")
    private String number;

    private String complement;

    @NotBlank(message = "Neighbourhood is required")
    private String neighbourhood;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Zipcode is required")
    private String zipcode;

    private Double latitude;

    private Double longitude;

    public static AddressDTO fromEntity(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .streetName(address.getStreetName())
                .number(address.getNumber())
                .complement(address.getComplement())
                .neighbourhood(address.getNeighbourhood())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipcode(address.getZipcode())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .build();
    }

    public static Address toEntity(AddressDTO address) {
        return Address.builder()
                .id(address.getId())
                .streetName(address.getStreetName())
                .number(address.getNumber())
                .complement(address.getComplement())
                .neighbourhood(address.getNeighbourhood())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipcode(address.getZipcode())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .build();
    }
}
