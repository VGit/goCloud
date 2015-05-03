package com.crgt.innov2015.util;

import java.util.List;

import com.crgt.innov2015.model.CSPVO;

/**
 * Helper class which gives data points for different cloud vendors.
 * @author mvattipulusu
 *
 */
public class CspDataList {

	public static List<CSPVO> getCspData(){
		ReadCSV csv = new ReadCSV();
		List<CSPVO> list = csv.run();
		return list;
	}

}
