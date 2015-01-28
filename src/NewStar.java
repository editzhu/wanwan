


public class NewStar {
	static final int MAXX=100;
	static final int MAXY=100;
	static int[][] maps= new int[100][100];
	static int[][] maps1= new int[100][100];
	static int[] tmpMap = new int[8];
	public static void iniMaps(){
		for (int i = 0;i<MAXX;i++)
			for (int j = 0 ;j<MAXY;j++){
				maps[i][j]=0;
			}
		maps[5][5]=1;
	}
	public static void iniTmpMap(){
		for (int i =0 ;i<8;i++)
			tmpMap[i]=0;
	}
	public static boolean check(int i,int j){
		int total = 0;
		iniTmpMap();
		tmpMap[0]=maps[i-1][j-1];
		tmpMap[1]=maps[i-1][j];
		tmpMap[2]=maps[i-1][j+1];
		tmpMap[3]=maps[i][j-1];
		tmpMap[4]=maps[i][j+1];
		tmpMap[5]=maps[i+1][j-1];
		tmpMap[6]=maps[i+1][j];
		tmpMap[7]=maps[i+1][j+1];
		for(int k = 0 ;k<8;k++)
			total += tmpMap[k];
//		System.out.println("("+i+","+j+")="+total);
		if (total>0&&total<3)
			return true;
		else 
			return false;
	}
	public static void choose1(int i ,int j,boolean b){
		if(b)maps1[i][j]=1;
		else maps1[i][j]=0;
	}
	public static void choose(int i ,int j){
		 int[] set = new int [8];
		 int k = 0;
		 for(int l=0;l<8;l++)
			 if (tmpMap[l]==0)
				 set[k++]=l;
//		 System.out.println(i+":"+j+":ÓÐN¸ö:"+k);
		 int c = (int)(Math.random()*k);
//		 System.out.println("c:"+c);
			if(c==0)maps[i-1][j-1]=1;
			else if(c==1)maps1[i-1][j]=1;
			else if(c==2)maps1[i-1][j+1]=1;
			else if(c==3)maps1[i][j-1]=1;
			else if(c==4)maps1[i][j+1]=1;
			else if(c==5)maps1[i+1][j-1]=1;
			else if(c==6)maps1[i+1][j]=1;
			else if(c==7)maps1[i+1][j+1]=1;
				 
	}
	public static void begin(){
		for (int i = 1;i<MAXX-1;i++)
			for (int j = 1 ;j<MAXY-1;j++){
					choose1(i,j,check(i,j));
			}		
}
	public static void copy(){
		for (int i = 0;i<MAXX;i++)
			for (int j = 0 ;j<MAXY;j++){
				maps[i][j]=maps1[i][j];
			}	

}
	public static String get(){
		String s="";
		for (int i=0;i<MAXX;i++)
			for (int j=0;j<MAXY;j++)
				s=s+(int)(Math.random()*2);
		return s;
	}
	public static String get1(String str){
		if(!str.equals("null")){
			for (int i=0;i<str.length();i++){
				maps[(int)(i/100)][i-(int)(i/100)*100]=Integer.parseInt(str.substring(i,i+1));
			}
		}
		iniMaps();
		iniTmpMap();
		String s ="";
//		for(int k=0;k<100;k++){

			
			int total = 0;
			for (int i=0;i<MAXX;i++){
				for (int j=0;j<MAXY;j++){
					total+=maps[i][j];
					s=s+maps[i][j];
					if(maps[i][j]==0)System.out.print("0");
					else System.out.print("*");
				}
				System.out.println();
			}
			System.out.println("TOTAL =:"+total);
			
			begin();
			copy();
//		}
		System.out.println(s.length());
		return s;
	}
	
}

