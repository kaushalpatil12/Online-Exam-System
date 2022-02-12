package com.oes.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oes.constants.FilePaths;
import com.oes.pojos.Option;
import com.oes.pojos.Question;

public class QuestionData {
	
	XlsReader oesXlsReader;
	public QuestionData() {
		oesXlsReader = new XlsReader(FilePaths.OES_XLS_FILE, "questions");
	}
	
	public List<Question> getAllQuestions() {
		Map<Integer, Map<Integer, String>> data = oesXlsReader.getAllData();
		Set<Integer> rows = data.keySet();
		List<Question> list = new ArrayList<Question>();
		for (Integer row : rows) {
			if(row == 0) continue;
			Map<Integer, String> rowData = data.get(row);
			Set<Integer> cols = rowData.keySet();
			Question question = new Question();
			for (Integer col : cols) {
				String value = rowData.get(col);
				switch (col) {
				case 0:
					question.setId((int)Double.parseDouble(value));
					break;
				case 1:
					question.setQuestion(value);
					break;
				case 2:
					question.getOptions().add(new Option("a", value));
					break;
				case 3:
					question.getOptions().add(new Option("b", value));
					break;
				case 4:
					question.getOptions().add(new Option("c", value));
					break;
				case 5:
					question.getOptions().add(new Option("d", value));
					break;
				case 6:
					question.setAnswer(new Option(value.trim(), ""));
					break;
				default:
					break;
				}
			}
			list.add(question);
			
		}
		return list;
	}



}
