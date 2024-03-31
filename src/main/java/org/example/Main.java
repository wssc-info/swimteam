package org.example;

import com.parisiproduct.swimteam.meet.*;
import com.parisiproduct.swimteam.sdif.FileGenerator;
import com.parisiproduct.swimteam.sdif.codes.CourseCode;
import com.parisiproduct.swimteam.sdif.codes.MeetCode;
import com.parisiproduct.swimteam.sdif.codes.Stroke;
import com.parisiproduct.swimteam.sdif.lines.LineDefinition;
import com.parisiproduct.swimteam.sdif.lines.LineSegment;
import com.parisiproduct.swimteam.sdif.lines.LineType;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Slf4j
public class Main {

    public static final Address WSSC = Address.builder()
            .addressLine1("5533 Odana Road")
            .city("Madison")
            .state("WI")
            .zip("53719")
            .country("USA")
            .build();

    public static void main(String[] args) {
        log.info("in App");
        try {
            Meet meet = Meet.builder()
                    .contactName("Tony Parisi")
                    .contactPhone("6082395870")
                    .dataDate(Instant.now())
                    .meetCode(MeetCode.LEAGUE)
                    .start(Instant.now())
                    .end(Instant.now())
                    .name("West Side vs Parkcrest")
                    .courseCode(CourseCode.SHORT_METERS)
                    .host(MeetHost.builder()
                            .name("West Side Swim Club")
                            .phoneNumber("6081252486")
                            .address(WSSC)
                            .build())
                    .team(Team.builder()
                            .teamCode("MLWSSC")
                            .name("West Side Swim Club Dolphins")
                            .address(WSSC)
                            .build())

                    .individualEntries(List.of(
                            IndividualEntry.builder()
                                    .swimmer(Swimmer.builder()
                                            .name("Coleman, Henry")
                                            .ussNumber("080806HEN*CO")
                                            .age("16")
                                            .sex("M")
                                            .birthDate(
                                                    LocalDate.of(2006, 8, 8)
                                                            .atStartOfDay(ZoneId.systemDefault())
                                                            .toInstant())
                                            .build())
//                                    .dateOfSwim(Instant.now())
                                    .eventSex("M")
                                    .seedTime(Duration.ofMillis(65110))
                                    .courseCode(CourseCode.SHORT_METERS)
                                    .distance(100)
                                    .lowerAgeLimit("15")
                                    .upperAgeLimit("18")
                                    .stroke(Stroke.Freestyle)
                                    .build()
                    ))

                    .build();

            StringBuilder file = new FileGenerator().generateEntries(meet);
            System.out.println(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}