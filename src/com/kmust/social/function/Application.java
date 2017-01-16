package com.kmust.social.function;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;


public class Application extends PrintArray implements Base {

	public static void main(String[] args) throws IOException {
		
		int[][] user_movie_base = new int[PREFROWCOUNT][COLUMNCOUNT];
		user_movie_base = new ReadFile52().readFile(BASE_LINE, BASE); // base中有943个用户对1682个项目的评分

	   double[][] similarityMatrix = new ProduceSimilarityMatrix()
			.produceSimilarityMatrix(user_movie_base);

		double[][] matrix = GetScore
			.getScore(user_movie_base, similarityMatrix);

		Schulze.schulze(PREFROWCOUNT,COLUMNCOUNT,matrix);

		//		Borda.borda( PREFROWCOUNT,COLUMNCOUNT,matrix);
		//		Average.average( PREFROWCOUNT,COLUMNCOUNT,matrix);
		//	  Condorcet.condorcet( PREFROWCOUNT,COLUMNCOUNT,matrix);
		//	Copeland.copeland( PREFROWCOUNT,COLUMNCOUNT,matrix);
		//	SecondCopeland.secondcopeland( PREFROWCOUNT,COLUMNCOUNT,matrix);
	//	RankedPairs.rankedpairs(PREFROWCOUNT,COLUMNCOUNT,matrix);

	}

	public String doSchulze(File file,String newFileNameLength){

		String name = file.getName();
		int [][] user_movie_base=new int [PREFROWCOUNT][Integer.valueOf(newFileNameLength)];
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			int i=0;
			while (br.ready()) {
				line = br.readLine();
				String[] data = line.split("\t");
				for(int j=0;j<data.length;j++){
					user_movie_base[i][j] = Integer.parseInt(data[j]);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		double[][] similarityMatrix = new ProduceSimilarityMatrix()
				.produceSimilarityMatrix(user_movie_base);

		double[][] matrix = GetScore
				.getScore(user_movie_base, similarityMatrix);

		String schulzeInfo = Schulze.schulze(PREFROWCOUNT, COLUMNCOUNT, matrix);
		return schulzeInfo;
	}

	
}
