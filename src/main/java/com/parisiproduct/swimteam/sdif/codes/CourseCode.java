package com.parisiproduct.swimteam.sdif.codes;

public enum CourseCode {
    SHORT_METERS("S"),
    SHORT_YARDS("Y"),
    LONG_METERS("L"),
    DISQUALIFIED("X");

    final String code;
    CourseCode(String code){
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
