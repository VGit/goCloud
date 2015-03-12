package com.crgt.innov2015.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Bunch of static methods for working with String objects
 */
public final class StringUtil {

	private static final String booleanTrue = "[1][ON][YES][TRUE]";
	public enum WildcardMatch { COULD_NOT_DETERMINE, EQUALS, CONTAINS, DOES_NOT_CONTAIN };
	
	public static enum ObjectStackValues {
		ModuleName("module_name"),
		ModuleEmbeddedErrorCode("module_embedded_error_code"),
		ErrorCode("error_code"),
		ErrorMessage("error_message"),
		ObjectId("object_id"), 
		ObjectType("object_type"),
		Object("object"),
		AuditContext("audit_context");
		
		private String value;
		
		private ObjectStackValues(String s) {
			value = s;
		}
		
		public String toString() {
			return value;
		}
	};
	
	private StringUtil() {
	}
	
	public static boolean isEmpty(String s) {
		boolean result = false;
		if (null == s || 0 == s.length()) {
			result = true;
		}
		return result;
	}

	public static String removeAllWildcardCharacters(String str) {
		String result = str;
		if (null != str) {
			result = removeEmbeddedString(result, "*", true);
			result = removeEmbeddedString(result, "_", true);
			result = removeEmbeddedString(result, "?", true);
		}
		return result;
	}

