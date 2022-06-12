package GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24484 {
    private static int N;
    private static int M;
    private static int R;
    private static long[] orders, depths;
    private static boolean[] visited;
    private static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        orders = new long[N + 1];
        depths = new long[N + 1];
        Arrays.fill(depths, -1);
        visited = new boolean[N + 1];
        edges = new ArrayList[N + 1];
        for (int i=1; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for (int i=1; i<=N; i++) {
            Collections.sort(edges[i], Collections.reverseOrder());
        }

        dfs(0, R);

        long result = 0;
        for (int i=1; i<=N; i++) {
            result += orders[i] * depths[i];
        }
        System.out.println(result);
    }

    public static void dfs(int depth, int r) {
        visited[r] = true;
        orders[r] = depth + 1;
        depths[r] = depth;

        for (int i=0; i<edges[r].size(); i++) {
            int nextVertex = edges[r].get(i);
            if (visited[nextVertex]) continue;
            dfs(depth + 1, nextVertex);
        }
    }
}
