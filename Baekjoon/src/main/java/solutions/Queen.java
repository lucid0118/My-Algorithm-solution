package solutions;

/**
 * Created by ohdonggeon on 2020/04/01 8:57 PM
 * Dankook UNIV. Computer Science
 * Source : https://www.acmicpc.net/problem/9663
 * Desc : N X N 의 체스판에서 퀸 N개를 서로 공격 할 수 없게 놓는 경우의 수를 출력한다.
 * Input : N (1 <= N < 15)
 * Output : 서로 공격 할 수 없는 Queen 의 모든 경우의 수
 */
public class Queen {

	private static final double VERTICAL = 0;
	private static final double DIAGONAL = 1;

	// element : row에 대해 queen이 위치한 col
	private static int[] chessboard;
	private static int length = 0;

	private static int answer = 0;

	private Queen() {

	}

	public static int getAnswer(int numQueen) {
		chessboard = new int[numQueen];
		length = numQueen;
		answer = 0;

		getNumberOfCases(0);

		return answer;
	}

	private static void getNumberOfCases(int row) {
		if (row == length) {
			answer++;
			return;
		}

		for (int col = 0; col < length; col++) {
			if (isValidate(row, col)) {
				chessboard[row] = col;
				getNumberOfCases(row + 1);
			}
		}
	}

	private static boolean isValidate(int row, int col) {
		for (int boardRow = 0; boardRow < row; boardRow++) {
			//직선의 기울기 (y2 - y1) / (x2 - x1)
			double value = Math.abs(getSlopeOfTwoPoints(col, chessboard[boardRow], row, boardRow));

			if (value == VERTICAL || value == DIAGONAL) {
				return false;
			}
		}

		return true;
	}

	private static double getSlopeOfTwoPoints(int col, int boardCol, int row, int boardRow) {
		return (double) (col - boardCol) / (row - boardRow);
	}
}