	public static String generateDelimitedList(String[] list, String delimiter) {
		StringBuffer sb = new StringBuffer();
		if (null != list && null != delimiter && 0 != list.length) {
			boolean isFirst = true;
			for (String str : list) {
				if (!isFirst) {
					sb.append(delimiter);
				} else {
					isFirst = false;
				}
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static String generateDelimitedList(List<String> list,
			String delimiter) {
		StringBuffer sb = new StringBuffer();
		if (null != list && null != delimiter) {
			boolean isFirst = true;
			for (String str : list) {
				if (!isFirst) {
					sb.append(delimiter);
				} else {
					isFirst = false;
				}
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static boolean isBlank(String inputStr) {
		boolean ret = true;
		if (null != inputStr) {
			int len = inputStr.length();
			for (int lll = 0; lll < len; lll++) {
				if (!Character.isWhitespace(inputStr.charAt(lll))) {
					ret = false;
					break;
				}
			}
		}
		return (ret);
	}

	public static boolean parseBooleanString(String s) {
		boolean result = false;
		if (null != s) {
			String search = "[" + s.toUpperCase() + "]";
			if (-1 != booleanTrue.indexOf(search)) {
				result = true;
			}
		}
		return result;
	}

	public static String removeEmbeddedString(String inStr,
			final String embeddedString, final boolean allOccurrences) {
		StringBuffer result = new StringBuffer(inStr);
		if ((!isEmpty(inStr)) && (!isEmpty(embeddedString))) {
			boolean done = false;
			int embedLength = embeddedString.length();
			while (!done) {
				int index = inStr.indexOf(embeddedString);
				if (-1 == index) {
					done = true;
				} else {
					result = result.delete(index, index + embedLength);
					inStr = result.toString();
					if (false == allOccurrences)
						done = true;
				}
			}
		}
		return result.toString();
	}

	public static String[] tokenizeToArray(String s, String token) {
		String[] result = null;
		List<String> tmp = tokenize(s, token);
		if (null != tmp && !tmp.isEmpty()) {
			result = (String[]) tmp.toArray(new String[0]);
		}
		return result;
	}

	public static List<String> tokenize(String s, String token) {
		List<String> result = null;
		if (!StringUtil.isEmpty(s) && !StringUtil.isEmpty(token)) {
			result = new ArrayList<String>();
			StringTokenizer t = new StringTokenizer(s, token);
			while (t.hasMoreTokens()) {
				String nextToken = t.nextToken();
				if (!StringUtil.isEmpty(nextToken)) {
					result.add(nextToken);
				}
			}
		}
		return result;
	}

	public static List<String> tokenizeAndTrim(String s, String token) {
		List<String> result = null;
		if (!StringUtil.isEmpty(s) && !StringUtil.isEmpty(token)) {
			result = new ArrayList<String>();
			StringTokenizer t = new StringTokenizer(s, token);
			while (t.hasMoreTokens()) {
				String nextToken = t.nextToken();
				if (!StringUtil.isEmpty(nextToken)) {
					result.add(trim(nextToken));
				}
			}
		}
		return result;
	}

	public static boolean stringValuesAreEqualWithTrim(String s1, String s2) {
		boolean result = false;
		if (null == s1 && null == s2) {
			result = true;
		} else if (null != s1 && null != s2) {
			if (s1.trim().equals(s2.trim())) {
				result = true;
			}
		}
		return result;
	}

	public static boolean stringValuesAreEqual(String s1, String s2) {
		boolean result = false;
		if (null == s1 && null == s2) {
			result = true;
		} else if (null != s1 && null != s2) {
			if (s1.equals(s2)) {
				result = true;
			}
		}
		return result;
	}

	public static boolean stringValuesAreEqualIgnoreCase(String s1, String s2) {
		boolean result = false;
		if (null == s1 && null == s2) {
			result = true;
		} else if (null != s1 && null != s2) {
			if (s1.toUpperCase().equals(s2.toUpperCase())) {
				result = true;
			}
		}
		return result;
	}

	protected static String replace(String s, String searchString,
			String replaceString) {
		String result = null;
		int index = s.indexOf(searchString);
		if (-1 == index) {
			result = s;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(s.substring(0, index));
			sb.append(replaceString);
			if (index + searchString.length() < s.length()) {
				sb.append(s.substring(index + searchString.length()));
			}
			result = sb.toString();
		}
		return result;
	}

	public static String replace(String s, String searchString,
			String replaceString, boolean replaceAllOccurences) {
		String result = null;
		if (!isEmpty(s) && !isEmpty(searchString)) {
			if (isEmpty(replaceString)) {
				replaceString = "";
			}
			if (!replaceAllOccurences) {
				result = replace(s, searchString, replaceString);
			} else {
				String compare = s;
				String last = replace(s, searchString, replaceString);
				while (!last.equals(compare)) {
					compare = last;
					last = replace(last, searchString, replaceString);
				}
				result = last;
			}
		}
		return result;
	}

	/**
	 * Converts the string to lowercase then initial caps the first letter.
	 */
	public static String initialUpperCase(String s, boolean trim) {
		String result = s;
		if (!StringUtil.isEmpty(s)) {
			StringBuffer sb = new StringBuffer(trim ? s.trim().toLowerCase()
					: s.toLowerCase());
			char c = sb.charAt(0);
			Character upperChar = Character.toUpperCase(c);
			sb.replace(0, 1, upperChar.toString());
			result = sb.toString();
		}
		return result;
	}

	public static String replaceNull(String s) {
		String result = s;
		if (null == s) {
			result = "";
		}
		return result;
	}

	public static String replaceNull(String s, String nullReplacementValue) {
		String result = s;
		if (null == s) {
			result = nullReplacementValue;
		}
		return result;
	}

	public static String trim(String s) {
		String result = s;
		if (null != result) {
			result = result.trim();
		}
		return result;
	}

	public static String trimAndUpper(String s) {
		String result = s;
		if (null != result) {
			result = result.trim();
			result = result.toUpperCase();
		}
		return result;
	}

	/**
	 * Trim string and remove spaces,tabs or newlines next to each other. ex:
	 * "  Jello   Gelatin" becomes "Jello Gelatin"
	 */
	public static String removeUnneededWhitespace(String s) {
		String result = null;
		if (null != s) {
			s = s.trim();
			StringBuffer sb = new StringBuffer();
			boolean lastCharIsWhitespace = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isWhitespace(c)) {
					if (!lastCharIsWhitespace) {
						lastCharIsWhitespace = true;
						sb.append(c);
					}
				} else {
					lastCharIsWhitespace = false;
					sb.append(c);
				}
			}
			result = sb.toString();
		}
		return result;
	}

	/**
	 * Note: will replace ${1}, ${2} with elements in list.  Offset starts with 1.
	 */
	public static String replaceConstants(final String value, List<String> constants) {
		String result = value;
		if (null != constants && !constants.isEmpty()) {
			int offset = 1;
			Map<String, String> map = new HashMap<String, String>();
			for (String str: constants) {
				String key = Integer.toString(offset);
				map.put(key, str);
				offset++;
			}
			result = replaceConstants(value, map);
		}
		return result;
	}
	
	/**
	 * Replaces all constant values with ones from the list. A constant value in
	 * the incoming value string should be wrappered in ${}. For example, if
	 * constants = Key Value --- ----- abc 123 def 555
	 * 
	 * And value="${abc} TESTING ${def} ${NOT_FOUND}", then the result will be:
	 * "123 TESTING 555 ${NOT_FOUND}"
	 * 
	 * @param value
	 *            string to replace constants in
	 * @param constants
	 *            mapping of key/values to replace if constants match
	 * @return string with constants replaced
	 */
	public static String replaceConstants(final String value, final Map<String, String> constants) {
		final String startDelim = "${";
		final String endDelim = "}";

		String result = value;
		if ((null != value) && (null != constants) && (constants.size() > 0)) {
			boolean parsedAll = false;
			String strToParse = value;
			StringBuffer sb = new StringBuffer();
			while (!parsedAll && (strToParse.length() > 0)) {
				int startIndex = strToParse.indexOf(startDelim);
				if (-1 != startIndex) {
					sb.append(strToParse.substring(0, startIndex));
					strToParse = strToParse.substring(startIndex
							+ startDelim.length());
					int endIndex = strToParse.indexOf(endDelim);
					if (-1 != endIndex) {
						String checkForConst = strToParse.substring(0, endIndex);
						if (constants.containsKey(checkForConst)) {
							sb.append(constants.get(checkForConst));
						} else {
							sb.append(startDelim);
							sb.append(checkForConst);
							sb.append(endDelim);
						}
						strToParse = strToParse.substring(endIndex + endDelim.length());
					} else {
						sb.append(startDelim);
						sb.append(strToParse);
						parsedAll = true;
					}
				} else {
					parsedAll = true;
					sb.append(strToParse);
				}
			}
			result = sb.toString();
		}
		return result;
	}

	public static String filterHtml(String value) {

		if (value == null)
			return (null);

		char content[] = new char[value.length()];
		value.getChars(0, value.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#39;");
				break;
			case '\r':
				result.append("&nbsp;");
				break;
			case '\n':
				result.append("&nbsp;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());

	}

	/**
	 * Gets string between delimiters. If start delim is null/not found, gets
	 * from the start of the string up to the end delim. If end delim is
	 * null/not found then gets from the start delim to the end of the string.
	 */
	public static String getStringBetweenDelimiters(String str,
			String startDelim, String endDelim) {
		String result = str;
		if (!StringUtil.isEmpty(startDelim) || !StringUtil.isEmpty(endDelim)) {
			if (!StringUtil.isEmpty(startDelim)
					&& !StringUtil.isEmpty(endDelim)) {
				// content content between tags
				int startOffset = str.indexOf(startDelim);
				if (-1 != startOffset) {
					str = str.substring(startOffset + startDelim.length());
					int endOffset = str.indexOf(endDelim);
					if (-1 == endOffset) {
						result = str;
					} else {
						result = str.substring(0, endOffset);
					}
				} else { // just get to end delim
					int endOffset = str.indexOf(endDelim);
					if (-1 != endOffset) {
						result = str.substring(0, endOffset);
					}
				}
			} else if (!StringUtil.isEmpty(startDelim)) {
				// only start delim specified
				int startOffset = str.indexOf(startDelim);
				if (-1 != startOffset) {
					result = str.substring(startOffset + startDelim.length());
				}
			} else if (!StringUtil.isEmpty(endDelim)) {
				int endOffset = str.indexOf(endDelim);
				if (-1 != endOffset) {
					result = str.substring(0, endOffset);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the string between delimiters. If a delimiter is specified, but not
	 * found in content, then null is returned.
	 */
	public static String getStringBetweenDelimitersBlankIfNotFound(String str,
			String startDelim, String endDelim) {
		String result = str;
		if (null != str
				&& (!StringUtil.isEmpty(startDelim) || !StringUtil
						.isEmpty(endDelim))) {
			if (!StringUtil.isEmpty(startDelim)
					&& !StringUtil.isEmpty(endDelim)) {
				// content content between tags
				int startOffset = str.indexOf(startDelim);
				if (-1 != startOffset) {
					str = str.substring(startOffset + startDelim.length());
					int endOffset = str.indexOf(endDelim);
					if (-1 == endOffset) {
						result = null;
					} else {
						result = str.substring(0, endOffset);
					}
				} else { // just get to end delim
					result = null;
				}
			} else if (!StringUtil.isEmpty(startDelim)) {
				// only start delim specified
				int startOffset = str.indexOf(startDelim);
				if (-1 != startOffset) {
					result = str.substring(startOffset + startDelim.length());
				} else {
					result = null;
				}
			} else if (!StringUtil.isEmpty(endDelim)) {
				int endOffset = str.indexOf(endDelim);
				if (-1 != endOffset) {
					result = str.substring(0, endOffset);
				} else {
					result = null;
				}
			}
		}
		return result;
	}

	public static double parseDoubleFromString(String s,
			double returnValueOnError) {
		double result = returnValueOnError;
		if (null != s) {
			try {
				result = Double.parseDouble(s);
			} catch (NumberFormatException e) {
				result = returnValueOnError;
			}
		}
		return result;
	}

	public static int parseIntegerFromString(String s, int returnValueOnError) {
		int result = returnValueOnError;
		if (null != s) {
			try {
				result = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				result = returnValueOnError;
			}
		}
		return result;
	}

	public static boolean isInteger(String text) {
		try {
			new Integer(text);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static String filterXMLnonSavvyChars(String text) {
		if (text == null)
			return null;
		StringBuffer str = new StringBuffer();

		int len =  text.length();
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			switch (ch) {
			case '\n':
			case '\r':
			case '\t':
				str.append(ch);
				break;
			case 0x97:
				str.append('-');
				break;
			case 0x19:
				str.append('\'');
				break;
			case 0x1C:
				str.append('\"');
				break;
			case 0x1D:
				str.append('\"');
				break;
			case 0x14:
				str.append('-');
				break;
			case '\u2013':
				str.append('-');
				break;
			case '\u2014':
				str.append('-');
				break;
			case '\u2015':
				str.append('-');
				break;
			case '\u2018':
				str.append('\'');
				break;
			case '\u2019':
				str.append('\'');
				break;
			case '\u201C':
				str.append('\"');
				break;
			case '\u201D':
				str.append('\"');
				break;
			default: {
				if (ch >= 0x20 && ch <= 0xFF)
					str.append(ch);
				else
					System.out.println("----- Bad XML Character ---> " + ch);
			}
			}
		}

		return (str.toString());
	}

	public static String getStackTrace(Throwable t) {
		String result = null;
		if (null != t) {
			try {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw, true);
				t.printStackTrace(pw);
				pw.flush();
				sw.flush();
				result = sw.toString();
			} catch (Exception e) {
			}
		}
		return result;
	}
	
	public static boolean isUserWildcard(String s, String wildcardString) {
		boolean result = false;
		if (!isBlank(s) && !isBlank(wildcardString)) {
			if (wildcardString.equals(s)) {
				result = true;
			}
			else { // check multiple ***s
				String newStr = removeEmbeddedString(s, wildcardString, true);
				if (isEmpty(newStr)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	
	public static WildcardMatch checkWildcard(String s, String wildcardString) {
		WildcardMatch result = null;
		if (!isEmpty(s) && !isEmpty(wildcardString)) {
			int likeIndex = s.indexOf(wildcardString);
			if (isUserWildcard(s, wildcardString)) {
				result = WildcardMatch.EQUALS;
			}
			else if (-1 == likeIndex) {
				result = WildcardMatch.DOES_NOT_CONTAIN;
			}
			else {
				result = WildcardMatch.CONTAINS;
			}
		}
		return result;
	}


	/*
	 * This methods passes in three strings; The third parameter is checked to see if it lies
	 * between param 1 and param 2
	 * It is assumed that the first two or three characters can be Strings only and the rest
	 * Could be ints.
	 */
  public static boolean stringRangeFinder(String targetStartRange, String targetEndRange, String mainStr){
	  
	  boolean stringWithInRange=false;
		//1. Match Characters;
		if(getCharsInString(mainStr).equalsIgnoreCase(getCharsInString(targetStartRange)) &&
				getCharsInString(mainStr).equalsIgnoreCase(getCharsInString(targetEndRange)))
		{
			int target=getIntValInString(mainStr, -1);
			int source1=getIntValInString(targetStartRange, -1);
			int source2=getIntValInString(targetEndRange, -1);
			if (-1 == target && -1 == source1 && -1 == source2) {
				stringWithInRange = true;
			}
			else {
				if (source1 <= source2) {
					if(target>=source1 && target <=source2){
						stringWithInRange=true;
					}
				}
				else {
					if(target>=source2 && target <=source1){
						stringWithInRange=true;
					}
				}
			}
		}
	  return stringWithInRange;
  }
  
  // expects string ranges like 0-10,44-47,etc.
  public static boolean stringInRanges(String str, List<String> ranges) {
	  boolean result = false;
	  if (null != str && null != ranges && !ranges.isEmpty()) {
		  for (String nextRange: ranges) {
			  if (stringInRange(str, nextRange)) {
				  result = true;
				  break;
			  }
		  }
	  }
	  return result;
  }
  
  // note: only supports positive values in check
  public static boolean stringInRange(String str, String rangeString) {
	  boolean result = false;
	  if (null != str && null != rangeString) {
		  List<String> splitRange = tokenize(rangeString, "-");
		  if (null != splitRange) {
			  if (1 == splitRange.size()) { // no range check
				  int val = parseIntegerFromString(str, -1);
				  int compareVal = parseIntegerFromString(str, -2);
				  if (val == compareVal) {
					  result = true;
				  }
			  }
			  else if (2 == splitRange.size()) {
				  int val = parseIntegerFromString(str, -1);
				  int firstRange = parseIntegerFromString(splitRange.get(0), -2);
				  int secondRange = parseIntegerFromString(splitRange.get(0), -3);
				  if (val > 0 && firstRange > 0 && secondRange > 0) {
					  if (firstRange < secondRange) {
						  if (val >= firstRange && val <= secondRange) {
							  result = true;
						  }
					  }
					  else {
						  if (val <= firstRange && val >= secondRange) {
							  result = true;
						  }
					  }
				  }
			  }
			  else {
				  throw new IllegalArgumentException("Invalid range passed to string in range: " + rangeString + ":" + str);
			  }
		  }
	  }
	  return result;
  }
  

  /*
   * Returns an int value of the given String passed
   */
  public static int getIntValInString(String str, int defaultValue){
	int result = defaultValue;	
	StringBuilder sbh=new StringBuilder();
	for (int i = 0; i < str.length(); i++) { //Finding the digits.
		if (Character.isDigit(str.charAt(i))){
         	sbh.append(str.charAt(i));
         }
	}
	if (sbh.length() > 0) {
		result =Integer.parseInt(sbh.toString());
	}
	return result;
  }

  /*
  * Returns a String value of the given String passed
  */
  public static String getCharsInString(String str){
		
		StringBuilder sbh=new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			//Finding the digits.
            if (Character.isDigit(str.charAt(i))){            
            }else
            {
            	sbh.append(str.charAt(i));
            }
        }
		return sbh.toString();
	}	

	public static String rpad(String s, int length) {
		return rpad(s, ' ', length);
	}
	
	public static String rpad(String s, char padChar, int length) {
		String result = null;
		if (length > 0) {
			if (null == s) {
				s = "";
			}
			if (s.length() < length) {
				StringBuilder buf = new StringBuilder(s);
				for (int i = s.length(); i < length; i++) {
					buf.append(padChar);
				}
				result = buf.toString();
			} else {
				result = s.substring(0, length);
			}
		}
		else {
			result = "";
		}
		return result;
	}

	/*
	 * Convert the wild cards *, ? into regex expressions.
	 * Check Test Case WildcardRegex.java for more info.
	 */
	 public static String wildcardToRegex(String wildcard){
	        StringBuffer s = new StringBuffer(wildcard.length());
	        s.append('^');
	        for (int i = 0, is = wildcard.length(); i < is; i++) {
	            char c = wildcard.charAt(i);
	            switch(c) {
	                case '*':
	                    s.append(".*");
	                    break;
	                case '?':
	                    s.append(".");
	                    break;
	                    // escape special regexp-characters
	                case '(': case ')': case '[': case ']': case '$':
	                case '^': case '.': case '{': case '}': case '|':
	                case '\\':
	                    s.append("\\");
	                    s.append(c);
	                    break;
	                default:
	                    s.append(c);
	                    break;
	            }
	        }
	        s.append('$');
	        return(s.toString());
	    }
	
	
	/*
	 * Matches Regular Expression with the input String.
	 */
	public static boolean matchRegex(String regexExpr, String str)
	{
	    	java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regexExpr);
	    	java.util.regex.Matcher matcher = pattern.matcher(str);
	    	return matcher.find();
	}
	
	/**
	 * checks whether a given string is a number(can be double) or not
	 * @param stringNumber
	 * @return
	 */
	public static boolean isNumeric(String stringNumber)
	{
		if(isEmpty(stringNumber))
			return false;
		return matchRegex("\\A[\\s]*[0-9]*[\\.]?[0-9]+[\\s]*\\z", stringNumber);			
	}
	/**
	 * checks whether a given string is a number(can be double) or not
	 * @param stringNumber
	 * @return
	 */
	public static boolean isItemNbr(String s)
	{
		//1. Remove the % symbol
		if(s.contains("%")){
			s = s.replaceAll("%", "");
		}
		return 	isNumeric(s);
	}
	/**
	 * converts a string representation of number to big decimal
	 * @param stringNumber
	 * @return
	 */
	public static BigDecimal toBigDecimal(String s){
		BigDecimal bigDecimal=null;
		if(null!=s && isNumeric(s))
			bigDecimal=new BigDecimal(s);
		return bigDecimal;
	}
	
	// return all elements in src that are not in compare
	public static List<String> diffList(List<String> src, List<String> compare) {
		List<String> result = new ArrayList<String>();
		if (null != src) {
			if (null == compare || compare.isEmpty()) {
				result.addAll(src);
			}
			else {
				for (String next: src) {
					if (!compare.contains(next)) {
						result.add(next);
					}
				}
			}
		}
		return result;
	}
	
	public static String replaceConstantsInMessage(String message, Map<String, Object> objectStack,
			Map<String, String> constants) {
		String result = null;
		if (null == constants) {
			constants = new HashMap<String, String>();
		}
		if (null != objectStack) {
			constants.put(ObjectStackValues.ModuleName.toString(), getFromObjectStack(ObjectStackValues.ModuleName.toString(), objectStack));
			constants.put(ObjectStackValues.ErrorCode.toString(), getFromObjectStack(ObjectStackValues.ErrorCode.toString(), objectStack));
			constants.put(ObjectStackValues.ErrorMessage.toString(), getFromObjectStack(ObjectStackValues.ErrorMessage.toString(), objectStack));
			constants.put(ObjectStackValues.ObjectId.toString(), getFromObjectStack(ObjectStackValues.ObjectId.toString(), objectStack));
			constants.put(ObjectStackValues.ObjectType.toString(), getFromObjectStack(ObjectStackValues.ObjectType.toString(), objectStack));
			constants.put(ObjectStackValues.Object.toString(), getFromObjectStack(ObjectStackValues.Object.toString(), objectStack));
			constants.put(ObjectStackValues.AuditContext.toString(), getFromObjectStack(ObjectStackValues.AuditContext.toString(), objectStack));
		}
		result = replaceConstantsInMessage(message, constants);
		return result;
	}
	
	public static String replaceConstantsInMessage(String message, Map<String, String> constants) {
		String result = message;
		if (null != message && null != constants && !constants.isEmpty()) {
			result = StringUtil.replaceConstants(message, constants);
		}
		return result;
	}
	
	public static void putInObjectStack(Map<String, Object> objectStack, String key, Object value) {
		if (null != objectStack && null != key) {
			if (null != value) {
				objectStack.put(key, value);
			}
			else {
				objectStack.put(key, "null");
			}
		}
	}
	
	private static String getFromObjectStack(String key, Map<String, Object> objectStack) {
		String result = "Unknown";
		if (null != key && null != objectStack) {
			Object o = objectStack.get(key);
			if (null != o) {
				result = StringUtil.replaceNull(o.toString(), result);
			}
		}
		return result;
	}	
	
	public static boolean compare(String str1, String str2) {
		boolean retVal = false;
		
		if (str1 != null && str2 != null) {
			if (str1.equalsIgnoreCase(str2)) {
				retVal = true;
			}
		}
		return retVal;
	}
	
	public static String[] parseRequestOrderStatus(String status){
		status =status.replaceAll("\\[", "");
		status = status.replaceAll("\"", "").replaceAll("\\]", "");
		return status.split(",");
	}
	
	public static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
	
	/*
  public static void main(String[] args) {
	  System.out.println("[" + rpad("abc", 10) + "]");
	  System.out.println("[" + rpad("abcdefgh", 5) + "]");
	  System.out.println("[" + rpad(null, 5) + "]");
	  System.out.println("[" + rpad("abcdefgh", -1) + "]");
  }
  */
  
}
