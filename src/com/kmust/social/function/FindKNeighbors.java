package com.kmust.social.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKNeighbors implements Base{
	/**
	 * This method is used to find the nearest K neighbors to the un_scored item 
	 * @param score
	 * @param i
	 * @param similarityMatrix
	 * @return
	 */
	//璇ユ柟娉曟湁涓変釜鍙傛暟锛宻core琛ㄧず鏌愪竴鐢ㄦ埛瀵规墍鏈夐」鐩殑璇勫垎锛沯琛ㄧず鏌愪釜椤圭洰鐨勫簭鍙�
	public  List<Integer> findKNeighbors(int[][] score,int i,int j,double[][] similarityMatrix) {	
		double a=Double.NEGATIVE_INFINITY ;
		List<Integer> neighborSerial = new ArrayList<Integer>();
		double[] similarity = new double[ similarityMatrix.length];int count=0;
		for (int t = 0; t < similarityMatrix.length; t++) {
			if(score[t][j] != 0) {
				similarity[t] = similarityMatrix[t][i];
			} 
			else {
				similarity[t] = a;
			}
		}	
		/*	double[] temp = new double[similarity.length];
		for (int j = 0; j < temp.length; j++) {
			temp[j] = similarity[j];
		}
		Arrays.sort(temp);

		for(int j = 0; j < similarity.length; j++) {
			for (int m = temp.length - 1; m >= temp.length - KNEIGHBOUR; m--) {
				if (similarity[j] == temp[m] && similarity[j] != 0.0)
					neighborSerial.add(new Integer(j));
			}	
		} */
		double[] temp = new double[similarity.length];
		for (int k = 0; k < temp.length; k++) {
			temp[k] = similarity[k];
		}
		Arrays.sort(temp);
		for(int k = 0; k < similarity.length; k++){
			if (temp[temp.length-1] == similarity[k]&&similarity[k]!=a)
		        neighborSerial.add(new Integer(k));
		}
		for (int m = temp.length-2; m >= temp.length - KNEIGHBOUR-1; m--) {
			for(int k = 0; k < similarity.length; k++){
				if (temp[m]!=temp[temp.length-1]&&temp[m] == temp[m+1]) 
					break;
				if (temp[m] == similarity[k]&&similarity[k]!=a)
			        neighborSerial.add(new Integer(k));
			}
		}
		return neighborSerial; 
	}

}
