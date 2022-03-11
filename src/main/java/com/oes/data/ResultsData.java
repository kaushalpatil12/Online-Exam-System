package com.oes.data;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.oes.app.Application;
import com.oes.constants.FilePaths;
import com.oes.pojos.Result;
import com.oes.pojos.Student;

public class ResultsData {
	
	XlsWriter xlsWriter;
	public ResultsData() {
		xlsWriter = new XlsWriter(FilePaths.OES_XLS_FILE, "results");
	}
	
	public boolean uploadResultToXls(Result result) {
		try {
			Map<Integer, String> resultData = new HashedMap<>();
			Student student = Application.getInstance().getLoggedInStudent();
			resultData.put(0, student.getFirstName());
			resultData.put(1, String.valueOf(result.getPercent()));
			resultData.put(2, String.valueOf(result.getStatus()));
			xlsWriter.addRow(resultData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
