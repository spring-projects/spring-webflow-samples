package org.springframework.webflow.samples.booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.faces.model.SelectItem;

import org.springframework.stereotype.Service;

@Service
public class ReferenceData {

	private List<SelectItem> bedOptions;

	private List<SelectItem> smokingOptions;

	private List<SelectItem> creditCardExpMonths;

	private List<SelectItem> creditCardExpYears;

	private List<SelectItem> pageSizeOptions;

	public List<SelectItem> getBedOptions() {
		if (bedOptions == null) {
			bedOptions = new ArrayList<>();
			bedOptions.add(new SelectItem(1, "One king-size bed"));
			bedOptions.add(new SelectItem(2, "Two double beds"));
			bedOptions.add(new SelectItem(3, "Three beds"));
		}
		return bedOptions;
	}

	public List<SelectItem> getSmokingOptions() {
		if (smokingOptions == null) {
			smokingOptions = new ArrayList<>();
			smokingOptions.add(new SelectItem(Boolean.TRUE, "Smoking"));
			smokingOptions.add(new SelectItem(Boolean.FALSE, "Non-Smoking"));
		}
		return smokingOptions;
	}

	public List<SelectItem> getCreditCardExpMonths() {
		if (creditCardExpMonths == null) {
			creditCardExpMonths = new ArrayList<>();
			creditCardExpMonths.add(new SelectItem(1, "Jan"));
			creditCardExpMonths.add(new SelectItem(2, "Feb"));
			creditCardExpMonths.add(new SelectItem(3, "Mar"));
			creditCardExpMonths.add(new SelectItem(4, "Apr"));
			creditCardExpMonths.add(new SelectItem(5, "May"));
			creditCardExpMonths.add(new SelectItem(6, "Jun"));
			creditCardExpMonths.add(new SelectItem(7, "Jul"));
			creditCardExpMonths.add(new SelectItem(8, "Aug"));
			creditCardExpMonths.add(new SelectItem(9, "Sep"));
			creditCardExpMonths.add(new SelectItem(10, "Oct"));
			creditCardExpMonths.add(new SelectItem(11, "Nov"));
			creditCardExpMonths.add(new SelectItem(12, "Dec"));
		}
		return creditCardExpMonths;
	}

	public List<SelectItem> getCreditCardExpYears() {
		if (creditCardExpYears == null) {
			creditCardExpYears = new ArrayList<>();
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			creditCardExpYears.add(new SelectItem(year, String.valueOf(year++)));
			creditCardExpYears.add(new SelectItem(year, String.valueOf(year++)));
			creditCardExpYears.add(new SelectItem(year, String.valueOf(year++)));
			creditCardExpYears.add(new SelectItem(year, String.valueOf(year++)));
			creditCardExpYears.add(new SelectItem(year, String.valueOf(year++)));	}
		return creditCardExpYears;
	}

	public List<SelectItem> getPageSizeOptions() {
		if (pageSizeOptions == null) {
			pageSizeOptions = new ArrayList<>();
			pageSizeOptions.add(new SelectItem(5, "5"));
			pageSizeOptions.add(new SelectItem(10, "10"));
			pageSizeOptions.add(new SelectItem(20, "20"));
		}
		return pageSizeOptions;
	}

}
