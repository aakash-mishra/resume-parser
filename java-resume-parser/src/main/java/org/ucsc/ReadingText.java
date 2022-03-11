package org.ucsc;

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class ReadingText {

    public static void main(String args[]) throws IOException {
        final long startTime = System.nanoTime();
        String pathToStatic = "/Users/aakash/aakash/Winter2022/CSE210A/Project/resume-parser/static/";
        String skillsTxt = Files.readString(Paths.get(pathToStatic + "skills.txt"));
        String[] lines = skillsTxt.split(System.getProperty("line.separator"));
        File allFiles = new File(pathToStatic);
        File[] allResumes = allFiles.listFiles();

        for (File curfile : allResumes) {
            // Print the names of files and directories
            if(curfile.getName().endsWith("pdf")) {
                List<String> skillSet = new LinkedList<>();
                PDDocument document = PDDocument.load(curfile);
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String txt= pdfStripper.getText(document);
                for(String line : lines) {
                    if(txt.contains(line))
                        skillSet.add(line);
                }
                // System.out.println("[Java]Skills found in the resume file " 
                // + curfile.getName() + ": " +  skillSet.toString());
                document.close();
            }
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println("[Java] Total execution time: " + duration/1000000000.0);
    }
}