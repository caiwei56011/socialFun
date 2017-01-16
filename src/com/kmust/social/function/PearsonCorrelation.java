package com.kmust.social.function;

import java.util.List;

public class PearsonCorrelation implements Base {
	
	public double pearsonCorrelation(List<Integer> a,List<Integer> b) {
		int num = a.size();
		int sum_prefOne = 0;
		int sum_prefTwo = 0;
		double sum_squareOne = 0;
		double sum_squareTwo = 0;
		int sum_product = 0;
		double u1=0;
		double u2=0;
		int count1=0;
		int count2=0;
		for(int i=0;i<num;i++){
			  if(a.get(i)!=0){
				    count1++;
				    u1+=a.get(i);
			  }
		}
		u1=u1/count1;
		for(int j=0;j<num;j++) {
		    if(b.get(j)!=0){
			    count2++;
			    u2+=b.get(j);
	        }
		}
		u2=u2/count2;
		
		for (int i = 0; i < num; i++) {
			if(a.get(i)!=0&&b.get(i)!=0){
			    sum_squareOne += Math.pow((a.get(i)-u1), 2);
		
			    sum_squareTwo += Math.pow((b.get(i)-u2), 2);
			}
		}
	//	double sum = num * sum_product - sum_prefOne * sum_prefTwo;
	//	double den = Math.sqrt((num * sum_squareOne - Math.pow(sum_squareOne, 2)) * (num * sum_squareTwo - Math.pow(sum_squareTwo, 2)));
		double sum=0;
		double result;
		for (int i = 0; i < num; i++) {
			if(a.get(i)!=0&&b.get(i)!=0)
			    sum +=(a.get(i)-u1)*(b.get(i)-u2);
		} 
		double den = Math.sqrt(sum_squareOne*sum_squareTwo); 
		if(den==0) result=0;
		
		else result = sum / den;
		return result;
		
	}

}
