package com.kmust.social.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile52 implements Base{
	
		public int[][] readFile(int rowCount,String fileName) {	
			//	public static final int COLUMNCOUNT = 52;	//number of items
			//	public static final int PREFROWCOUNT = 943;	//number of users

			int [][] user_movie=new int [PREFROWCOUNT][COLUMNCOUNT];

			try {
				File file = new File(fileName);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				int i=0;
				while (br.ready()) {
					line = br.readLine();
					String[] data = line.split("\t");
					   for(int j=0;j<data.length;j++){
						user_movie[i][j] = Integer.parseInt(data[j]);
					   }
					   i++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*return preference;*/
			return user_movie;
		
	}

}
		
