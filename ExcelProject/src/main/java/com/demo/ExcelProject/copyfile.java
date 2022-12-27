package com.demo.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;

public class copyfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Path sourceDirectory = Paths.get("C:/Users/Attune/Desktop/MDIndia Paid Report.xls");
//        Path targetDirectory = Paths.get("C:/Users/Attune/Desktop/Nithya/MDIndia Paid Reportcopy.xls");

        
        
        //copy source to target using Files Class
//        Files.copy(sourceDirectory, targetDirectory);
		
		
		
		File sourceFile = new File("C:\\Users\\Attune\\Desktop\\MDIndia Paid Reportdemo.xls");
				String file1=sourceFile.getName();
		System.out.println(file1);
		String fileNameWithOutExt = FilenameUtils.removeExtension(file1);
		System.out.println(fileNameWithOutExt);
		System.out.println(sourceFile.getParent());
		File destinationFile = new File(sourceFile.getParent()+"\\"+"newfile"+fileNameWithOutExt+".xlsx");

		
		FileInputStream fileInputStream = new FileInputStream(sourceFile);
		FileOutputStream fileOutputStream = new FileOutputStream(
		                destinationFile);

		int bufferSize;
		byte[] bufffer = new byte[512];
		while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
		    fileOutputStream.write(bufffer, 0, bufferSize);
		}
		fileInputStream.close();
		fileOutputStream.close();

	}

}
