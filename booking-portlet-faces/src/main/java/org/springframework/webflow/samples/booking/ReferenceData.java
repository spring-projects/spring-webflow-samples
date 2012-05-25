package org.springframework.webflow.samples.booking;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

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
	    bedOptions = new ArrayList<SelectItem>();
	    bedOptions.add(new SelectItem(new Integer(1), "One king-size bed"));
	    bedOptions.add(new SelectItem(new Integer(2), "Two double beds"));
	    bedOptions.add(new SelectItem(new Integer(3), "Three beds"));
	}
	return bedOptions;
    }

    public List<SelectItem> getSmokingOptions() {
	if (smokingOptions == null) {
	    smokingOptions = new ArrayList<SelectItem>();
	    smokingOptions.add(new SelectItem(Boolean.TRUE, "Smoking"));
	    smokingOptions.add(new SelectItem(Boolean.FALSE, "Non-Smoking"));
	}
	return smokingOptions;
    }

    public List<SelectItem> getCreditCardExpMonths() {
	if (creditCardExpMonths == null) {
	    creditCardExpMonths = new ArrayList<SelectItem>();
	    creditCardExpMonths.add(new SelectItem(new Integer(1), "Jan"));
	    creditCardExpMonths.add(new SelectItem(new Integer(2), "Feb"));
	    creditCardExpMonths.add(new SelectItem(new Integer(3), "Mar"));
	    creditCardExpMonths.add(new SelectItem(new Integer(4), "Apr"));
	    creditCardExpMonths.add(new SelectItem(new Integer(5), "May"));
	    creditCardExpMonths.add(new SelectItem(new Integer(6), "Jun"));
	    creditCardExpMonths.add(new SelectItem(new Integer(7), "Jul"));
	    creditCardExpMonths.add(new SelectItem(new Integer(8), "Aug"));
	    creditCardExpMonths.add(new SelectItem(new Integer(9), "Sep"));
	    creditCardExpMonths.add(new SelectItem(new Integer(10), "Oct"));
	    creditCardExpMonths.add(new SelectItem(new Integer(11), "Nov"));
	    creditCardExpMonths.add(new SelectItem(new Integer(12), "Dec"));
	}
	return creditCardExpMonths;
    }

    public List<SelectItem> getCreditCardExpYears() {
	if (creditCardExpYears == null) {
	    creditCardExpYears = new ArrayList<SelectItem>();
	    creditCardExpYears.add(new SelectItem(new Integer(2008), "2008"));
	    creditCardExpYears.add(new SelectItem(new Integer(2009), "2009"));
	    creditCardExpYears.add(new SelectItem(new Integer(2010), "2010"));
	    creditCardExpYears.add(new SelectItem(new Integer(2010), "2011"));
	    creditCardExpYears.add(new SelectItem(new Integer(2010), "2012"));
	}
	return creditCardExpYears;
    }

    public List<SelectItem> getPageSizeOptions() {
	if (pageSizeOptions == null) {
	    pageSizeOptions = new ArrayList<SelectItem>();
	    pageSizeOptions.add(new SelectItem(new Integer(5), "5"));
	    pageSizeOptions.add(new SelectItem(new Integer(10), "10"));
	    pageSizeOptions.add(new SelectItem(new Integer(20), "20"));
	}
	return pageSizeOptions;
    }

}
