package com.kmust.social.function;


public class RankedPairs {

	public static void rankedpairs(int m,int n,double c[][]){
		int defeat[][]=new int[n][n];
		int common[][]=new int[n][n];
		int i,j,k;
		for(k=0;k<n;k++)
			for(j=k+1;j<n;j++){
				for(i=0;i<m;i++){
					if(c[i][k]!=0&&c[i][j]!=0&&c[i][k]!=c[i][j])
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
		int[][] result = new int[n][n];
		for ( i = 0; i < n; i++)
		{
			for ( j = 0; j < n; j++)
			{
				if (defeat[i][j] > defeat[j][i])
				{
					result[i][j] = defeat[i][j];
				} else
					result[i][j] = 0;
			}
		}
		int[] srcvalue = new int[n*n];
		int[] Iindex = new int[n*n];
		int[] Jindex = new int[n*n];
		for(i =0 ;i < result.length; i++)
		{
			for(j = 0 ; j < result[i].length ; j++)
			{
				if(result[i][j]==0)
					continue;
				else{
				Iindex[k] = i;
				Jindex[k] = j;
				srcvalue[k] = result[i][j];
				k++;
				}
			}
		}
		 System.out.println(k);
		
	 InsertSort_Arr(srcvalue,Iindex,Jindex,k);
	 System.out.println(k);
	 int count=0;
	 for( i =0 ;i<srcvalue.length;i++)
	 {
		 if(Iindex[i]==1652||Jindex[i]==1652){
		 System.out.println(Iindex[i]+" "+Jindex[i]+" "+srcvalue[i]);}
		 count++;
	 } System.out.println(count);
	//	TopK.topk(srcvalue);
	 
//	 int[] df=  rankedpair(srcvalue,Iindex,Jindex,n);
//	 for(i=0;i<df.length;i++){
//		 System.out.println(df[i]);
//	 }
//	 print(df,n);
	 int p=0;
/*	 for( i =0 ;i<k;i++)
	 {
		 if(p==1000){
			 break;
	 }
		 p++;

		// System.out.println(Iindex[i]+" "+Jindex[i]+" "+srcvalue[i]);
	 }*/
	 
	}
	
	public static int[] rankedpair(int[] srcvalue, int[] Iindex, int[] Jindex,int n) {
		// TODO Auto-generated method stub
		int[] score = new int[n];
		int j;
		Boolean[] result = new Boolean[2]; 
		int k=2,index,jindex=0;
		score[0] = Iindex[0];
		score[1] = Jindex[0];
		for(int i = 1;i<Iindex.length ; i++)
		{
			if(srcvalue[i]==0)
				continue;
			for( j=0;j<k;j++){
				if(Iindex[i]==score[j]){
					result[0]=true;
					index=j;
					break;
				}
			}
			if(j==k)
				result[0]=false;
			for( j=0;j<k;j++){
				 if(Jindex[i]==score[j]){
					result[1]=true;
					jindex=j;
					break;
				}
			}
			if(j==k)
				result[1]=false;

			if(result[0]==true&&result[1]==true)
				continue;
			else if(result[0]==false&&result[1]==false){
				score[k]=Iindex[i];k++;
				score[k]=Jindex[i];k++;
				continue;
			}
			else if(result[0]==true&&result[1]==false)
				{score[k]=Jindex[i];k++;continue;}
			else if(result[0]==false&&result[1]==true){
				for( j=k-1;j>=jindex;j--)
					score[j+1]=score[j];
				score[jindex]=Iindex[i];
				k++;
				continue;
			}
		}
		return score;
	}

	public static void InsertSort_Arr(int[] Arr,int[] Iindex,int[] Jindex,int k)
    {
		  for(int i=1;i<k;i++)
		  {
			  int j=i-1;
			  int current_Value=Arr[j+1];
			  int current_i = Iindex[j+1];
			  int current_j = Jindex[j+1];
			  while(j>=0&&current_Value>Arr[j])
			  {
				  Arr[j+1]=Arr[j];
				  Iindex[j+1] = Iindex[j];
				  Jindex[j+1] = Jindex[j];
				  j--;
			  }
			 Arr[j+1] = current_Value;
			 Iindex[j+1] = current_i;
			 Jindex[j+1]  =  current_j;
		  }
	  }
	public static void print(int df[],int n){
		int tf=0;
		 int ts=0;
		 int i,j;
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


