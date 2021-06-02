package com.github.agdula.logback.issue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliteratorUnknownSize;

public class FileProcessorFixedTest {


    @Test
    void shouldCorrectlyAggregateMarkers() {

        // given:
        var fileProcessor = new FileProcessorFixed();

        // when:
        fileProcessor.processDir();

        // then:
        Assertions.assertEquals(0, aggregatedMarkers(fileProcessor.dir));

        Assertions.assertEquals(2, aggregatedMarkers(fileProcessor.file));

        Assertions.assertEquals(2, aggregatedMarkers(fileProcessor.line));

    }


    private int aggregatedMarkers(Marker marker) {
        return StreamSupport.stream(spliteratorUnknownSize(marker.iterator(), 0), false)
                .collect(Collectors.toList())
                .size();
    }

}