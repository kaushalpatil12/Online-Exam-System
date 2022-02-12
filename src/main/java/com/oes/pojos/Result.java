package com.oes.pojos;

import com.oes.constants.ResultStatus;

public class Result {
	
	int passCount;
	int totalCount;
	int percent;
	ResultStatus status;
	
	public Result(int passCount, int totalCount) {
		super();
		this.passCount = passCount;
		this.totalCount = totalCount;
		this.percent = passCount * 100 / totalCount;
		if(percent >= 35) status = ResultStatus.PASS;
		else status = ResultStatus.FAIL;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public ResultStatus getStatus() {
		return status;
	}

	public void setStatus(ResultStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Result [passCount=" + passCount + ", totalCount=" + totalCount + ", percent=" + percent + ", status="
				+ status + "]";
	}
	

}
