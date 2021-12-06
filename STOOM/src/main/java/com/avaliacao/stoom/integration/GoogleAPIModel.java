package com.avaliacao.stoom.integration;

import com.avaliacao.stoom.integration.model.ResultsGoogleAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoogleAPIModel {

    private List<ResultsGoogleAPI> results;

    private String status;
}

