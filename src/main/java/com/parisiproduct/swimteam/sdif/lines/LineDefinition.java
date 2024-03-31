package com.parisiproduct.swimteam.sdif.lines;

import com.parisiproduct.swimteam.sdif.FileGenerator;
import com.parisiproduct.swimteam.sdif.lines.LineType;
import lombok.Builder;
import lombok.Singular;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookup;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@Slf4j
public class LineDefinition {
    LineType lineType;
    Class<?> objectBaseType;
    @Singular List<LineSegment> segments;

    public StringBuilder getLine(Object baseObject){
        if (!objectBaseType.isInstance(baseObject)) {
          throw new RuntimeException("Invalid Base Object For Line %s, Expected %s, Got %s".formatted(lineType.prefix, objectBaseType, baseObject.getClass()));
        }
        StringSubstitutor sub = new StringSubstitutor(new PropertyLookup(baseObject));
        StringBuilder stringBuilder = new StringBuilder();
        for (LineSegment segment: segments) {
            if(segment.getStart() + 1 != stringBuilder.length()) {
                log.error("Segment length is off... {} wanted {}", stringBuilder.length(), segment.start);
            }
            String formatedValue = sub.replace(segment.getTemplate());
            if (segment.rightJustify) {
                formatedValue = StringUtils.leftPad(formatedValue, segment.getLength());
            } else {
                formatedValue = StringUtils.rightPad(formatedValue, segment.getLength());
            }
            if (formatedValue.length() > segment.getLength()) {
                formatedValue = StringUtils.truncate(formatedValue, segment.getLength());
            }
            stringBuilder.append(formatedValue);
        }
        stringBuilder.append("\n");

        return stringBuilder;
    }


    static class PropertyLookup implements StringLookup {
        Object object;

        public PropertyLookup(Object object) {
            this.object = object;
        }

        @Override
        public String lookup(String s) {
            String[] parts = s.split("\\|");
            String returnValue = "";
            try {

                Object property = PropertyUtils.getProperty(object, parts[0]);
                if (property instanceof Instant) {
                    String format = "yyyyMMdd";
                    if (parts.length > 1) {
                        format = parts[1];
                    }
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault());
                    property = formatter.format((Instant) property);
                }
                if (property instanceof Duration){
                    property = DurationFormatUtils.formatDuration(((Duration) property).toMillis(), "mm:ss.SS", true);
                }
                if (property != null) {
                    returnValue = property.toString();
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            return returnValue;
        }
    }
}
