package com.pccu.ImageCopy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopy {
	
	public static void Copy(String i, String o) {
		FileReader reader = null;
		FileWriter writer = null;
		
		BufferedReader buffer = null;
		PrintWriter printer = null;
		
		try {
			reader = new FileReader("src/"+i);
			writer = new FileWriter("src/"+o);
			
			buffer = new BufferedReader(reader);
			printer = new PrintWriter(writer);
			
			String flag = "";
			while ((flag = buffer.readLine()) != null) {
				printer.write(flag);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) reader.close(); 
				if (writer != null) writer.close();
				System.out.println("Copy completed.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Copy("documents/abstract1.txt",
			 "documents/abstract1_1.txt"
		);
	}

}
