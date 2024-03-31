package com.parisiproduct.swimteam.meet;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Team {
    String teamCode;
    String name;
    @Builder.Default
    Address address = Address.builder().build();

}
