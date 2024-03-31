package com.parisiproduct.swimteam.meet;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class Address {
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zip;
    String country;

}