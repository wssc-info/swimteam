package com.parisiproduct.swimteam.sdif.lines;

import javax.sound.sampled.Line;

public enum LineType {
    FILE_DESCRIPTION("A0"),
    MEET_RECORD("B1"),
    MEET_HOST_RECORD("B2"),
    TEAM_ID_RECORD("C1"),
    TEAM_ENTRY_RECORD("C2"),
    INDIVIDUAL_EVENT_RECORD("D0"),
    INDIVIDUAL_INFO_RECORD("D3"), //Info rec one per swimmer, a swimmer with multiple D0 records will have one D3 record following his/her first D0 record, contains new USS# and prefered first name.
    SPLIT_RECORD_D0("G0"), //G0-Split rec one or more per "D0", contains data on athlete name, ID, event ID, split time and interval.
    RELAY_EVENT_RECORD("E0"), //E0-Relay event rec one per relay entry, contains data on relay event, team, times, places and lanes.
    RELAY_NAME_RECORD("F0"), // F0-Relay name rec four or more per "E0", contains data on the athlete name, ID, time, split, and session.
    FILE_TERMINATOR_RECORD("Z0") //Z0-File terminator rec
    ;


    final String prefix;

    LineType(String prefix){
        this.prefix = prefix;
    }
}
