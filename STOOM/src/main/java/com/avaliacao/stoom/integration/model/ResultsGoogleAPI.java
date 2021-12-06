package com.avaliacao.stoom.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultsGoogleAPI {

    private List<AddressComponents> address_components;

    private String formatted_address;

    private Geometry geometry;

    private String place_id;

    private String[] types;
}