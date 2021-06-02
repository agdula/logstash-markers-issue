package com.github.agdula.logback.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import static net.logstash.logback.marker.Markers.aggregate;
import static net.logstash.logback.marker.Markers.append;

class FileProcessor {

    static Logger log = LoggerFactory.getLogger(FileProcessor.class);

    Marker dir;
    Marker file;
    Marker line;

    void processDir() {
        dir = append("directory", "Some Directory");
        log.info(dir, "processing dir");
        processFile();
    }

    private void processFile() {
        file = aggregate(dir, append("file", "Some Document"));
        log.info(file, "processing file");
        processLines();
    }

    private void processLines() {
        // this does not work as expected
        line = aggregate(file, append("line", "42")); // < ------------------------------ PROBLEM
        log.info(line, "processing line WHAT ???");
        //this works ok
        log.info(append("line", "42").and(file), "processing line OK");
    }

}
