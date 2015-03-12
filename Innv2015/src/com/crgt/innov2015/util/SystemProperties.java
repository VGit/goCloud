package com.crgt.innov2015.util;

import java.util.HashMap;

public class SystemProperties extends HashMap<String, String> {

	private static final long serialVersionUID = 7285218822927219410L;

	@Override
    public String get(Object name) {
        return System.getProperty(name != null ? name.toString() : null);
    }
}