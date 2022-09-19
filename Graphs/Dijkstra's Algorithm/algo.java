class Solution {
    class Graph {
        int V, E;
        Edge[] edge;
        
        public Graph(int V, int E){
            this.V = V;
            this.E = E;
            edge = new Edge[E];
            
            for(int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }
        }
    }
    
    class Subset {
        int parent, rank;
    }
    
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    
    public int find(Subset[] subset, int i) {
        return subset[i].parent == i ? i : find(subset, subset[i].parent);
    }  
    
    public void union(Subset[] subset, int x, int y){
        int xroot = find(subset, x);
        int yroot = find(subset, y);
        
        if(subset[xroot].rank < subset[yroot].rank){
            subset[xroot].parent = yroot;
        }
        else if(subset[xroot].rank > subset[yroot].rank){
            subset[yroot].parent = xroot;
        }
        else{
            subset[xroot].parent = yroot;
            subset[yroot].rank++;
        }
    }
    
    public int main(int[][] edges, int V, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Subset[] subset = new Subset[V];
        
        for(int i = 0; i < V; i++) {
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }
        
        for(int[] edge : edges) {
            pq.add(edge);
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
                
            int x = find(subset, edge[0]-1);
            int y = find(subset, edge[1]-1);
            
            if(x != y) {
                ans += edge[2];
                union(subset, x, y);
            }
        }
        
        return ans;
    }
}