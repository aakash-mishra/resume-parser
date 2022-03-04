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

      //File txtFile = new File("./static/skills.txt");
      String skillsTxt = Files.readString(Paths.get("./static/skills.txt"));
      String[] lines = skillsTxt.split(System.getProperty("line.separator"));

      //System.out.println(txtfile.getAbsolutePath());
      File allFiles = new File("./static/");
      //System.out.println(allfiles.getAbsolutePath());
      File[] allResumes = allFiles.listFiles();
      
      for (File curfile : allResumes) {
         // Print the names of files and directories
         if(curfile.getName().endsWith("pdf"))
         {
            List<String> skillSet = new LinkedList<>();
            //System.out.println(curfile.getName());
            PDDocument document = PDDocument.load(curfile);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            String txt= pdfStripper.getText(document);            
            //BufferedReader br = new BufferedReader(new FileReader(txtFile));
            //String st;
            for(String line: lines)
            {
               if(txt.contains(line))
               {
                  skillSet.add(line);
               }

            }
            //System.out.println(skillSet);
            document.close();

         }
      }
      // Print the string
      //System.out.println(st);
      //Loading an existing document
      //Closing the document
      //document.close();
      final long duration = System.nanoTime() - startTime;
      System.out.println(duration/1000000000.0);

   }
}