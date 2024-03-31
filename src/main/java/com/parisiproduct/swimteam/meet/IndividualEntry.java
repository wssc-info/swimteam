package com.parisiproduct.swimteam.meet;

import com.parisiproduct.swimteam.sdif.codes.CourseCode;
import com.parisiproduct.swimteam.sdif.codes.Stroke;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;

@Builder
@Data
public class IndividualEntry {
    Swimmer swimmer;
    String eventSex;
    int distance;
    Stroke stroke;
    @Builder.Default
    String lowerAgeLimit = "UN";
    @Builder.Default
    String upperAgeLimit = "OV";
    Instant dateOfSwim;
    Duration seedTime;
    CourseCode courseCode;


/*
67/1 M1# CODE EVENT SEX Code 011, table checked
 68/4 M1# INT event distance
 72/1 M1# CODE STROKE Code 012, table checked
 73/4 future use
 77/4 M1# CODE EVENT AGE Code 025, table checked
 81/8 M2 DATE date of swim
 89/8 TIME seed time
 97/1 * CODE COURSE Code 013, table checked
 98/8 TIME prelim time
 106/1 * CODE COURSE Code 013, table checked
 107/8 TIME swim-off time
 115/1 * CODE COURSE Code 013, table checked
 116/8 TIME finals time
 124/1 * CODE COURSE Code 013, table checked
 125/2 INT prelim heat number
 127/2 INT prelim lane number
 129/2 INT finals heat number
 131/2 INT finals lane number
 133/3 ** INT prelim place ranking
 136/3 ** INT finals place ranking
 139/4 ** DEC points scored from finals
 143/2 CODE EVENT TIME CLASS Code 014, table checked
 145/1 ALPHA flight status of swimmer (subdivision of Time Standard)
 */
}
