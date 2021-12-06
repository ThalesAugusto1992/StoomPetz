package com.avaliacao.stoom.integration;

import com.avaliacao.stoom.helper.StringUtil;
import com.avaliacao.stoom.model.Address;
import com.avaliacao.stoom.model.AddressDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoogleAPIIntegration {

    @Value(value = "${google-api.domain}")
    private String url;

    @Value(value = "${google-api.key}")
    private String key;


    public GoogleAPIModel getLongLatFromAddress(AddressDTO address) {
        String urlFormatted = this.formatUrl(address);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(urlFormatted, GoogleAPIModel.class).getBody();
    }


    private String formatUrl(AddressDTO address) {
        return this.url.replace("{googleKey}", this.key).replace("{addressFormatted}", StringUtil.formatAddressParam(address));
    }
}
