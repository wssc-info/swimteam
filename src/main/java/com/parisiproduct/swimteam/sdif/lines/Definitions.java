package com.parisiproduct.swimteam.sdif.lines;

import com.parisiproduct.swimteam.meet.IndividualEntry;
import com.parisiproduct.swimteam.meet.Meet;
import com.parisiproduct.swimteam.meet.Team;

public class Definitions {
    /*
         1/2 M1* CONST "A0"
         3/1 M2* CODE ORG Code 001, table checked
         4/8 ALPHA SDIF version number (same format as the version number from the title page)
         12/2 M1* CODE FILE Code 003, table checked
         14/30 future use
         44/20 * ALPHA software name
         64/10 * ALPHA software version
         74/20 M1* ALPHA contact name (person supplying or sending data)
         94/12 M1* PHONE contact phone (area code and phone number of contact name in 74/20)
         106/8 M1* DATE file creation or update
         114/42 future use
         156/2 ALPHA submitted by LSC - for Top 16
         158/3 future use

     */
    public static LineDefinition A0 = LineDefinition.builder()
            .lineType(LineType.FILE_DESCRIPTION)
            .objectBaseType(Meet.class)
            .segment(new LineSegment(1,2,"A0"))
            .segment(new LineSegment(3,1,"1"))
            .segment(new LineSegment(4,8,"V3"))
            .segment(new LineSegment(12,2,"01"))
            .segment(new LineSegment(14,30,""))
            .segment(new LineSegment(44,20,"Parisi Product"))
            .segment(new LineSegment(64,10,"0.1"))
            .segment(new LineSegment(74,20,"${contactName}"))
            .segment(new LineSegment(94,12,"${contactPhone}"))
            .segment(new LineSegment(106,8,"${dataDate}"))
            .segment(new LineSegment(114,42,""))
            .segment(new LineSegment(156,2,""))
            .segment(new LineSegment(158,3,""))
            .build();

    /*
     1/2 M1 CONST "B1"
     3/1 M2 CODE ORG Code 001, table checked
     4/8 future use
     12/30 M1 ALPHA meet name
     42/22 ALPHA meet address line one
     64/22 ALPHA meet address line two
     86/20 M2 ALPHA meet city
     106/2 M2 USPS meet state
     108/10 ALPHA Postal Code, meet zip or foreign code
     118/3 CODE COUNTRY Code 004, table checked
     121/1 M2 CODE MEET Code 005, table checked
     122/8 M1 DATE meet start
     130/8 M2 DATE meet end
     138/4 INT altitude of pool in feet above sea level
     142/8 future use
     150/1 CODE COURSE Code 013, table checked, default course set up in exporting software
     151/10 future use
     */
    public static LineDefinition B1 = LineDefinition.builder()
            .lineType(LineType.MEET_RECORD)
            .objectBaseType(Meet.class)
            .segment(new LineSegment(1,2,"B1"))
            .segment(new LineSegment(3,1,"1"))
            .segment(new LineSegment(4,8,""))
            .segment(new LineSegment(12,30,"${name}"))
            .segment(new LineSegment(42,22,"${meetLocation.addressLine1}"))
            .segment(new LineSegment(64,22,"${meetLocation.addressLine2}"))
            .segment(new LineSegment(86,20,"${meetLocation.city}"))
            .segment(new LineSegment(106,2,"${meetLocation.state}"))
            .segment(new LineSegment(108,10,"${meetLocation.zip}"))
            .segment(new LineSegment(118,3,"${meetLocation.country}"))
            .segment(new LineSegment(121,1,"${meetCode}"))
            .segment(new LineSegment(122,8,"${start}"))
            .segment(new LineSegment(130,8,"${end}"))
            .segment(new LineSegment(138,4,"   0")) //altitude
            .segment(new LineSegment(142,8,"")) //future
            .segment(new LineSegment(150,1,"${courseCode}"))
            .segment(new LineSegment(151,10,"")) //future
            .build();

