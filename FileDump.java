package edu.ics211.h00;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
/**
 * FileDump, this program will print out the contents of a file in 3 different ways.
 * @author Woojoon Hwang
 * @since 01/17/2018
 */

public class FileDump {

  private static final Charset UTF_8 = Charset.forName("UTF-8");


  /**
   * Attempts to print a word. Indicates whether printing was possible.
   * @param args the command line arguments
   * @exception FileNotFoundException and IOException
   */
  public static void main(String[] args) {
    // found this at
    // https://stackoverflow.com/questions/917163/convert-a-string-like-testing123-to-binary-in-java
    String pathname = args[0];
    File file = new File(pathname);
    BufferedReader in = null;
    //risky code goes here
    try {
      in = new BufferedReader(new FileReader(file));
      String line;
      System.out.println("Binary contents of " + file + ":");
      while ((line = in.readLine()) != null) {

        String result1 = "";
        char[] tchars = line.toCharArray();
        // the variable "i" loops from 0 to the length of characters
        for (int i = 0; i < tchars.length; i++) {
          result1 += Integer.toBinaryString(tchars[i]) + " ";
        }
        System.out.println(result1);

      }
    //this will be called when FileNotFoundException has occured
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    //this will be called when IOException has occured
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print("\n");
    
    //risky code goes here
    try {
      in = new BufferedReader(new FileReader(file));
      String line;
      System.out.println("Hexadecimal contents " + file + ":");
      while ((line = in.readLine()) != null) {

        String result2 = "";
        char[] tchars = line.toCharArray();
        // the variable "i" loops from 0 to the length of characters
        for (int i = 0; i < tchars.length; i++) {
          result2 += Integer.toHexString(tchars[i]) + " ";
        }

        System.out.println(result2);
      }
    //this will be called when FileNotFoundException has occured
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    //this will be called when IOException has occured
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.print("\n");
    //risky code goes here 
    try {
      in = new BufferedReader(new FileReader(file));
      String line;
      System.out.println("UTF-8 contents " + file + ":");
      while ((line = in.readLine()) != null) {
        byte[] bytes = line.getBytes(UTF_8);
        System.out.println(new String(bytes, UTF_8));
      }
    //this will be called when FileNotFoundException has occured
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    //this will be called when IOException has occured
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}