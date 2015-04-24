package com.crgt.innov2015.util;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	
	// Authorization Constants
	public static final String ACTIVE_USER = "A";
	public static final String IN_ACTIVE_USER = "I";
	public static final String AUTHORIZED_USER_IN_SESSION = "authorizedUserInSession";
	public static final String SFS_USER_GROUP_LIST = "userGroupList";
	
	// Exceptions
	public static final String DUAL_ROLE_USER_EXCEPTION = "You cannot have dual roles, please contact your manager";
	public static final String ACCESS_DENIED_ROLE_EXCEPTION = "You do not have permissions to access, please contact your manager";
	public static final String USER_NOT_ACTIVE_EXCEPTION = "Your eAccess has been revoked, please contact your manager";
	public static final String USER_ROLE_MISSING = "You do not have a role/permission to access, please contact your manager";
	public static final String USER_PRU_NOT_ASSIGNED = "You do not have any PRUs assigned to you in SFS Web, please contact your manager";
	
	// Catalog Constants
	public static final String FILTER_LIST = "filterList";
	public static final String FILTER_VALUE = "filterValue";
	public static final String SORT_LIST = "sortList";
	public static final String SORT_TYPE_LIST = "sortTypeList";
	public static final String SEARCH_PATTERNS = "searcPatterns";
	
	// Item Status
	public static final String AVAILABLE = "A";
	public static final String TEMPORARILY_OUT_OFF_STOCK = "T";
	public static final String NOT_AVAILABLE_TO_ORDER = "P";

	// Response Mapping Constants
	public static final String SHOW_ALL_CATALOG = "allCatalog";
	public static final String SHOW_CATALOG = "catalog";
	public static final String LOGIN_FLOW = "/login-flow";
	public static final String PLACE_ORDER_SUCCESS_RETURN = "orderSuccess";

	// For Constants
	public static final String PRU_OR_BROWSE_ONLY  = "pruOrBrowseOnly";
	public static final String PRU  = "pru";
	public static final String SFS  = "SFS";
	public static final String BROWSE_ONLY  = "browseOnly";
	public static final String NON_POS  = "nonPos";
	public static final String PRU_OR_SFS  = "pruOrSfs";
	public static final String RETURN_CLERK  = "returnClerk";
	public static final String RETURN_SV  = "returnSupervisor";
	public static final String SFS_RETURN_SV_OR_CLERK  = "returnClerkOrSupervisor";
	public static final String VIEW_PRU_INFO_ROLES  = "viewPruInfoRoles";
		
	// Order Controller	
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String RETURN_ORDER_STATUS = "returnOrderStatus";
		
	// Model Attributes
	public static final String ITEM_DETAIL = "itemDetail";
	public static final String ITEM_DETAIL_EDITTABLE = "itemDetailReadOnly";
	
	public static final String ORDER_PAGE_OPTIONS = "orderPageOptions";
	public static final String ORDER_NUMBER = "orderNumber";
	public static final String ORDER_DETAIL_LIST = "orderDetailList";
	public static final String ORDER_HEADER = "orderHeader";
	public static final String ORDER_HEADER_ID = "orderHeaderId";
	public static final String STOCK_REORDER_LIST = "stockReOrderList";
	public static final String PRE_CONFIRM = "preConfirm";
	public static final String PRU_THRESHOLD = "pruThreshold";
	public static final String PRU_LARGE_ORDER = "pruLargeOrder";
	
	public static final String ORDER_DETAIL_SHIPPED_MAP_SHIPPING_NBR = "shippedDetailMap";
	public static final String ORDER_DETAIL_NOT_SHIPPED_YET = "notYetShippedList";
	public static final String ORDER_DETAIL_CANCELED_LIST = "canceledList";
	
	public static final String RETURN_HEADER_ID = "returnHeaderId";
	public static final String RETURN_DETAIL_LIST = "returnDetailList";
	public static final String RETURN_HEADER = "returnHeader";
	public static final String SOURCE_LINK = "sourceLink";
	public static final String RETURN_ORDER_PAGE_OPTIONS = "returnOrderPageOptions";
	public static final String LARGE_ORDER_PAGE_OPTIONS = "largeOrderPageOptions";
		
	// Search Constants
	public static final String PERCENTAGE_OPERATOR = "%";

	//  Contact Constants
	public static final String EMAIL = "stalluri@ctgt.com";	
	public static final String[] EMAIL_GROUP = new String[]{"stalluri@ctgt.com"};
			
	// General
	public static final String FINANCE_UNIT_NO = "ufn";
	public static final String FINANCE_NO = "financeNo";
	public static final String UNIT_NO = "unitNo";
	public static final String UFN_DELIMITER = "-";
	public static final String USER_FORM_IN_SESSION = "userForm";
	public static final String SYSTEM_AS_USER = "innov2015USER";
	public static final String TAB_TITLE = "title";
		
	public static final String EXECUTION_ENVIRONMENT_DEV = "dev";
	public static final String EXECUTION_ENVIRONMENT_SIT = "sit";
	public static final String EXECUTION_ENVIRONMENT_CAT = "cat";
	public static final String EXECUTION_ENVIRONMENT_PROD = "prod";
	public static final String EXECUTION_ENVIRONMENT_TRAINING = "train";
	public static String EXECUTION_ENVIRONMENT = EXECUTION_ENVIRONMENT_DEV;
	
    // TRUE FALSE 
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    
    // String ALL/None etc
    public static final String ALL = "ALL";
	
    // Numbers
	public static final int PENDING_OFFSALE_DAYS = 60;
	public static final int PRESALE_DEFAULT_DAYS = 30;
	public static final int PRU_DRAFT_HOLD_DAYS = 30;
	public static final String PAD_CHAR_ORDER_NUMBER = "0";
	public static final String FLAG_N = "N";
	public static final String FLAG_Y = "Y";
	public static final String FLAG_F = "F";
	public static final String FLAG_NO = "NO";
	public static final String FLAG_YES = "YES";
	public static final String FLAG_EMPTY = "";
	public static final int ERROR = 0;
	public static final int SUCCESS = 1;
	public static final int INVALID_UFN = 2;
	public static final int NONEXISTENT_UFN = 3;
	public static final int MESSAGE_REQUIRED = 4;
	public static final int INVALID_EMAILID  = 5;
	public static final int NO_EMAILIDS  = 6;
	public static final int NO_INVENTORY = 7;
	public static final int AUTO_PUSH_EDITABLE_BEFORE_DAYS = 7;	
	public static final int NO_ITEM = 8;	
	public static final int INVALID_MSG_LENGTH = 10;
	public static final int ZERO_QTY = 11;
	public static final int INVALID_QTY = 12;
	
	public static final int EMPTY_PALLET_NBR = 3;
	
	public static final int ONE_MINS = 1;
	
	// General Constants
	public static final String DELIMITER_COMMA = ",";
	
	// FNCM reporting technology constants
	public static final String SSK = "06";
	public static final String eMOVES = "04";

	// Order constants
	public static final String Emergency_Order = "emergency";
	public static final String APO_Order = "apoOrder";
	public static final String CPU_Order = "cpuOrder";
	public static final String ORDER_REQUEST = "hidddenOrderRequest";
	public static final String CART_EMPTY = "No Items In Cart";
	public static final String CART_TAMPERED = "The elements in the cart have been tampered with.";
	public static final String ORDER_FAILURE = "Order Could not be processed. Please try again.";
	public static final String LG_ORDER_FAILURE = "Large Order Comments cant be empty. Please try again.";
	public static final String LAST_ORDER_ALERT_MSG = "Your changes cannot be saved because your Order Total exceeds your PRU's SFS Web Single Order Limit of  ##ORDER_CAP##. " +
										"If you need to place a large order, please cancel this order and submit a new large order for SFS to review.";

	public static final String DENIED_PAGE = "accessDenied";
	public static final String SESSION_EXPIRED_PAGE = "sessionExpired";
	public static final String DATE_FORMAT = "MMM d, ''yy";
	public static final String DATE_FORMAT_OTHER = "MM/dd/yyyy";
		
	// Report constants
	public static final String VAULT_REPORT = "VaultReport";
	public static final String APPROVED_FORM17_REPORT = "ApprovedForm17Report";
	public static final String APPROVED_ITEM_REPORT = "ApprovedItemReport";
	
	public static final String CELL_STYLE_CURRENCY = "currency";
	public static final String CELL_STYLE_DATE = "date";
	public static final String CELL_STYLE_NUMBER = "number";
	public static final String CELL_STYLE_PARAGRAPH = "paragraph";
	public static final String CELL_STYLE_DATA = "data";
	public static final String CELL_STYLE_SUBHEADER = "subheader";
	public static final String CELL_STYLE_HEADER = "header";
		
	// Returns review methods
	public static final String COUNT = "C";
	public static final String CURSORY_REVIEW = "R";
	public static final String CURSORY_REVIEW_TO_COUNT = "B";

	// Error messages
	public static final String INVALID_FNCM = "There is no matching PRU for the finance number and unit number you entered. Please try again.";
	public static final String NULL_FINANCE = "Please Enter Finance Number";
	public static final String NULL_UNIT_ID = "Please Enter Unit Number";
	public static final String NULL_USER_FORM = "Please Login";

	// Response Constants
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String FAILURE_MESSAGE = "Fail";
	final static Logger log = LoggerFactory.getLogger(Constants.class);

	// Response Constants for Returns / drafts
	public static final int DRAFT_IN_USE = 2;
	public static final int DRAFT_NOT_FOUND = 3;
	public static final int DRAFT_CHANGED_ANOTHER_USER = 4;
	public static final String DRAFT_IN_USE_MSG = "Another user is working on the page. The draft is not available for you to work on at this time.";
	public static final String DRAFT_CHANGED_MSG  = "Another user has submitted or deleted the draft. Please click ‘OK’ to refresh the page and see the latest changes.";
	public static final String DRAFT_CREATED_BY_OTHER_USER = "Another user has already started creating a draft return. Please allow time for the other user to finish working on the draft before trying again.";
	
	// UFN Related
	public static final String OFFICE_STAMP_ACCOUNT_INDICATOR = "N";
	public static final String OFFICE_ACTIVE = "A";
	public static final String OFFICE_CLOSED = "C";
	public static final String OFFICE_CLOSED_TEMPORARY = "T";
	public static final String OFFICE_CLOSED_MESSAGE = "Office is Closed or Deactivated";
	
	
	public enum OrderByClause {

		ORDER_NBR_DESC("order_nbr desc"), ORDER_NBR_ASC("order_nbr asc"), DATE_ORDERED_DESC(
				"date_ordered desc"), DATE_ORDERED_ASC("date_ordered asc");

		OrderByClause(String orderBy) {
			this.orderBy = orderBy;
		}

		private String orderBy;

		public String getOrderBy() {
			return orderBy;
		}
	}

	// Dashboard messages
	public static final String CLOSED_PRU_MSG = "You may view My Orders, Stock Return and Message Center. All other functions are unavailable because your office is closed or deactivated.";
	public static final String CLOSED_BROWSE_ONLY_MSG = "This is a closed or deactivated office, please click on continue to browse  functions.";
	public static final String CLOSED_PRU_ID = "closedPruMessage";	
	public static final String LAST_ORDER_MSG_ID = "lastOrderMsg";
	public static final String LAST_ORDER_MSG = "Your last order is with order number ##ORDER_NUMBER##";
	
	// Inventory Messages
	public static final String INV_ITEM_OFFDATE = "This item is Off-Sale and cannot be setup for stock reorder";
	public static final String INV_ITEM_NOTFOUND = "This item is not in your PRU’s inventory. Please select an item that you have previously ordered";
	public static final String INV_REORDER_RULE_EXISIS = "This item is already setup for stock reorder";
	public static final String INVALID_ITEM = "Invalid Item Number";
	public static final String INELIGIBLE_REORDER = "This item is not eligible for stock reorder";
	public static final String INELIGIBLE_REORDER_UFN_NON_SSK = "This item is not eligible for stock reorder for this UFN (SSK Item Only)";
	public static final String INELIGIBLE_REORDER_UFN_SSK = "This item is not eligible for stock reorder for this UFN (Not an SSK Item)";
	public static final String INV_ITEM_NO_LONGER_AVAIL = "This item is No Longer Available to Order and cannot be setup for stock reorder";
	
	public static final String INV_NOTFOUND_ZIP = "Item ##ITEM_NUMBER## not available in ZIP ##ZIPORUFN##";
	public static final String INV_NOTFOUND_PRU = "Item ##ITEM_NUMBER## not available at UFN ##ZIPORUFN##";
	public static final String INV_NOTFOUND_FOR_SELECTED_AREA = "Item ##ITEM_NUMBER## not available for the selection";
	public static final String INV_NOTFOUND = "Item ##ITEM_NUMBER## not available";
	public static final String INV_NOTFOUND_FOR_UFN = "No items are available at this UFN ##ZIPORUFN##";

	// Shipment Messages
	public static final String SHIPMENT_NOTFOUND_FOR_UFN = "No shipments are available at this UFN ##UFN##";
	public static final String SHIPMENT_NOTFOUND = "No shipments are available for this Shipment # ##SHIPMENTNBR##.";
	public static final String RETURN_ORDER_RECEIVED_MSG = "Stock Return received successfully. This return is marked for: ##REVIEW_METHOD##";
	
	// Report Messages
	public static final String DATA_NOTFOUND_FOR_SELECTED_DATES = "No results found for selected dates";
	
	// AUTO PUSH Texts
	public static final String WAVE_ID_SELECT_TEXT = "SKU:##ITEM_NUMBER## Auto-Push ID: ##WAVE_ID##";
	public static final String WAVE_IDS_NOTFOUND = "There are no waves that can be used at this time";
	public static final String OFFICE_CLOSED_AUTOPUSH = "Office is Closed or Deactivated and cannot be added to the auto-push at this time.";
	public static final String AUTOPUSH_UFN_HAS_ERRORS = "Office is already included in the auto-push but has errors. Please correct the errors on the Resolve Upload Errors page.";
	public static final String MISSING_UFN_CAN_ADD = "This UFN was not included in the uploaded push file. To add the UFN to the auto-push, enter an Original Quantity and save.";
	
	//Scheduled Job Ids
	public static final Long RESTOCK_ORDER_JOB_ID = 101L;
	public static final String RESTOCK_ORDER_JOB_NAME = "AUTO_REPLENISH";
	public static final Long EMAIL_NO_LONGER_AVAIL_JOB_ID = 103L;
	public static final String EMAIL_NO_LONGER_AVAIL_JOB_NAME = "EMAIL_NO_LONGER_AVAIL";
	public static final Long EMAIL_TEMP_OUT_OF_STOCK_JOB_ID = 105L;
	public static final String EMAIL_TEMP_OUT_OF_STOCK_JOB_NAME = "EMAIL_TEMP_OUT_OF_STOCK";
	public static final Long EMAIL_OFF_SALE_JOB_ID = 107L;
	public static final String EMAIL_OFF_SALE_JOB_NAME = "EMAIL_OFF_SALE";
	public static final Long REMOVE_RULE_FOR_OFF_SALE_JOB_ID = 109L;
	public static final String REMOVE_RULE_FOR_OFF_SALE_JOB_NAME = "REMOVE_RULE_FOR_OFF_SALE";
	public static final Long AUTO_SHIPMENT_EMAIL_JOB_ID = 111L;
	public static final String AUTO_SHIPMENT_EMAIL_JOB_NAME = "AUTO_SHIPMENT_EMAIL";
	public static final Long NCMS_SWEEP_JOB_ID = 102L;
	public static final String NCMS_SWEEP_JOB_NAME = "NCMS_SWEEP";
	public static final long NCMS_SWEEP_INTERVAL = 7200000;
	public static final String NO_FAILED_UFNS = "No UFNs' for which Autoreplenish order generation failed";
	public static final Long CART_DRAFT_DELETE_JOB_ID = 112L;
	public static final String CART_DRAFT_DELETE_JOB_NAME = "CART_DRAFT_DELETE";
	/*
	 * Messages for draft change
	 */
	public static final String MIN_MAX_INCREMENT_CHANGE = "The quantity for Item ##ItemNbr## was adjusted because the min, max or increment changed.";
    public static final String ITEM_PRICE_CHANGED = "The price for Item ##ItemNbr## has changed.";
    public static final String ITEM_NOT_IN_ITEMMASTER = "Item ##ItemNbr## was deleted from your draft because it was removed from the Item Master.";
    public static final String TEMPORARILY_OUT_OF_STOCK = "Item ##ItemNbr## was deleted from your draft because it is Temporarily Out of Stock.";
    public static final String NO_LONGER_AVAIL_TO_ORDER = "Item ##ItemNbr## was deleted from your draft because it is No Longer Available to Order.";
    public static final String OFF_SALE = "Item ##ItemNbr## was deleted from your draft because it is Off-Sale.";
    public static final String PRE_SALE_NOT_AVAIL = " Item ##ItemNbr## was deleted from your draft because it is not available for Pre-Order at this time.";

	// Session attribute name to save draft changes
	public static final String DERAFT_CHANGE_SESSION_ATTR = "draftChangeSessionAttr";
	
	//UFN Listing Exclusions
	public static final List<String> UFN_LISTING_EXCLUSIONS = Arrays.asList("1424001000","4284601000");
	
	public static String[] usernames = {"vmadhu", "tsilpa", "ssandhya", "guest"};
	
	
	// Environment
    public static final java.util.Map<String, String> QUESTION_MAP;
    static
    {
    	QUESTION_MAP = new java.util.HashMap<String, String>();
    	QUESTION_MAP.put("q1", "Do you want to be able to scale infrastructure up and down according to demand");
    	QUESTION_MAP.put("q2", "Do you have workloads where the servers have to be running full power 24x7, or nearly so");
    	QUESTION_MAP.put("q3", "Do you anticipate hardware investments and personnel costs in near term");
    	QUESTION_MAP.put("q4", "Do you prefer a pay-as-you-go model or prefer a long term commitment with a provider with an up front investment");
    	QUESTION_MAP.put("q5", "Do you want to maintain/update/backup of hardware and software and maintain a high availability");
    	QUESTION_MAP.put("q6", "Do you want data/applications to be backed up across different data centers across the globe");
    	QUESTION_MAP.put("q7", "Support speed to market and innovation and agility in infrastructure");
    }
	
}
