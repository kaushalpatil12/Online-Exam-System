package com.oes.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

import com.oes.constants.FilePaths;
import com.oes.pojos.Student;

public class StudentData {

	XlsReader oesXlsReader;
	XlsWriter xlsWriter;
	public StudentData() {
		oesXlsReader = new XlsReader(FilePaths.OES_XLS_FILE, "student");
		xlsWriter = new XlsWriter(FilePaths.OES_XLS_FILE, "student");
	}

	public List<Student> getAllStudents() {
		Map<Integer, Map<Integer, String>> data = oesXlsReader.getAllData();
		Set<Integer> rows = data.keySet();
		List<Student> list = new ArrayList<Student>();
		for (Integer row : rows) {
			if(row == 0) continue;
			Map<Integer, String> rowData = data.get(row);
			Set<Integer> cols = rowData.keySet();
			Student student = new Student();
			for (Integer col : cols) {
				String value = rowData.get(col);
				switch (col) {
				case 0:
					student.setId((int)Double.parseDouble(value));
					break;
				case 1:
					student.setFirstName(value);
					break;
				case 2:
					student.setLastName(value);
					break;
				case 3:
					student.setQualification(value);
					break;
				case 4:
					student.setMobile(value);
					break;
				case 5:
					student.setEmail(value);
					break;
				case 6:
					student.setPassword(value);
					break;
				default:
					break;
				}
			}
			list.add(student);
			
		}
		return list;
	}
	
	public boolean addStudent(Student student) {
		Map<Integer, String> studentData = new HashedMap<Integer, String>();
		studentData.put(0, String.valueOf(getAllStudents().size() + 1));
		studentData.put(1, student.getFirstName());
		studentData.put(2, student.getLastName());
		studentData.put(3, student.getQualification());
		studentData.put(4, student.getMobile());
		studentData.put(5, student.getEmail());
		studentData.put(6, student.getPassword());
		
		boolean isAdded = xlsWriter.addRow(studentData);
		return isAdded;
	}



}
