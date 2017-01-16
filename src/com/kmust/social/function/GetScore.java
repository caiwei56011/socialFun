package com.kmust.social.function;

import java.util.ArrayList;
import java.util.List;

public class GetScore implements Base {
	
	public static double [][]getScore(int[][] user_movie_base,double[][] combineMatrix ){
	
	double[][] matrix = new double[PREFROWCOUNT][COLUMNCOUNT];
	List<Integer> neighborSerial = new ArrayList<Integer>();
	double u[]=new double[PREFROWCOUNT];
	int count=0;
	for(int i=0;i<PREFROWCOUNT;i++){
		count=0;
		for(int j=0;j<COLUMNCOUNT;j++) 
		    if(user_movie_base[i][j]!=0){
			    count++;                       //评分不为0的人数
			    u[i]+=user_movie_base[i][j];
		}
		u[i]=u[i]/count;                     //平均值
		//System.out.println(u[i]+"  "+count);
	}

	for (int i = 0; i <PREFROWCOUNT ; i++) {
		neighborSerial.clear();
		double max = 0;
		int j = 0;
		int itemSerial = 0;
		int itemId = 0;
		for (; j < COLUMNCOUNT; j++) {
			if (user_movie_base[i][j] == 0) {
				double similaritySum = 0;
				double sum = 0;
				double score = 0;
				neighborSerial = new FindKNeighbors().findKNeighbors(user_movie_base, i,j,combineMatrix);
			/*	for (int m = 0; m < neighborSerial.size(); m++) {
					sum += combineMatrix[i][neighborSerial.get(m)]* user_movie_base[neighborSerial.get(m)][j];
					similaritySum += combineMatrix[i][neighborSerial.get(m)];
				}*/
			
				for (int m = 0; m < neighborSerial.size(); m++) {
					try {
						similaritySum += Math.abs(combineMatrix[i][neighborSerial.get(m)]); //combinematrix为用户相似矩阵
						if(user_movie_base[neighborSerial.get(m)][j]!=0)
						    sum += combineMatrix[i][neighborSerial.get(m)]* (user_movie_base[neighborSerial.get(m)][j]-u[neighborSerial.get(m)]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (similaritySum == 0)
					score = 0;
				else
					score =u[i]+ sum / similaritySum;
				itemId = j;
				matrix[i][itemId] = score;
			}
			else matrix[i][j]=user_movie_base[i][j];

			
		}
		
		

	}

	return matrix;
	}
}
