package com.github.agdula.logback.issue;

public class Main {

    public static void main(String[] args) {

        new FileProcessor().processDir();
        // output:
        // processing dir | directory=Some Directory
        // processing file | directory=Some Directory, file=Some Document
        // processing line WHAT ??? | line=42
        // processing line OK | line=42, directory=Some Directory, file=Some Document

        new FileProcessorFixed().processDir();

        // output:
        // processing dir | directory=Some Directory
        // processing file | directory=Some Directory, file=Some Document
        // processing line | directory=Some Directory, file=Some Document, line=42
    }

}
