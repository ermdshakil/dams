package com.dams.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {

    private Long addressId;
    private String houseNo;
    private String area;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Long userId;  // The ID of the associated user
    private Long patientId;  // The ID of the associated patient

}
