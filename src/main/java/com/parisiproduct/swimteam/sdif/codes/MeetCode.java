package com.parisiproduct.swimteam.sdif.codes;

public enum MeetCode {
    INVITATIONAL("1","Invitational"),
    REGIONAL("2","REGIONAL"),
    LSC_CHAMPIONSHIP ("3","LSC CHAMPIONSHIP"),
    ZONE ("4","ZONE "),
    ZONE_CHAMPIONSHIP ("5","ZONE CHAMPIONSHIP "),
    NATIONAL_CHAMPIONSHIP ("6","NATIONAL CHAMPIONSHIP "),
    JUNIORS("7", "Juniors"),
    SENIORS("8","Seniors"),
    DUAL("9","DUAL"),
    TIME_TRIALS("0","TIME TRIALS"),
    INTERNATIONAL("A", "International"),
    OPEN("B","OPEN"),
    LEAGUE("C","LEAGUE");

    private final String code;

    MeetCode(String code, String name) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
