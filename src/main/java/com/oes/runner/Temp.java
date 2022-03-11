package com.oes.runner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.oes.data.StudentData;
import com.oes.pojos.Student;

public class Temp {

	public static void main(String args[]) {
		
		
		StudentData studentData = new StudentData();
		Student student = new Student(2, "test", "last", "dd", "546879213", "test@gmail.com", "test123");
		studentData.addStudent(student);
		
		
//		String oesDataFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\oes.xlsx";
//		System.out.println("Path --- "+ oesDataFilePath);
//		XlsReader xlsReader = new XlsReader(oesDataFilePath, "student");
////		String data = xlsReader.getData(1, 1);
//		Map<Integer, Map<Integer, String>> data = xlsReader.getAllData();
//		System.out.println("data --"+ data);
//		
//		List<Student> students = new StudentData().getAllStudents();
//		System.out.println("Students ====" + students);

		
		
//		List<Question> questions = new QuestionData().getAllQuestions();
//		System.out.println("Questions ====" + questions);
		
//		String username = "suraj@gmail.com";
//		String emailPattern = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.[a-z]{2,3})+$|^$";
//		boolean isUsernameValid = Pattern.compile(emailPattern).matcher(username).matches();  
//		
//		System.out.println("isUsernameValid====" + isUsernameValid);
//		
//		
//		System.out.println("=====================" + emailValidate(username));
		

		
//		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		
//		
//		List<Integer> evenNums = numbers.stream().filter( num -> num % 2 != 0).collect(Collectors.toList());
//		
//		Optional<Integer> number = numbers.stream().filter(num -> num % 5 == 0).findFirst();
//		
//		if(number.isPresent())
//			System.out.println("-----" + number.get());
//		
//		System.out.println("Even Nums= " + evenNums);
		
		
		
//		//Blank workbook
//        XSSFWorkbook workbook = new XSSFWorkbook(); 
//         
//        //Create a blank sheet
//        XSSFSheet sheet = workbook.createSheet("Employee Data");
//          
//        //This data needs to be written (Object[])
//        Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
//        data.put("2", new Object[] {1, "Amit", "Shukla"});
//        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
//        data.put("4", new Object[] {3, "John", "Adwards"});
//        data.put("5", new Object[] {4, "Brian", "Schultz"});
//          
//        //Iterate over data and write to sheet
//        Set<String> keyset = data.keySet();
//        int rownum = 0;
//        for (String key : keyset)
//        {
//            Row row = sheet.createRow(rownum++);
//            Object [] objArr = data.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr)
//            {
//               Cell cell = row.createCell(cellnum++);
//               if(obj instanceof String)
//                    cell.setCellValue((String)obj);
//                else if(obj instanceof Integer)
//                    cell.setCellValue((Integer)obj);
//            }
//        }
//        try
//        {
//            //Write the workbook in file system
//            FileOutputStream out = new FileOutputStream(new File("sample-demo.xlsx"));
//            workbook.write(out);
//            out.close();
//            System.out.println("sample-demo.xlsx written successfully on disk.");
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
	}  
	
	public static boolean emailValidate(String email) {
	    Matcher matcher = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.[a-z]{2,3})+$|^$", Pattern.CASE_INSENSITIVE).matcher(email);
	    return matcher.find();
	}

}


