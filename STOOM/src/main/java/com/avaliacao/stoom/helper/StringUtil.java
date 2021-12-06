package com.avaliacao.stoom.helper;

import com.avaliacao.stoom.model.Address;
import com.avaliacao.stoom.model.AddressDTO;

public class StringUtil {

    public static String formatAddressParam(AddressDTO address){
        return address.getNumber()
                .concat("+")
                .concat(address.getStreetName().replaceAll("\\s", "+"))
                .concat(",+")
                .concat(address.getNeighbourhood().replaceAll("\\s", "+"))
                .concat(",+")
                .concat(address.getState());
    }
}
