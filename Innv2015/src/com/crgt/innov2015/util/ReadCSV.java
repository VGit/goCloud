package com.crgt.innov2015.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.crgt.innov2015.model.CSPVO;

public class ReadCSV {
	
	public static void main(String[] args){
		ReadCSV csv = new ReadCSV();
		List<CSPVO> list = csv.run();
		for(CSPVO c: list){
			System.out.println(c.getType());
			System.out.println(c.getAwsValue());
			System.out.println(c.getAzureValue());
			System.out.println(c.getCfValue());
		}
	}
	
	 public List<CSPVO> run() {
		 
		 List<CSPVO> cspList = new ArrayList<CSPVO>();	
		 String csvFile = "datacsp.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			
			try {
				br = new BufferedReader(new FileReader(new File(csvFile)));
				while ((line = br.readLine()) != null) {
					CSPVO csp = new CSPVO();		 
					// use comma as separator
					String[] values = line.split(cvsSplitBy);
					csp.setType(values[0]);
					csp.setAwsValue(Integer.valueOf(values[1]));
					csp.setCfValue(Integer.valueOf(values[2]));
					csp.setAzureValue(Integer.valueOf(values[3]));
					cspList.add(csp);
				}
	 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
				return cspList;
	  }
		 

}
