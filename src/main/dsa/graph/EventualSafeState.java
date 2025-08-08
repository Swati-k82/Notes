package main.dsa.graph;
/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
*/

/*
Solution:
If any node is not reaching to the terminal node, that means it is part of some cycle,
find nodes in cyclic nodes and mark them as not safe.
total node- nodes in cycle = safe nodes

Cocept: find cycle using dfs:
while doing dfs, if we reach to a node which is already in the current path, that means there is a cycle.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] currPath = new boolean[n];
        Arrays.fill(visited, false);
        Arrays.fill(currPath, false);

        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i,visited,currPath,graph);
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            if(!currPath[i])
                ans.add(i);

        return ans;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] currPath, int[][] graph){
        visited[node]=true;
        currPath[node]=true;
        for(int i=0;i<graph[node].length;i++){
            int currNode = graph[node][i];
            if(!visited[currNode]){
                boolean isCycleFound = dfs(currNode,visited, currPath, graph);
                if (isCycleFound)
                    return true;
            } else{
                if(currPath[currNode])
                    return true;
            }
        }
        currPath[node]=false;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        EventualSafeState ess = new EventualSafeState();
        System.out.println(ess.eventualSafeNodes(graph));
    }
}
