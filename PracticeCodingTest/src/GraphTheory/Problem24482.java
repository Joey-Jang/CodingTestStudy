package GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24482 {
    private static int vertexCnt;
    private static int edgeCnt;
    private static int startVertex;
    private static boolean[] visited;
    private static int[] depths;
    private static List<List<Integer>> edges = new ArrayList<List<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        for (int i=0; i<=vertexCnt; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new boolean[vertexCnt+1];
        depths = new int[vertexCnt+1];
        Arrays.fill(depths, -1);

        for (int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        // 내림차순 정렬
        for (int i=1; i<=vertexCnt; i++) {
            Collections.sort(edges.get(i), Collections.reverseOrder());
        }

        dfs(0, startVertex);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=vertexCnt; i++) {
            sb.append(depths[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int r) {
        visited[r] = true;
        depths[r] = depth;

        for (int i=0; i<edges.get(r).size(); i++) {
            int nextVertex = edges.get(r).get(i);
            if (visited[nextVertex]) continue;
            dfs(depth + 1, nextVertex);
        }
    }
}
