import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Bomboane {
	public static final String INPUT_FILE = "bomboane.in";
	public static final String OUTPUT_FILE = "bomboane.out";

	class Interval {
		int x;
		int y;

		public Interval(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}
	}

	int nr;

	int getRange(int x, int y) {
		int range = 0;
		if (x < 0) {
			range = (-x) + y + 1;
		} else {
			range = y - x + 1;
		}
		return range;
	}

	private int readInput() {
		try {
			int x, y, nr, total, range;
			ArrayList<ArrayList<Integer>> dp;
			ArrayList<Integer> r;
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			String data = br.readLine();
			StringTokenizer st = new StringTokenizer(data);
			nr = Integer.parseInt(st.nextToken());
			total = Integer.parseInt(st.nextToken());
			ArrayList<Interval> bomboane = new ArrayList<>(nr);
			dp = new ArrayList<ArrayList<Integer>>(nr);
			r = new ArrayList<Integer>(nr);
			data = br.readLine();
			st = new StringTokenizer(data);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			bomboane.add(new Interval(total - y, total - x));
			dp.add(new ArrayList<Integer>(y - x + 1));
			r.add(y - x + 1);
			for (int i = 0; i < y - x + 1; i++) {
				dp.get(0).add(1);
			}
			for (int j = 1; j < nr; j++) {
				data = br.readLine();
				st = new StringTokenizer(data);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r.add(y - x + 1);
				bomboane.add(new Interval(bomboane.get(j - 1).x - y, bomboane.get(j - 1).y - x));
				range = getRange(bomboane.get(j).x, bomboane.get(j).y);
				dp.add(new ArrayList<Integer>(range));

				int offset = range - dp.get(j - 1).size();
				int cursor = 0;
				int aparitii;
				while (cursor < dp.get(j - 1).size() + offset) {
					aparitii = 0;
					for (int i = cursor; i >= cursor - offset; i--) {
						if (i < 0 || i >= dp.get(j - 1).size()) {
							aparitii += 0;
						} else {
							aparitii %= 1000000007;
							aparitii += dp.get(j - 1).get(i);
						}
					}
					dp.get(j).add(aparitii % 1000000007);
					cursor++;
				}
			}
			br.close();
			x = bomboane.get(nr - 1).x;
			y = bomboane.get(nr - 1).y;
			range = getRange(x, y);
			for (int g = 0; g < range; g++) {
				if (x == 0) {
					return dp.get(nr - 1).get(g);
				}
				x++;
			}
			return 0;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeOutput(int res) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE)));
			pw.write(Integer.toString(res));
			pw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void solve() {
		writeOutput(readInput());
	}

	public static void main(String[] args) {
		new Bomboane().solve();
	}
}