package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadDownloadFiles {
	
	public static Logger log = LogManager.getLogger(UploadDownloadFiles.class.getName());
	
	public static String uploadSampleFile(String filePath, String execPath) throws Throwable
	{
		try {		
			int index = filePath.lastIndexOf('\\');
			String fileName = filePath.substring(index+1, filePath.length()-1);	
			
			String actualExecPath = execPath + " " + filePath;	
			
			Runtime.getRuntime().exec(actualExecPath);
			
			return fileName;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in uploading the required file!");
			throw t;
		}
	}
	
	public static void verifyDownloadedFile(String fileName, String path) throws Throwable
	{
		try {
			//TODO
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in downloading required file!");
			throw t;
		}
	}

}
