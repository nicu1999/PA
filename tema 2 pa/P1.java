import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1 {
	static class Task {
		//am folosit MyScanner pentru a optimiza
		//timpul, aparent nu e necesar :^)
		public class MyScanner {
			BufferedReader br;
			StringTokenizer st;

			public MyScanner() {
				try {
					File file = new File("p1.in");
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

		int n, m, k;
		@SuppressWarnings("unchecked")
		Set<Integer>[] adj = new HashSet[100005];;
		int[] lords;
		int[] permutation;
		Stack<Integer> stk = new Stack<Integer>();

		public Task() {
			n = 0;
			m = 0;
		}

		private void readInput() {
			MyScanner s = new MyScanner();

			n = s.nextInt();
			m = s.nextInt();
			k = s.nextInt();
			lords = new int[k];
			permutation = new int[n - 1];

			for (int i = 0; i < k; ++i) {
				lords[i] = s.nextInt();
			}
			for (int i = 0; i < n - 1; ++i) {

				permutation[i] = s.nextInt();
			}

			for (int i = 1; i <= n; ++i) {
				adj[i] = new HashSet<>();
			}

			for (int i = 1; i <= m; ++i) {
				int f;
				int t;
				f = s.nextInt();
				t = s.nextInt();
				adj[f].add(t);
				adj[t].add(f);
			}
		}

		private void writeOutput(int result) {
			try {
				PrintWriter pw = new PrintWriter(new File("p1.out"));
				pw.printf("%d\n", result);
				pw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		//DFS din primul nod, se cauta valorile 2 in state, ce reprezinta
		//lorzii, este adevarat doar daca drumurile sunt blocate (in state)
		//sunt notate cu 1 sau daca au fost vizitate (am folosit) acelasi
		//numar pt ambele
		private Boolean robinOk(int node, int[] state) {
			while (!stk.empty()) {
				stk.pop();
			}
			stk.add(node);
			while (!stk.empty()) {
				int current = stk.pop();
				if (state[current] == 2) {
					return false;
				}
				state[current] = 1;
				for (int n : adj[current]) {
					if (state[n] != 1) {
						stk.add(n);
					}
				}
			}
			return true;
		}

		int[] initialize(int m) {
			int[] nw = new int[n + 1];
			for (int i = 0; i < k; ++i) {
				nw[lords[i]] = 2;
			}
			for (int i = 0; i < m; ++i) {
				nw[permutation[i]] = 1;
			}
			return nw;
		}
		int mid(int l,int  r) 
		{
			return (l + r) / 2;
		}
		//se foloseste de binary serch pentru a gasi punctul
		//in care permutarile opresc in totalitate a lorzii
		//intr-un nr minim de sarituri
		public void solve() {
			int l, r;
			readInput();
			l = 0;
			r = n - 1;
			while (r > l) {
				mid(l, r);
				if (robinOk(1, initialize(mid(l, r)))) 
				{
					r = mid(l, r);
				} else {
					l = mid(l, r) + 1;
				}
			}
			writeOutput(l);
		}
	}

	public static void main(String[] args) {
		new Task().solve();
	}
}