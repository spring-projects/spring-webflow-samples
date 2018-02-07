package org.springframework.webflow.samples.booking;

import java.io.Serializable;


/**
 * A backing bean for the main hotel search form. Encapsulates the criteria needed to perform a hotel search.
 */
public class SearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The user-provided search criteria for finding Hotels.
	 */
	private String searchString;

	/**
	 * The maximum page size of the Hotel result list
	 */
	private int pageSize;

	/**
	 * The current page of the Hotel result list.
	 */
	private int page;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}