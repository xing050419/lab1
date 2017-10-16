package helloworld;

import java.io .*;
import java.util.*;
public class practice
{
	int a,b,x,y;
	static void queryBridgeWords(String word1, String word2,int map[][],String str2[],int m)
	{
		int i,j;
		//lajiwangdao
		//wrwr
		int a=-1,b=-1;

		for(i=0;i<m;i++)
		{
			if(word1.equals(str2[i]))
			{
				a=i;
			}
		}
		for(i=0;i<m;i++)
		{
			if(word2.equals(str2[i]))
			{
				b=i;
			}
		}
		if(a==-1||b==-1)
		{
			System.out.println("error!");
		}
		else
		{if(a!=0)
		for(i=0;i<m;i++)
		{
			if(map[a][i]==1)
			{
				if(map[i][b]!=0)
				{
					System.out.println(str2[i]);
				}
				else
				{
					System.out.println("null");

				}
			}

		}}
	}
	static void calcShortestPath(String word1, String word2,int map[][],String str2[],int m)
	{
		int i,j;
		int mappath[][]= new int[m][m];
		int a=0,b=0;
		for(i=0;i<m;i++)
		{
			if(word1.equals(str2[i]))
			{
				a=i;
			}
		}
		for(i=0;i<m;i++)
		{
			if(word2.equals(str2[i]))
			{
				b=i;
			}
		}
		System.out.println(str2[a]+" "+str2[b]);
		int A[][]=map;
		for(i=0;i<m;i++)
		    for(j=0;j<m;j++)
		    {
		    	A[i][j]=map[i][j];
		        mappath[i][j]=-1;
		     }
		int k;
		for(k=0;k<m;k++)
		 {
		     for(i=0;i<m;i++)
		         for(j=0;j<m;j++) {
		        	 System.out.print(A[i][k]+" "+A[k][j]+"!");
		            if((A[i][j]>(A[i][k]+A[k][j])||A[i][j]==0)&&A[i][k]!=0&&A[k][j]!=0)
		          //  	&&A[i][k]!=0&&A[k][j]!=0
		             {System.out.print("****");
		                   A[i][j]=A[i][k]+A[k][j];
		                   mappath[i][j]=k;
		             } }
		}
		for(i=0;i<m;i++) {
	         for(j=0;j<m;j++)System.out.print(A[i][j]+" ");
	         System.out.println(""); }
		System.out.println(A[a][b]);
		System.out.print(str2[a]);
		pat(mappath,a,b,str2);



	}
	static void pat(int mappath[][],int a,int b,String str2[]) {
		if(a==b) {
			return;
		}
		if(mappath[a][b]==-1) System.out.print("->"+str2[b]);
		else {
			pat(mappath,a,mappath[a][b],str2);
			pat(mappath,mappath[a][b],b,str2);


		}

	}



