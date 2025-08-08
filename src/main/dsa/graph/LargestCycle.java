package main.dsa.graph;

import java.util.Arrays;

/*You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

*/
public class LargestCycle {
    public static int ans;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] len = new int[n];
        Arrays.fill(visited, false);
        Arrays.fill(len, 0);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(0, i, visited, edges, len);
            }
        }
        return ans;

    }

    void dfs(int currLen, int node, boolean[] visited, int[] edges, int[] len){
        currLen++;
        len[node]= currLen;
        visited[node]=true;
        int nbr =edges[node];
        if(nbr!=-1){
            if(!visited[nbr]){
                dfs(currLen, nbr, visited, edges, len);
            }else if(len[nbr]!=0){
                int temp = currLen - len[nbr] +1;
                ans = Math.max(ans, temp);
            }
        }
        len[node]=0;
    }
    public static void main(String[] args) {
        int[] edges1 = new int[]{3,3,4,2,3};
        int[] edges2 = new int[]{2,-1,3,1};
        LargestCycle obj = new LargestCycle();
        ans = -1;
        System.out.println(obj.longestCycle(edges1));
        ans = -1;
        System.out.println(obj.longestCycle(edges2));
    }
}
