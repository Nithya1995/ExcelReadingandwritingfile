package com.demo.ExcelProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class conversion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		xls conversion
		String inpFn = "C:\\Users\\Attune\\Desktop\\Book1.xls"; 
		FileInputStream inputStream = null;
		inputStream = new FileInputStream(inpFn);
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		for (Row row : sheet) // iteration over row using for each loop
		{
			for (Cell cell : row) // iteration over cell using for each
									// loop
			{
				switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
				case Cell.CELL_TYPE_NUMERIC: // field that represents
												// numeric cell type
					// getting the value of the cell as a number
					System.out.print(cell.getNumericCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_STRING: // field that represents
											// string cell type
					// getting the value of the cell as a string
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;
				}
					}
			System.out.println();
			
			
		
		}
		
		try {
			DataFormatter dataFormatter = new DataFormatter();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null && !isRowEmpty(row)) {
					List<String> reason = new ArrayList<String>();

					// CLAIM NO
					if (row.getCell(0) != null) {
						String clNumber = dataFormatter.formatCellValue(row.getCell(0)).trim();
						if (clNumber != null && !clNumber.isEmpty()) {
						} else {
							reason.add("CCNNumber is missing");
						}
					} else {
						reason.add("CCNNumber is missing");
					}


					// PATIENT NAME
					if (row.getCell(6) != null) {
						String patientName = dataFormatter.formatCellValue(row.getCell(6)).trim();
						if (patientName != null && !patientName.isEmpty()) {
						} else {
							reason.add("Patient Name is missing");
						}
					} else {
						reason.add("Patient Name is missing");
					}

					// Settled Amount
					if (row.getCell(7) != null) {
						String settledAmount = dataFormatter.formatCellValue(row.getCell(7)).trim();
						if (settledAmount != null && !settledAmount.isEmpty()) {
						} else {
							reason.add("Settled Amount is missing");
						}
					} else {
						reason.add("Settled Amount is missing");
					}

					// TDS AMOUNT
					if (row.getCell(8) != null) {
						String tdsAmount = dataFormatter.formatCellValue(row.getCell(8)).trim();
						if (tdsAmount != null && !tdsAmount.isEmpty()) {
						} else {
							reason.add("TDS Amount is missing");
						}
					} else {
						reason.add("TDS Amountis missing");
					}

					// Admission Date
					if (row.getCell(10) != null) {
						String doa = dataFormatter.formatCellValue(row.getCell(10)).trim();
						if (doa != null && !doa.isEmpty()) {
												} else {
							reason.add("Admission Date is missing");
						}
					} else {
						reason.add("Admission Date is missing");
					}

					// Discharge Date
					if (row.getCell(11) != null) {
						String dod = dataFormatter.formatCellValue(row.getCell(11)).trim();
						if (dod != null && !dod.isEmpty()) {
						
						} else {
							reason.add("Discharge Date is missing");
						}
					} else {
						reason.add("Discharge Date is missing");
					}

					// Cheque No
					if (row.getCell(18) != null) {
						String utrNumber = dataFormatter.formatCellValue(row.getCell(18)).trim();
						if (utrNumber != null && !utrNumber.isEmpty()) {
						} else {
							reason.add("Cheque No is missing");
						}
					} else {
						reason.add("Cheque No is missing");
					}

					// cheque date
					try {
						if (row.getCell(19) != null) {
							String transactionDateString = dataFormatter.formatCellValue(row.getCell(19)).trim();
						
							if (transactionDateString != null && !transactionDateString.isEmpty()) {
								try {
									if (transactionDateString.contains("/")) {
										transactionDateString = transactionDateString.replace("/", "-");
									}
					
								} catch (Exception e) {
									e.printStackTrace();
													}
							} else {
								reason.add("cheque date is missing");
							}
						} else {
							reason.add("cheque date is missing");
						}
					} catch (Exception e) {
						e.printStackTrace();

					}
					System.out.println(reason);
				}
				
			}
		}
		
		catch (Exception e) {
		}

		}	
	private static boolean isRowEmpty(Row row) {
		// TODO Auto-generated method stub
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

}
