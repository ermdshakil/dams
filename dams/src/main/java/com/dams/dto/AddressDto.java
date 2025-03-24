package com.dams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
	
    private Long addressId;
    private String houseNo;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private Long userId; // Storing only userId instead of the full User object
}
