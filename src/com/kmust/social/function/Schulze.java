package com.kmust.social.function;


public class Schulze {
	
	public static String schulze(int m,int n,double c[][]){

		StringBuffer sb = new StringBuffer();

		int i,j,k;
		int n1=n+2;
		int defeat[][]=new int[n][n];
		int common[][]=new int[n][n];
		int df[]=new int[n];
		for(k=0;k<n;k++)
			for(j=k+1;j<n;j++){
				for(i=0;i<m;i++){
					if(c[i][k]!=0&&c[i][j]!=0&&c[i][k]!=c[i][j])
					{
						common[k][j]++;
					    common[j][k]++;}
				}
			}
		
		for(k=0;k<n;k++)
			for(j=k+1;j<n;j++){
				for(i=0;i<m;i++){
					if(c[i][k]!=0&&c[i][j]!=0)
					{
						if(c[i][k]>c[i][j])
						     defeat[k][j]++;
					}
					else continue;
				}
		        defeat[j][k]=common[k][j]-defeat[k][j];
			}	
		int[][] strengths = MakePathStrengths(defeat,n);
		 for( i=0;i<4;i++){
	    	   for( j=0;j<4;j++){
				   System.out.print(strengths[i][j]+"  ");
				   sb.append(strengths[i][j]+"  ");
			   }
	    		System.out.println();
			 sb.append("<br/>");

		 }
		Boolean[] winners = MakeWinners(strengths,n);
		System.out.println("== Best option(s) is:");
		sb.append("== Best option(s) is:"+"<br/>");
		for ( i = 0; i < winners.length; ++i)
		{

			
			if (winners[i] == true)
			{
				System.out.println(i);
				sb.append(i+"<br/>");
			}

		}
		int df1[]= jifen(df,strengths,n);
		print(df1,n,defeat,sb);
	//	condorcet(df1,defeat,n,m);
		return sb.toString();
	
}

	    public static int[][] MakePathStrengths(int[][] defeats,int n)
     	{
		// TODO Auto-generated method stub
		//  MakePathStrengths
	    	int[][] result = new int[n+2][n+2];
		    for (int i = 0; i < n; ++i)
		    {
			    for (int j = 0; j < n; ++j)
			    {
				    if (defeats[i][j] > defeats[j][i])
				    {
					     result[i][j] = defeats[i][j];
				    } else
					result[i][j] = 0;
			}
		}
	


		for (int k = 0; k <n; ++k)
		{
			for (int i = 0; i < n; ++i)
			{
				if (k == i)
					continue;
				for (int j = 0; j < n; ++j)
				{
					if (k == j || i == j)
						continue;
					result[i][j] = Math.max(result[i][j],
							Math.min(result[i][k], result[k][j]));
				} // j
			} // i
		} // k

		return result;
	}
      public static int[] jifen(int df[],int strengths[][],int n){
	      for (int i = 0; i <n ; i++){
		       int p = 0;
		       for (int j = 0; j < n; j++){
			       if(strengths[i][j]!=0||strengths[j][i]!=0)
			           if (strengths[i][j] > strengths[j][i])
				              p++;
		        }
		       df[i] = p;
	      }
	      return df;
	     	
	}
	

