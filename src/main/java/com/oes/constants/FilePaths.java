package com.oes.constants;

import java.io.File;

public class FilePaths {
	
	public static String BASE_DIR = System.getProperty("user.dir");
	public static String RESOURCES_DIR = BASE_DIR + File.separator + "src" + File.separator + "main" + File.separator + "resources";
	public static String DATA_DIR = RESOURCES_DIR + File.separator + "data";
	public static String OES_XLS_FILE = DATA_DIR + File.separator + "oes.xlsx";
	

}