	static void randomWalk(String word11,int map[][],int m,String str2[],int map2[][])
	{
		Scanner cin=new Scanner(System.in);
		int i,j,x=(int)(Math.random()*m),jj,f=0;
		for(i=0;i<m;i++)
		{
			if(str2[i].equals(word11))
			{
				for(j=0;j<m;j++) {
					jj=j+x;
					if(jj>=m)jj-=m;
					if(map[i][jj]!=0) {
						f=1;
					System.out.println(str2[jj]);
					if(map2[i][jj]==1) {
						System.out.println("cfl");
						break;
					}
					map2[i][jj]=1;
					System.out.println("输入8继续，其他退出");
					int number=0;
					number=cin.nextInt();
					int p=8;
					if(number==8)
					{
						randomWalk(str2[jj],map,m,str2,map2);
						break;
					}
					else break;
					}

				}if(f==0)System.out.println("SL");
			}
		}
	}
	public static void main(String[] args)throws IOException
	{
		Scanner cin=new Scanner(System.in);
		InputStreamReader reader = null;
		try
		{
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            String result="";
            reader = new InputStreamReader(new FileInputStream("D:/x/newx.txt"));
            // 读入多个字符到字符数组中，charread为一次读取字符数

            String []str1;//装载字符
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            int i,j;
            while((s=br.readLine())!=null)
            {
            	result = result  + s;
            }
            System.out.println(result);

            str1=result.toLowerCase().split("[^a-z]+");//^a-z匹配a~z +很多个a~z



    		TreeSet<String> tr = new TreeSet<String>();
    		 for(i=0;i<str1.length;i++){
    			 tr.add(str1[i]);

    			 }
    		String []str2=new String[str1.length];
    		 for( i=0;i<str2.length;i++){
    			 str2[i]=tr.pollFirst();
    			 if(str2[i]==null)break;}

    		int m=i;
    		for(i=0;i<m;i++)
    		{System.out.println(str2[i]);}
    		System.out.println("");
    		//
    		int [][]map= new int[m][m];
    		int mi=-1,mj;
    	    for(i=0;i<str1.length;i++) {
    	    for(j=0;j<m;j++) {if(str1[i].equals(str2[j])) {
    	    	if(mi!=-1)map[mi][j]++;mi=j;}
    	    }
    	    }
    	    int [][]map2=new int[m][m];
    		for(i=0;i<m;i++)
    		{
    			for(j=0;j<m;j++)
    			{
    				System.out.print(map[i][j]);
    				map2[i][j]=0;
    			}

    			System.out.println("");
    		}
    		System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
    		int num=-1;
    		num=cin.nextInt();
    		cin.nextLine();
    		while(num!=0)
    		{if(num<0||num>5)
    		{System.out.print("input error");
    		System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
    		num=cin.nextInt();
    		}
    		if(num==0)
    		{
    			break;
    		}
    		if(num==1)
    		//最短路径
    		{
    			System.out.println("Please input two words:");
    		String word1="",word2="";
    		word1=cin.next();word2=cin.next();
    		calcShortestPath(word1,word2,map,str2,m);
    		System.out.println("\ninput number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
    		num=cin.nextInt();
    		}
    		//桥接词查询
    		if(num==2)
    			System.out.println("Please input two words:");
    		{String word3="",word4="";
    		word3=cin.next();word4=cin.next();
    		queryBridgeWords(word3,word4,map,str2,m);
    		System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
    		num=cin.nextInt();}
    		//输入桥接词查询
    		if(num==3)
    		{
    			System.out.println("Please input a word:");
    		String word5="";
    		Scanner cin3=new Scanner(System.in);
    		word5=cin3.nextLine();
    		String word6[];
    		word6=word5.toLowerCase().split("[^a-z]+");
   		  	for(i=0;i<word6.length-2;i++)
   		  	{
   		  		System.out.print(word6[i]);
   		  		queryBridgeWords(word6[i],word6[i+1],map,str2,m);

   		  	}
   		  	System.out.println(word6[word6.length-2]);
   		  	System.out.println(word6[word6.length-1]);
   		  	System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
   		  	num=cin.nextInt();
    		}
    		//随机游走
    		if(num==4)
    		{
    			for(i=0;i<m;i++)
    			{
    				for(j=0;j<m;j++)
    				{
    					map2[i][j]=0;
    				}
    			}
    			String word11="";
    			word11=cin.next();

    			randomWalk(word11,map,m,str2,map2);
    			System.out.println("End!");
    			System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
        		num=cin.nextInt();
    		}
    		//输出图
    		if(num==5)
    		{
    			File file = new File("d:\\array.dot");  //存放数组数据的文件
    			FileWriter out = new FileWriter(file);  //文件写入流
    			out.write("digraph array {"+"\t");
    			for(i=0;i<m;i++)
    			{
    			   for(j=0;j<m;j++)
    			   {
    				   if(map[i][j]!=0)
    				   {//label="100 times"
    					   out.write(str2[i]+"->"+str2[j]+"["+"label="+map[i][j]+"]"+";\t");
    				   }
    				   else
    				   {
    					   continue;
    				   }

    			   }

    			   out.write("\r\n");
    			 }
    			out.write("}"+"\t");
    			out.close();
    			String path = "D:\\array.dot";
    			String path2 = "D:\\array.png";
    			Runtime run = Runtime.getRuntime();
    			        try {
    			            // run.exec("cmd /k shutdown -s -t 3600");
    			            Process process = run.exec("dot "+path+" -Tpng -o "+path2);
    			            //System.out.println("["+path+"]["+path2+"]");
    			            InputStream in = process.getInputStream();
    			            while (in.read() != -1) {
    			                System.out.println(in.read());
    			            }
    			            in.close();
    			            process.waitFor();
    			        } catch (Exception e)
    			        {
    			            e.printStackTrace();
    			        }
    			        System.out.println("input number:\n0.exit\n1.最短路径\n2.桥接词查询\n3.输入桥接词查询\n4.随机游走\n5.输出图");
    		    		num=cin.nextInt();
    		}
    		}

		}
		catch (Exception e)
		{
            e.printStackTrace();
        }
		cin.close();
	}
}
