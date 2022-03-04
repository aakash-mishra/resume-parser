import java.io.*;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingText {

   public static void main(String args[]) throws IOException {
      final long startTime = System.nanoTime();

      File txtfile = new File("skills.txt");

      File allfiles = new File(".");
      File[] all_resumes = allfiles.listFiles();
      for (File curfile : all_resumes) {
         // Print the names of files and directories
         if(curfile.getName().endsWith("pdf"))
         {
            List<String> skillset = new LinkedList<>();
            System.out.println(curfile.getName());
            PDDocument document = PDDocument.load(curfile);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            String txt= pdfStripper.getText(document);            
            BufferedReader br = new BufferedReader(new FileReader(txtfile));
            String st;
            while ((st = br.readLine()) != null)
            {
               if(txt.contains(st))
               {
                  skillset.add(st);
               }

            }
            //System.out.println(skillset);
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