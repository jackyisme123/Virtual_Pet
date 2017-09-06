package myPet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class fileIO {

	public static void createFile(String filename, String fileContent) {
		Boolean bool = false;
		File file = new File(filename);
		try {
			if (!file.exists()) {
				file.createNewFile();
				bool = true;
				System.out.println("sucessfully create file");
				fileIO.writeIn(filename, fileContent);
			} else {
				file.delete();
				file.createNewFile();
				bool = true;
				System.out.println("sucessfully change file");
				fileIO.writeIn(filename, fileContent);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean writeIn(String filename, String fileContent) {
		Boolean bool = false;
		String fileIn = fileContent;
		

		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File file = new File(filename);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(fileIn);
			pw.flush();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.close();
		}
		return bool;

	}

	public static String readIn (String filename){
		String content = "";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		
		try{
		File file = new File(filename);
		fis = new FileInputStream(file);
		isr = new InputStreamReader(fis);
		br = new BufferedReader(isr);
		content = br.readLine();
		System.out.println("read sucessfully");
		System.out.println(content);
	}catch(

	Exception e)
	{
		
		System.out.println("cannot find file");
		content = "0";
		throw new RuntimeException("cannot find file");
	}finally
	{
		try {if(fis != null)
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(isr != null)
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
				try {
					if(br!=null)
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	return content;
	}
//	public static void main(String[] args) {
//		createFile("hs","adsfds:asdfa:saadf;sadfas");
//		readIn("hs");
//	}
}


