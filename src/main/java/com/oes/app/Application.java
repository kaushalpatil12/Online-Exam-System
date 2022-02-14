package com.oes.app;

import java.util.List;
import java.util.Optional;

import com.oes.data.StudentData;
import com.oes.pages.LoginPage;
import com.oes.pojos.Student;

public class Application {

	private static Application app;
	private Student loggedInStudent;
	private boolean isLoggedIn;
	private StudentData studentData;


	private Application() {
		studentData = new StudentData();
	}

	public static Application getInstance() {
		if(app == null) {
			app = new Application();
		}
		return app;
	}

	public void lauchApp() {
		LoginPage.getInstance().open();
	}

	public boolean login(String email, String password) {
		List<Student> students = studentData.getAllStudents();
		System.out.println("Checking login --- users are ---" + students);
		Optional<Student> matchingStudent = students.stream()
				.filter(
						(student) ->  student.getEmail().equalsIgnoreCase(email) && student.getPassword().equals(password)
						)
				.findFirst();
		if(matchingStudent.isPresent()) {
			isLoggedIn = true;
			loggedInStudent = matchingStudent.get();
			return true;
		}else {
			return false;
		}
	}

	public void logout() {
		loggedInStudent = null;
		isLoggedIn = false;
	}

	public Student getLoggedInStudent() {
		return loggedInStudent;
	}

	public void setLoggedInStudent(Student loggedInStudent) {
		this.loggedInStudent = loggedInStudent;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


}
