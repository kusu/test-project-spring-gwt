package com.me.testproject.shared.utils;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.Format;

public class ClientFormatter {

	public static String formatMoney(double amount) {

		return NumberFormat.getFormat("#,###.00").format(amount);
	}

	public static String formatMoneyWithCurrency(double amount) {
		return "NPR " + NumberFormat.getFormat("#,##0.00", "NPR").format(amount);
	}

	public static String formatAmount(double amount) {
		return NumberFormat.getFormat("#,##0.00").format(amount);
	}

	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		DateTimeFormat format = DateTimeFormat.getFormat("dd MMM yyyy, hh:mm a");
		return format.format(date);

	}

	public static DateTimeFormat getDateFormat() {
		DateTimeFormat format = DateTimeFormat.getFormat("dd MMM yyyy, hh:mm a");
		return format;
	}

	public static Format getDateBoxFormat() {
		Format format = new DateBox.DefaultFormat(getDateFormat());
		return format;
	}

	public static String formatShortDateTime(Date d) {
		DateTimeFormat format = DateTimeFormat.getFormat("dd MMM yyyy");
		return format.format(d);
	}

}