    /*
     1/2 M1 CONST "C1"
     3/1 M2 CODE ORG Code 001, table checked
     4/8 future use
     12/6 M1 CODE TEAM Code 006
     18/30 M1 ALPHA full team name
     48/16 ALPHA abbreviated team name
     64/22 ALPHA team address line one
     86/22 ALPHA team address line two
     108/20 ALPHA team city
     128/2 USPS team state
     130/10 ALPHA Postal Code, team zip or foreign code
     140/3 CODE COUNTRY Code 004, table checked
     143/1 CODE REGION Code 007, table checked
     144/6 future use
     150/1 ALPHA optional 5th char of team code
     151/10 future use
     */
    public static LineDefinition C1 = LineDefinition.builder()
            .lineType(LineType.TEAM_ID_RECORD)
            .objectBaseType(Team.class)
            .segment(new LineSegment(1,2,"C1"))
            .segment(new LineSegment(3,1,"1"))
            .segment(new LineSegment(4,8,""))
            .segment(new LineSegment(12,6,"${teamCode}"))
            .segment(new LineSegment(18,30,"${name}"))
            .segment(new LineSegment(48,16,""))
            .segment(new LineSegment(64,22,"${address.addressLine1}"))
            .segment(new LineSegment(86,22,"${address.addressLine2}"))
            .segment(new LineSegment(108,20,"${address.city}"))
            .segment(new LineSegment(128,2,"${address.state}"))
            .segment(new LineSegment(130,10,"${address.zip}"))
            .segment(new LineSegment(140,3,"${address.country}"))
            .segment(new LineSegment(143,1,""))//Region Code
            .segment(new LineSegment(144,6,"")) //future
            .segment(new LineSegment(151,1,"")) //optional 5th char for team code
            .segment(new LineSegment(151,10,"")) //future
            .build();
/*
 1/2 M1 CONST "D0"
 3/1 M2 CODE ORG Code 001, table checked
 4/8 future use
 12/28 M1 NAME swimmer name
 40/12 M2 ALPHA USS#
 52/1 CODE ATTACH Code 016, table checked
 53/3 CODE CITIZEN Code 009, table checked
 56/8 M2 DATE swimmer birth date
 64/2 ALPHA swimmer age or class (such as Jr or Sr)
 66/1 M1 CODE SEX Code 010, table checked
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
 146/15 future use
 */

    public static LineDefinition D0 = LineDefinition.builder()
            .lineType(LineType.INDIVIDUAL_EVENT_RECORD)
            .objectBaseType(IndividualEntry.class)
            .segment(new LineSegment(1,2,"D0"))
            .segment(new LineSegment(3,1,"1"))
            .segment(new LineSegment(4,8,""))
            .segment(new LineSegment(12,28,"${swimmer.name}"))
            .segment(new LineSegment(40,12,"${swimmer.ussNumber}"))
            .segment(new LineSegment(52,1,"${swimmer.attachCode}"))
            .segment(new LineSegment(53,3,"${swimmer.citizenCode}"))
            .segment(new LineSegment(56,8,"${swimmer.birthDate}"))
            .segment(new LineSegment(64,2,"${swimmer.age}"))
            .segment(new LineSegment(66,1,"${swimmer.sex}"))
            .segment(new LineSegment(67,1,"${eventSex}"))
            .segment(new LineSegment(68,4,"${distance}", true))
            .segment(new LineSegment(72,1,"${stroke}"))
            .segment(new LineSegment(73,4,"")) //future
            .segment(new LineSegment(77,4,"${lowerAgeLimit}${upperAgeLimit}"))
            .segment(new LineSegment(81,8,"${dateOfSwim}"))
            .segment(new LineSegment(89,8,"${seedTime}"))
            .segment(new LineSegment(97,1,"${courseCode}"))
            .build();

}
