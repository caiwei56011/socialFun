package com.kmust.social.function;

public class Borda implements Base {
	public static void borda(int m,int n,double c[][]){
		int k=0,i=0,j=0;
		double[][] temp=new double[m][n];
		double[] df=new double[n];
		temp=c;
		for(k=0;k<n;k++){
			df[k]=0;
			for(j=0;j<n;j++)
				for(i=0;i<m;i++)
					if(temp[i][k]>c[i][j])
						df[k]++;
		}
	/*	for(i=0;i<n;i++){
			System.out.println(df[i]);
	}*/
		 double tf=0;
		 int ts=0;
		 int[] Index=new int[n];
		 for( i=0;i<n;i++)
		 {
		
			 Index[i]=i;
		 }
		    for(i=1;i<n;i++)
			{  
		         tf=df[i];
				 ts=Index[i];
				 j=i-1;
				 while(j>=0&&df[j]>tf)
				 {
					 df[j+1]=df[j];
					 Index[j+1]=Index[j];
					 j--;
				 }
				 df[j+1]=tf;
				 Index[j+1]=ts;
			}
		    
		    for(i=0;i<n;i++)
		    {
		    	System.out.println(df[i]+"  "+Index[i]);
		    }
	}

	
	
}

