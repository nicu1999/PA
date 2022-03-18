import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Bani {
	public static final String INPUT_FILE = "bani.in";
	public static final String OUTPUT_FILE = "bani.out";

	// TODO: define members
	int type;
	int n;

	private void readInput() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			String data = br.readLine();
			StringTokenizer st = new StringTokenizer(data);
			type = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			br.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeOutput(long sol) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE)));
			// TODO: print output
			pw.write(Long.toString(sol));
			pw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private long compute_solution() {
		long total = 0;
		ArrayList<ArrayList<Long>> m = new ArrayList<ArrayList<Long>>(5);
		for (int i = 0; i < 5; i++) {
			m.add(new ArrayList<Long>(n));
			m.get(i).add(1l);
			for (int j = 1; j < n; j++) {
				m.get(i).add(0l);
			}
		}
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < 5; i++) {
				if (i == 0) {
					m.get(i).set(j, m.get(1).get(j - 1) % 1000000007
							+ m.get(2).get(j - 1) % 1000000007);
				} else if (i == 1) {
					m.get(i).set(j, m.get(0).get(j - 1) % 1000000007
							+ m.get(3).get(j - 1) % 1000000007);
				} else if (i == 2) {
					m.get(i).set(j, m.get(0).get(j - 1) % 1000000007
							+ m.get(2).get(j - 1) % 1000000007);
				} else if (i == 3) {
					if (type == 1) {
						m.get(i).set(j, m.get(1).get(j - 1) % 1000000007
								+ m.get(4).get(j - 1) % 1000000007);
					} else {
						m.get(i).set(j, m.get(1).get(j - 1) % 1000000007
								+ m.get(4).get(j - 1) % 1000000007
								+ m.get(2).get(j - 1) % 1000000007);
					}
				} else if (i == 4) {
					m.get(i).set(j, m.get(3).get(j - 1) % 1000000007
							+ m.get(0).get(j - 1) % 1000000007);
				}
			}

		}

		for (int i = 0; i < 5; i++) {
			total += m.get(i).get(n - 1);
		}
		return total % 1000000007;
	}

	public void solve() {
		readInput();
		writeOutput(compute_solution());
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		new Bani().solve();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration / 1000000l);
	}
}
