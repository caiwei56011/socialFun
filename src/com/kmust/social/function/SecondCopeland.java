package com.kmust.social.function;

public class SecondCopeland {
	public static void secondcopeland(int m,int n,double c[][]){
		int i,j,k;
		int defeat[][]=new int[n][n];
		int common[][]=new int[n][n];
		int df[]=new int[n];
		for(k=0;k<n;k++)
			for(j=k+1;j<n;j++){
				for(i=0;i<m;i++){
					if(c[i][k]!=0&&c[i][j]!=0&&c[i][k]==c[i][j])
					{common[k][j]++;
					common[j][k]++;}
				}
			}
		for(k=0;k<n;k++)
			for(j=k+1;j<n;j++){
				for(i=0;i<m;i++){
					if(c[i][k]!=0&&c[i][j]!=0)
						{if(c[i][k]>c[i][j])
						defeat[k][j]++;}
					else continue;
				}
		        defeat[j][k]=common[k][j]-defeat[k][j];
			}
	

	
		for(i=0;i<n;i++){
			for(j=i+1;j<n;j++)
				if(defeat[i][j]>defeat[j][i]){
					df[i]++;
	
				}
				
			
		}
		int tf=0;
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
