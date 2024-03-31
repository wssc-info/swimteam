package com.parisiproduct.swimteam.sdif.codes;

import lombok.Getter;

@Getter
public enum Stroke {
    Freestyle(1,"Freestyle"),
    Backstroke(2,"Backstroke"),
    Breaststroke(3,"Breaststroke"),
    Butterfly(4,"Butterfly"),
    Individual_Medley(5,"Individual Medley"),
    Freestyle_Relay(6,"Freestyle Relay"),
    Medley_Relay(7,"Medley Relay");

    final String name;
    final int code;
    Stroke(int code, String name) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return Integer.toString(code);
    }
}
