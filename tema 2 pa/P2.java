import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class P2 {
	static class Task {
		public class Pair
		{
			int to;
			int dist;
			Pair(int to, int dist)
			{
				this.to = to;
				this.dist = dist;
			}
		}
		public class MyScanner {
			BufferedReader br;
			StringTokenizer st;

			public MyScanner() {
				try {
					File file = new File("p2.in");
					br = new BufferedReader(new FileReader(file));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}

			String next() {
				while (st == null || !st.hasMoreElements()) {
					try {
						st = new StringTokenizer(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return st.nextToken();
			}

			int nextInt() {
				return Integer.parseInt(next());
			}

			long nextLong() {
				return Long.parseLong(next());
			}

			double nextDouble() {
				return Double.parseDouble(next());
			}

			String nextLine() {
				String str = "";
				try {
					str = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return str;
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<Pair>[] drum = new ArrayList[100005];
		int[] distance;
		boolean[] visited;
		boolean[] onpath;
		int temp[];
		int n, m , src, dst;
		public Task() {
			n = 0;
			m = 0;
		}

		public void readInput() {
			MyScanner s = new MyScanner();

			n = s.nextInt();
			m = s.nextInt();
			distance = new int[n+1];
			for (int i = 1; i <= n; ++i) {
				drum[i] = new ArrayList<>();
				distance[i] = 10000005;
			}
			src = s.nextInt();
			dst = s.nextInt();
			for (int i = 1; i <= m; ++i) {
				int f;
				int t;
				int c;
				f = s.nextInt();
				t = s.nextInt();
				c = s.nextInt();
				drum[f].add(new Pair(t, c));
			}
		}

		private void writeOutput(int distance2) {
			try {
				PrintWriter pw = new PrintWriter(new File("p2.out"));
				pw.printf("%d\n", distance2);
				pw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		boolean dfs(int n)
		{
			if(n == dst || temp[n] == 2)
			{
				return true; 
			}
			temp[n] = 1;
			for(Pair p : drum[n])
			{
				if(temp[p.to] != 1)
				{
					if(dfs(p.to) == true)
					{
						if(distance[p.to] + p.dist < distance[n])
						{
							distance[n] = distance[p.to] + p.dist;
						}
						temp[n] = 2;
					}
				}
			}
			return (temp[n] == 2);
		}
		
		public void solve() 
		{
			readInput();
			temp = new int[n+1];
			distance[dst] = 0;
			dfs(src);
			writeOutput(distance[src]);
		}
	}


	public static void main(String[] args) {
		new Task().solve();
	}
}
