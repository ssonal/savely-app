package com.example.savely;

import android.provider.BaseColumns;

public final class AddNewContract {

	public AddNewContract() {
		// TODO Auto-generated constructor stub
	}
	
	//Defines the table contents
	public static abstract class Accounts implements BaseColumns {
		public static final String TABLE_NAME = "accounts";
		public static final String COLUMN_NAME_ACCOUNT_TYPE = "accounttype";
		public static final String COLUMN_NAME_USER_ID = "userid";
		public static final String COLUMN_NAME_EXPENSES = "expenses";
		public static final String COLUMN_NAME_DATE = "date";
		public static final String COLUMN_NAME_EXPENSE_TYPE = "expensetype";
	}

}