package com.demo.ExcelProject;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Urlfilereading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello  world";
	       
	      // Before Trim() method
	      System.out.println("Before Trim() - ");
	      System.out.println("String - "+s1);
	      System.out.println("Length - "+s1.length());
	       
	      // applying trim() method on string s1
	      s1=s1.trim();
	       
	      // After Trim() method
	      System.out.println("\nAfter Trim() - ");
	      System.out.println("String - "+s1);
	      System.out.println("Length - "+s1.length());
		
		try 
		{
		BufferedInputStream inputStream = new BufferedInputStream(new URL("https://www.sample-videos.com/pdf/Sample-pdf-5mb.pdf").openStream());
				  FileOutputStream fileOS = new FileOutputStream("E:\\Vid\\"+"Claim"+"_request.pdf");
				    byte data[] = new byte[1024];
				    int byteContent;
				    while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
				        fileOS.write(data, 0, byteContent);
				    }
				} catch (IOException e) {
				    // handles IO exceptions
				}
	}
}
