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

public class P3 {
	static class Task {
		public class Pair
		{
			int to;
			double percentage;
			Pair(int to, double percentage)
			{
				this.to = to;
				this.percentage = percentage;
			}
		}
		public class Node implements Comparable<Node>
		{
			int nr;
			double value;
			Node(int nr, double value)
			{
				this.nr = nr;
				this.value = value;
			}
			public int compareTo(Node n)
			{
				return Double.compare(n.value, this.value);
			}
		}
		public class MyScanner {
			BufferedReader br;
			StringTokenizer st;

			public MyScanner() {
				try {
					File file = new File("p3.in");
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
		boolean[] visited;
		int[] parent;
		double[] energy_left;
		int n, m , e;
		public Task() {
			n = 0;
			m = 0;
			e = 0;	
		}

		public void readInput() {
			MyScanner s = new MyScanner();

			n = s.nextInt();
			m = s.nextInt();
			e = s.nextInt();
			visited = new boolean[n+1];
			energy_left = new double[n+1];
			parent = new int[n+1];
			for (int i = 1; i <= n; ++i) {
				drum[i] = new ArrayList<>();
				visited[i] = false;
				energy_left[i] = 0;
				parent[i] = 0;
			}
			for (int i = 1; i <= m; ++i) {
				int f;
				int t;
				double c;
				f = s.nextInt();
				t = s.nextInt();
				c = s.nextDouble();
				drum[f].add(new Pair(t, c));
			}
		}

		private void writeOutput(double result, ArrayList<Integer> path) {
			try {
				PrintWriter pw = new PrintWriter(new File("p3.out"));
				pw.printf("%.8f\n", result);
				int i;
				for(i = 0; i < path.size() - 1 ;i++)
				{
					pw.printf("%d ", path.get(i));
				}
				pw.printf("%d", path.get(i));
				pw.printf("\n");
				pw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		void dijkstra()
		{
			PriorityQueue<Node> q = new PriorityQueue();
			q.add(new Node(1, e));
			//visited[1] = true;
			energy_left[1] = e;
			while(!q.isEmpty())
			{
				Node node = q.poll();
				visited[node.nr] = true;
				for(Pair aux : drum[node.nr])
				{
					if(visited[aux.to] == false && 
					(energy_left[node.nr] - energy_left[node.nr]*(aux.percentage/100)  >  energy_left[aux.to]))
					{
						energy_left[aux.to] = energy_left[node.nr] - energy_left[node.nr]*(aux.percentage/100);
						parent[aux.to] = node.nr;
						q.add(new Node(aux.to, energy_left[aux.to]));
					}
				}
			}
			int prt = parent[n];
			ArrayList<Integer> path = new ArrayList<>();
			path.add(n);
			while(prt !=0)
			{
				path.add(prt);
				prt = parent[prt];
			}
			Collections.reverse(path);
			writeOutput(energy_left[n], path);
		}
		
		public void solve() 
		{
			readInput();
			dijkstra();
		}
	}


	public static void main(String[] args) {
		new Task().solve();
	}
}
