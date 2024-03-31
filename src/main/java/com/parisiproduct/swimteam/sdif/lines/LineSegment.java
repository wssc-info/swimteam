package com.parisiproduct.swimteam.sdif.lines;

import lombok.Builder;
import lombok.Data;

@Data
public class LineSegment {
    int start;
    int length;
    String template;
    boolean rightJustify=false;


    public LineSegment(int start, int length, String value) {
        this.start = start;
        this.length = length;
        this.template = value;
    }

    public LineSegment(int start, int length, String value, boolean rightJustify) {
        this(start, length, value);
        this.rightJustify = rightJustify;
    }
}
