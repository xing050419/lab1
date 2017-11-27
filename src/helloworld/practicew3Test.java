package helloworld;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class practicew3Test {

	@Test
	public void testQueryBridgeWords() {
		String []str1 = new String[23];
		str1[0]="how";
		str1[1]="are";
		str1[2]="you";
		str1[3]="i";
		str1[4]="am";
		str1[5]="fine";
		str1[6]="thanks";
		str1[7]="ok";
		str1[8]="line";
		str1[9]="file";
		str1[10]="jack";
		str1[11]="mark";
		str1[12]="sad";
		str1[13]="root";
		str1[14]="z";
		str1[15]="i";
		str1[16]="am";
		str1[17]="fine";
		str1[18]="thanks";
		str1[19]="thanks";
		str1[20]="ok";
		str1[21]="line";
		str1[22]="file";
		int i,j;
		TreeSet<String> tr = new TreeSet<String>();
		for (i = 0; i < str1.length; i++) {
			tr.add(str1[i]);

		}
		String[] str2 = new String[str1.length];
		for (i = 0; i < str2.length; i++) {
			str2[i] = tr.pollFirst();
			if (str2[i] == null)
				break;
		}
		int m=i;
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
		String fds=practice.queryBridgeWords("line", "jack",map, str2,m);
		assertEquals("file", fds);

	}

}
