package com.parisiproduct.swimteam.meet;

import lombok.Builder;

@Builder
public class MeetHost {
    String name;
    @Builder.Default
    Address address = Address.builder().build();
    String phoneNumber;
}
