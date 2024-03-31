package com.parisiproduct.swimteam.meet;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

/*
 12/28 M1 NAME swimmer name
 40/12 M2 ALPHA USS#
 52/1 CODE ATTACH Code 016, table checked
 53/3 CODE CITIZEN Code 009, table checked
 56/8 M2 DATE swimmer birth date
 64/2 ALPHA swimmer age or class (such as Jr or Sr)
 66/1 M1 CODE SEX Code 010, table checked
 */
@Builder
@Data
public class Swimmer {
    String name;
    String ussNumber;
    @Builder.Default
    String attachCode = "A";
    @Builder.Default
    String citizenCode = "USA";
    Instant birthDate;
    String age;
    String sex;
}
