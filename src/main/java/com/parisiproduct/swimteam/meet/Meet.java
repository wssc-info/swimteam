package com.parisiproduct.swimteam.meet;

import com.parisiproduct.swimteam.sdif.codes.CourseCode;
import com.parisiproduct.swimteam.sdif.codes.MeetCode;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class Meet {
    String contactName;
    String contactPhone;
    Instant dataDate;

    String name;

    @Builder.Default
    Address meetLocation = Address.builder().build();

    MeetCode meetCode;

    Instant start;
    Instant end;

    CourseCode courseCode;

    MeetHost host;

    Team team;

    List<IndividualEntry> individualEntries;

}
