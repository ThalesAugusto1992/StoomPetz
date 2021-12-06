package com.avaliacao.stoom.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressComponents {

    private String long_name;

    private String short_name;

    private String[] types;
}