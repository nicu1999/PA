import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Gard {
	public static final String INPUT_FILE = "gard.in";
	public static final String OUTPUT_FILE = "gard.out";

	class GardPart implements Comparable<GardPart> {
		int x;
		int y;

		public GardPart(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(GardPart o) {
			return this.x - o.x;
		}
	}

	int nr;

	private ArrayList<GardPart> readInput() {
		try {
			int x, y;
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			String data = br.readLine();
			nr = Integer.parseInt(data);
			ArrayList<GardPart> gard = new ArrayList<>();
			for (int i = 0; i < nr; i++) {
				data = br.readLine();
				StringTokenizer st = new StringTokenizer(data);
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				gard.add(new GardPart(x, y));
			}
			br.close();
			return gard;
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

	private int compute_solution(ArrayList<GardPart> gard) {
		int res = 0;
		Collections.sort(gard);
		GardPart max = gard.get(0);
		for (int i = 1; i < gard.size(); i++) {
			GardPart aux;
			aux = gard.get(i);
			if (aux.x == max.x) {
				if (aux.y <= max.y) {
					res++;
				}
				else {
					max = aux;
					res++;
				}
			} 
			else {
				if (aux.y <= max.y) {
					res++;
				}
				else {
					max = aux;
				}
			}
		}
		return res;
	}

	public void solve() {
		writeOutput(compute_solution(readInput()));
	}

	public static void main(String[] args) {
		new Gard().solve();
	}
}
