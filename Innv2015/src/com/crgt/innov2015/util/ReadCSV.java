package com.crgt.innov2015.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.crgt.innov2015.model.CSPVO;

public class ReadCSV {

	public static void main(String[] args) {
		ReadCSV csv = new ReadCSV();
		csv.run();
	}

	public List<CSPVO> run() {

//		String csvFile = "com/crgt/innov2015/util/datacsp.csv";
		String csvFile2 = "datacsp.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<CSPVO> cspList = new ArrayList<CSPVO>();
		try {
			System.out.println(ReadCSV.class.getClass());
			System.out.println(this.getClass().getResource(csvFile2));
			InputStream in = this.getClass().getResourceAsStream("datacsp.csv");
			Reader fr = new InputStreamReader(in, "utf-8");

			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				CSPVO csp = new CSPVO();
				// use comma as separator
				String[] values = line.split(cvsSplitBy);
				System.out.println(values);
				csp.setType(values[0]);
				csp.setAwsValue(values[3]);
				csp.setCfValue(values[1]);
				csp.setAzureValue(values[2]);
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
