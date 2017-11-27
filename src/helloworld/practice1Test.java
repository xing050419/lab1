package helloworld;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;
public class practice1Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalcShortestPath() throws IOException{
		Scanner cin = new Scanner(System.in);
		InputStreamReader reader = null;
		try {
			String result = "";
			reader = new InputStreamReader(new FileInputStream("new.txt"));
			String[] str1;// 装载字符
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			int i, j;
			while ((s = br.readLine()) != null) {
				result = result + s;
			}

			str1 = result.toLowerCase().split("[^a-z]+");// ^a-z匹配a~z +很多个a~z

			TreeSet<String> tr = new TreeSet<String>();
			for (i = 0; i < str1.length; i++) {
				tr.add(str1[i]);

			}
			String[]str2 = new String[str1.length];
			for (i = 0; i < str2.length; i++) {
				str2[i] = tr.pollFirst();
				if (str2[i] == null)
					break;
			}

			int m = i;
			//
			int[][] map = new int[m][m];
			int mi = -1;
			for (i = 0; i < str1.length; i++) {
				for (j = 0; j < m; j++) {
					if (str1[i].equals(str2[j])) {
						if (mi != -1)
							map[mi][j]++;
						mi = j;
					}
				}
			}
		int num=practice.calcShortestPath("how", "how",map, str2,m);
		assertEquals(-1, num);
		//fail("Not yet implemented");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}