	static Boolean[] MakeWinners(int[][] ps,int n)
	{
		Boolean[] result = new Boolean[n];

		for (int i = 0; i < n; ++i)
			result[i] = true;

		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
				if (ps[i][j] < ps[j][i])
					result[i] = false;
		}
		return result;
	}
	  public static int[] print(int[] df,int n,int defeat[][],StringBuffer sb){
		 int tf=0;
		 int ts=0;
		 int[] Index=new int[n];
		 int j;
		 for(int i=0;i<n;i++)
		 {
		
			 Index[i]=i;
		 }
		    for(int i=1;i<n;i++)
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
		    
		    for(int i=0;i<n;i++)
		    {
		    	System.out.println(df[i]+"  "+Index[i]);
				sb.append(df[i]+"  "+Index[i]+"<br/>");
		    }
	/*	    double k=0; 
		    double t=0;
			 for(int i=0;i<n;i++)
					for(j=0;j<n;j++)
						if(defeat[Index[i]][Index[j]]<defeat[Index[j]][Index[i]]&&df[i]>df[j]){
							k++;
							System.out.println(defeat[Index[i]][Index[j]]+"   "+defeat[Index[j]][Index[i]]+"  "+df[i]+"  "+df[j]+"  "+Index[i]+"  "+Index[j]);
						}
			 for(int i=0;i<n;i++)
					for(j=0;j<n;j++)
						if(defeat[i][j]==0&&defeat[j][i]==0&&i!=j){
							t++;
						}
			 System.out.println(k);
			 System.out.println(t);
			 System.out.println(k/(827*413-t/2));*/
		    return df;
	}
	  public static void condorcet(int df[],int defeats[][],int n,int m,StringBuffer sb){
	    	for(int i=0;i<n;i++){
	    		for(int j=0;j<n;j++){
	    			if(i==j)
	    				continue;
	    			if(defeats[i][j]<(m+1)/2)
	    				break;
	                if(j==n-1){
						System.out.println(i);
						sb.append(i+"<br/>");
					}
	    		}
	    	}
	    }

	public static void pareto(int df[],int defeats[][],int n,StringBuffer sb){
		int iindex[]=new int[n*n];
		int jindex[]=new int[n*n];
		int k=0,count1=0,count2=0;
		for(int i=1;i<n;i++)
			for(int j=i;j<n;j++)
				if(defeats[i][j]!=0&&defeats[j][i]==0){
					iindex[k++]=i;
					jindex[k++]=j;
				}
		if(k==0){
			System.out.println("00000");
			sb.append("00000"+"<br/>");
		}

		for(int i=0;i<k;i++){
	//		if(iindex[i]==0||jindex[i]==0)
		//		continue;
			if(df[iindex[i]]>=df[jindex[i]]){
				System.out.println(true);
				System.out.println(iindex[i]+"  "+jindex[i]);
				System.out.println(df[iindex[i]]+"  "+df[jindex[i]]);
				sb.append(true+"<br/>");
				sb.append(iindex[i]+"  "+jindex[i]+"<br/>");
				sb.append(df[iindex[i]]+"  "+df[jindex[i]]+"<br/>");
				count1++;
			}
			else{
				System.out.println(false);
				System.out.println(iindex[i]+"  "+jindex[i]);
				System.out.println(df[iindex[i]]+"  "+df[jindex[i]]);
				sb.append(false+"<br/>");
				sb.append(iindex[i]+"  "+jindex[i]+"<br/>");
				sb.append(df[iindex[i]]+"  "+df[jindex[i]]+"<br/>");
				count2++;
			}
		}
		System.out.println(k+"  "+count1+"  "+count2);
		sb.append(k+"  "+count1+"  "+count2+"<br/>");
	}
	public static void undictatorship(int df[],int defeats[][],int n,StringBuffer sb){
		int[][] result = new int[n][n];
		int iindex[]=new int[n];
		int jindex[]=new int[n];
		int k=0;
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				if (defeats[i][j] > defeats[j][i])
				{
					result[i][j] = defeats[i][j];
				} else
					result[i][j] = 0;
			}
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(result[i][j]==1){
					iindex[k++]=i;
					jindex[k++]=j;
				}
		if(k==0){
			System.out.println("00000");
			sb.append("00000"+"<br/>");
		}

		for(int i=0;i<k;i++){
			if(df[iindex[i]]>=df[jindex[i]]){
				System.out.println(true);
				System.out.println(iindex[i]+"  "+jindex[i]);
				System.out.println(df[iindex[i]]+"  "+df[jindex[i]]);
				sb.append(true+"<br/>");
				sb.append(iindex[i]+"  "+jindex[i]+"<br/>");
				sb.append(df[iindex[i]]+"  "+df[jindex[i]]+"<br/>");
			}
			else{
				System.out.println(false);
				sb.append(false+"<br/>");
			}
		}
		
	}


}

