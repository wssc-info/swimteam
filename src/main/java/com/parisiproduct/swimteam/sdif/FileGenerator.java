package com.parisiproduct.swimteam.sdif;

import com.parisiproduct.swimteam.meet.IndividualEntry;
import com.parisiproduct.swimteam.meet.Meet;
import com.parisiproduct.swimteam.sdif.lines.Definitions;

public class FileGenerator {

//    private static String A0 = "A01V3      01Meet Entries                  Parisi Products     1.0       ${contactName|20}${contactPhone|12}${dataDate|8} \n";


    public StringBuilder generateEntries(Meet meet) {
        StringBuilder output = new StringBuilder();

        output.append(Definitions.A0.getLine(meet));
        output.append(Definitions.B1.getLine(meet));
        output.append(Definitions.C1.getLine(meet.getTeam()));

        for (IndividualEntry individualEntry: meet.getIndividualEntries()){
            output.append(Definitions.D0.getLine(individualEntry));
        }

        return output;
    }
}
