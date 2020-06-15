/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbwd;

/**
 *
 * @author kostis
 */
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
public class ShortestPathProb { 
    // A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in shortest path tree
    //the input graph contains for each edge the probability of failure (each edge corresponds to a production rule)
   //based on this distance(probability of failure) we calculate the shortest path from source to each vertex
   //but simultaneously, we calculate at each transition the probability of success, which the product of (1-probability of failure)
   // example vertex 0-1-8 with probabilities of failure 0.05 and 0.10 respectively for the two edges (0-1 and 1-8)
   // this means that the probability of success of going from vertex 0 to vertex 8 is (1-0.05)*(1-0.1) = 0.855
  //this adjustment was made because dijkstra finds the minimum sum of edges' weights while our case required, due to the nature of probabilities, to work with products of weights
    static final int V = 50; 
    int minDistance(double dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        double min = Double.MAX_VALUE;
        int min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // A utility function to print the constructed distance array 
    void printSolution(double dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println((i+1) + "" + " tt " + dist[i]); 
    } 
  
    // Function that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
    double[] dijkstra(double graph[][], int src) 
    { 
        double dist[] = new double[V]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
        double dist2[] = new double[V];
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE;
            dist2[i] = 1;
            sptSet[i] = false; 
        } 
        
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v] != -1 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                    if(graph[u][v]<1)
                    {
                      dist2[v] = dist2[u] * (1-graph[u][v]);
                      
                    }
                    else
                    {
                       dist2[v] = dist2[u] * 1; 
                    }
                    
                }
        }
        
        
        // print the constructed distance array 
        //printSolution(dist2, V); 
        
        return dist2;
        
        
    } 
  
    // Driver method 
    
} 
