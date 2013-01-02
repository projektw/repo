package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DFileUtils {

	public void writeTextFile(String content, String fileName){
		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		    out.write(content);
		    out.close();
		} catch (IOException e) {
		
	}
	}
}
