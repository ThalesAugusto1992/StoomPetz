package com.avaliacao.stoom.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geometry {

    private Bounds bounds;

    private Locations location;

    private String location_type;

    private Viewport viewport;
}