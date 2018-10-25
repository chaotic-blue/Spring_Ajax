package com.company.hellospring;

import java.util.Arrays;

public class UserSearchDTO extends UserDTO {
	
	private String searchCondition;	
	private String searchKeyword;
	
	private Integer start;	//integer는 null 을 체크하고 int는 null 이면 값이 0 으로 들어간다.
	private Integer end;
	
	private String[] ids;	//단건조회에 필요한 foreach를 사용하기 위해 사용

	private String sort;
	
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "UserSearchDTO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + ", start="
				+ start + ", end=" + end + ", ids=" + Arrays.toString(ids) + "]";
	}	
}
