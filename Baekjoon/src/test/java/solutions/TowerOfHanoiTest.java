package solutions;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by donggeon on 2020/03/06
 * Dankook UNIV. Computer Science
 * Source :
 * Desc :
 */
public class TowerOfHanoiTest {

	@Test
	public void solution() {
		try {
			Scanner sc = new Scanner(new File("/Users/ohdonggeon/Sources/Algorithm/Baekjoon/src/test/java/testcases/Input11729.txt"));
			for(int testcases = 0; testcases < 3; testcases++) {
				int input = sc.nextInt();
				TowerOfHanoi solution = new TowerOfHanoi(input);
				solution.printAnswerByStack();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}