package com.demo.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class jsonconvertor {

	private static final String NAME = "C:/Users/Attune/Desktop/json.xlsx";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String request = null,vid = null;
		try {
		
			
			FileInputStream file = new FileInputStream(new File(NAME));
		Workbook workbook = WorkbookFactory.create(file);

		Sheet bulkRegistrationSheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = bulkRegistrationSheet.rowIterator();
		//List<ErrorInfoVO> listOfErrors = new ArrayList<ErrorInfoVO>();
		while (rowIterator.hasNext()) {
		// ignore header row
		Row currentRow = rowIterator.next();


		if(currentRow.getLastCellNum() <= 0) {
		continue;
		}
		if(currentRow.getRowNum() ==0 ) {
		continue;
		}
		//int noOfCell = currentRow.getPhysicalNumberOfCells();
		int noOfCell = currentRow.getLastCellNum();
		for(int i=0;i<=noOfCell;i++) {
		Cell cell = currentRow.getCell(i);
		//String cellName  = cell.getRichStringCellValue().getString();
		//Long orgId=userData.getOrganizationId();

		if(i > 0 && cell==null) {
		continue;
		}

		if (i == 0) {

		Long sNo = (long) cell.getNumericCellValue();
		if( sNo!=null) {
		vid=sNo.toString();
		}

		}else if (i == 1) {
		String orgName = cell.getStringCellValue();
		CellType cellType = cell.getCellTypeEnum();
		if(orgName!=null) {
		request=orgName;

		}

		FileWriter fw=new FileWriter("E:\\Vid\\"+vid+"_request.json");    
		          fw.write(request);    
		          fw.close();  
		          System.out.print("Comleted");
		}


		}

		}}
		catch (Exception exception) {
		// update thread status to failure
			System.out.println(exception);
		}


		

	}

}
