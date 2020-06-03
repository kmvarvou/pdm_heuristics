/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbws;

/**
 *
 * @author kostis
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Κωστής
 */
public class PBWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int y=0;
        int[] sum = new int [10];
        int[] sum2= new int [10];
        int debug=0;
        PrintWriter[] pw = new PrintWriter[10];
        String[] heuristics = {"Random","Lowest Cost","Shortest Time","Lowest Fail Probability","Root Distance","Knockout Path","Knockout Path Time","Knockout Path Combination","Cost Distance","Time Distance"};
        while(y<10)
        {
           String filename = heuristics[y] + ".txt";
           pw[y] = new PrintWriter(new FileWriter(filename));
           y++;
        }
        y=0;
        while(y<100000)
        {
        Integer cost =0,time=0;
        double min =0.001, max =1.0;
        double random = ThreadLocalRandom.current().nextDouble(min, max);
        int minInt=1, maxInt=10;
        Random r = new Random();
        int result = r.nextInt((maxInt - minInt) + 1) + minInt;
        HashMap<Integer, String[]> operations = new HashMap();
        String[] temp = {"B","C","D","A","1","5","0.95"};
        temp[temp.length-1] = String.valueOf(random);
        temp[temp.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp[temp.length-3] = String.valueOf(result);
        operations.put(1,temp);
        String[] temp2 = {"F","G","H","C","4","5","0.95"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp2[temp2.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp2[temp2.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp2[temp2.length-3] = String.valueOf(result);
        operations.put(2,temp2);
        String[] temp3 = {"H","A","3","9","0.95"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp3[temp3.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp3[temp3.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp3[temp3.length-3] = String.valueOf(result);
        operations.put(3,temp3);
        String[] temp4 = {"E","A","2","2","1"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp4[temp4.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp4[temp4.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp4[temp4.length-3] = String.valueOf(result);
        operations.put(4,temp4);
        String[] temp5 = {"B","0","0","1"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp5[temp5.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp5[temp5.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp5[temp5.length-3] = String.valueOf(result);
        operations.put(5,temp5);
        String[] temp6 = {"D","0","0","1"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp6[temp6.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp6[temp6.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp6[temp6.length-3] = String.valueOf(result);
        operations.put(6,temp6);
        String[] temp7 = {"E","1","1","0.5"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp7[temp7.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp7[temp7.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp7[temp7.length-3] = String.valueOf(result);
        operations.put(7,temp7);
        String[] temp8 = {"F","0","0","1"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp8[temp8.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp8[temp8.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp8[temp8.length-3] = String.valueOf(result);
        operations.put(8,temp8);
        String[] temp9 = {"G","2","0","1"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp9[temp9.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp9[temp9.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp9[temp9.length-3] = String.valueOf(result);
        operations.put(9,temp9);
        String[] temp10 = {"H","10","3","0.85"};
        random = ThreadLocalRandom.current().nextDouble(min, max);
        temp10[temp10.length-1] = String.valueOf(random);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp10[temp10.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp10[temp10.length-3] = String.valueOf(result);
        operations.put(10,temp10);
        HashMap<Integer,String[]> operations_graph = (HashMap) operations.clone();
        int count = 10;
        int choice =0;
        List<Map<Integer, String[]>> listOfMaps = new ArrayList<Map<Integer, String[]>>();
        int u=0;
         
        
        while(u<10)
        {
           listOfMaps.add((HashMap) operations.clone());
           u++;
          
           
        }
        
        while(choice<10)
        {
        cost=0;
        time=0;
        operations= (HashMap)listOfMaps.get(choice);
        HashMap<Integer,String[]> executable = new HashMap();
        
        HashSet<String> available = new HashSet();
        
        while(count !=0)
        {
          
           Iterator it = operations.entrySet().iterator();
           while (it.hasNext()) //calculate executable operations
           {
            //System.out.println(choice + "arxi");
            HashMap.Entry pair = (HashMap.Entry)it.next();
            String[] temp11 = (String[])pair.getValue();
            if(temp11.length==4) //cases where operation has no input elements
            {
                executable.put((Integer)pair.getKey(),(String[]) pair.getValue());
            }
            else //cases where operation has input elements. so each input element is checked for availability
            {
              int temp12 = 0;
              for(int i=0;i<temp11.length-4;i++)
              {
                if(available.contains(temp11[i]))//each input is checked
                {
                    temp12++;
                    
                }
              }
              if(temp12 == temp11.length -4)//if every input is available then the operation is available for execution
              {
                  executable.put((Integer)pair.getKey(),(String[]) pair.getValue());
              }
            }
            //it.remove(); // avoids a ConcurrentModificationException
            
            }
           if(executable.size()==0)//execution has completed since the production of A is no longer possible
           {
               //System.out.println("oti na nai");
               System.out.println("cost: " + cost + "     time: " + time);
               String filename = heuristics[choice] + ".txt";
               
               pw[choice].println((y+1)+","+cost+","+time);
               
               sum[choice] += cost;
               sum2[choice] += time;
               break;
           }
           int key;
           if(choice==0)
           {
              key=executeRandom(executable,available,operations);
           }
           else if(choice==1)
           {
              key=executeLowestCost(executable,available,operations); 
           }
           else if(choice==2)
           {
              key=executeShortestTime(executable,available,operations); 
           }
           else if(choice==3)
           {
              key=executeLowestFail(executable,available,operations);
           }
           else if(choice==4)
           {
              key=rootDistance(executable,available,operations_graph);
           }
           else if(choice==5)
           {
               key=knockoutPath(executable,available,operations_graph);
           }
           else if(choice==6)
           {
              key=knockoutPathTime(executable,available,operations_graph);
           }
           else if(choice==7)
           {
              key=knockoutPathComb(executable,available,operations_graph); 
           }
           else if (choice==8)
           {
              key=costDistance(executable,available,operations_graph);
           }
           else
           {
              key=timeDistance(executable,available,operations_graph);
           }
           //int key=executeRandom(executable,available,operations);
           //int key = executeLowestCost(executable,available,operations);
           //int key = executeShortestTime(executable,available,operations);
           //int key = executeLowestFail(executable,available,operations);
           //int key = rootDistance(executable,available,operations);
           //int key = knockout2Path(executable,available,operations);
           
           String[] temp14 = operations.get(key);
           int cost2 = Integer.valueOf(temp14[temp14.length-2]);
           cost = cost + cost2; //cost of the entire path is calculated in a step by step manner
           int time2 = Integer.valueOf(temp14[temp14.length-3]);
           
           time = time + time2;
           operations.remove(key);//operation is removed from the list of operations as it is no longer available
           if(available.contains("A"))//if A has been produced then the execution is completed
           {
               System.out.println("cost: " + cost + "     time: " + time);
               pw[choice].println((y+1)+","+cost+","+time);
               if(cost==0 || time==0)
               {
                   debug++;
               }
               sum[choice] += cost;
               sum2[choice] += time;
               break;
           }
           
           
           
           
            
           
            
            
        }
        //System.out.println(choice);
        choice++;
        }//neo while
        System.out.println();
        System.out.println();
        y++;
    
    }
       
      for(int i=0;i<10;i++)
      {
       double result = (double) sum[i]/ (double)y; //average execution cost
       pw[i].close();
       double result2 = (double) sum2[i]/ (double)y;
       System.out.println(heuristics[i] +" cost: " + result +  "  time: " +result2);
          
      }
      System.out.println(debug);
      //double result = (double) sum/ (double)y; //average execution cost
      //System.out.println(result);
      //double result2 = (double) sum2/ (double)y;
      //System.out.println(result2);
     }
    
    private static int getRandomNumberInRange(int min, int max) 
    {
        if (min > max)
        {
          throw new IllegalArgumentException("max must be greater than min");
        }
        if(min==max)
        {
          return 1;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    private static int executeRandom(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)//Random selection strategy
    {
        int next = getRandomNumberInRange(1,input.size()) -1;
        int count =0;
        int key=0;
        Iterator it2 = input.entrySet().iterator();
        
        while(it2.hasNext())
        {
           HashMap.Entry pair2 = (HashMap.Entry)it2.next();
           if(count==next)
           {
            key =  (Integer) pair2.getKey();
            String[] temp13 = (String []) pair2.getValue();
            
            //operations.remove(key);
            input.remove(key);
            double prob = Double.parseDouble(temp13[temp13.length-1]);
            int result = execution(prob);
            if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
            {
                available.add(temp13[temp13.length-4]);
                System.out.println("Op" + key+ "," + temp13[temp13.length-4]);
            }
            else //execution was unsuccessful and therefore the element was not produced
            {
                System.out.println("Op" + key+ "," + temp13[temp13.length-4] + " fail");
            }
            
            
            
            break;
           }
           
           count++;
                   
        }
        
        return key;
    }
    
    private static int executeLowestCost(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)//Lowest Cost selection strategy
    {
        int n = input.size();
        int[][] cost = new int [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Integer.parseInt(temp15[temp15.length-2]);
          
          i++;
        }
        int key =getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeShortestTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int n = input.size();
        int[][] cost = new int [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Integer.parseInt(temp15[temp15.length-3]);
          
          i++;
        }
        int key =getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("ShortestOp" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeLowestFail(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int n = input.size();
        double[][] cost = new double [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Double.parseDouble(temp15[temp15.length-1]);
          
          i++;
        }
        int key = (int)getMaxValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    public static int getMinValue(int[][] numbers)
    {
                
        int minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                //System.out.println("min ranking " + (numbers[index][0]) );
		return numbers[index][0];
	}
    
    public static int getMinValueDouble(double[][] numbers)
    {
                
        double minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                System.out.println("min ranking " + (numbers[index][0]) );
		return (int) numbers[index][0];
	}
    
    public static double getMaxValue(double[][] numbers)
    {
                
        double maxValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] > maxValue)
           {
                maxValue = numbers[i][1];
                index =i;
           }
		}
                
		return numbers[index][0];
	}
    
    public static int getMinValue2(int[][] numbers)
    {
                
        int minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                
		return minValue;
	}
    
    private static int execution(double prob)// function that takes the input the success probability of a rule and executes it
    {
        Random r = new Random();
        double result = r.nextDouble();
        if(result>prob)
        {
          return 0; //failure
        }
        else
        {
          return 1;//success
        }
    }
    
    private static int rootDistanceOld(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int graph[][] = new int[][] { { 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, //end   
                                      { 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0}, //1
                                      { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, //2
                                      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, //3
                                      { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, //4
                                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //5
                                      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //6
                                      { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, //7
                                      { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//8
                                      { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//9
                                      { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}}; //10
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 0); 
        dist = ArrayUtils.remove(dist, 0);
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          int temp15= (Integer) pair.getKey(); // of the available for execution operations and saves them in the cost array
          
          cost[i][0]= temp15; 
          cost[i][1]= dist[temp15-1];
          
          i++;
        }
        int key =getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int rootDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int graph[][] = new int[9][9];
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = 1;
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=1;
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          for(int j=0;j<temp15.length-3;j++)
          {
            char tempstring = temp15[j].charAt(0); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
            int tempint = tempstring - 'A' +1;
            
            if(dist[tempint]>cost[i][1])
            {
             cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance 
            }                               //of the operation
          }
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int costDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int graph[][] = new int[9][9];
        if(operations.size()<10)
        {
            System.out.println("den kano oute gia ptoma");
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[dokimi.length-2]);
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=Integer.parseInt(dokimi[dokimi.length-2]);
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          for(int j=0;j<temp15.length-3;j++)
          {
            char tempstring = temp15[j].charAt(0); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
            int tempint = tempstring - 'A' +1;
            
            if(dist[tempint]>cost[i][1])
            {
             cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance 
            }                               //of the operation
          }
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int timeDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
    {
        int graph[][] = new int[9][9];
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[dokimi.length-3]);
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=Integer.parseInt(dokimi[dokimi.length-3]);
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          for(int j=0;j<temp15.length-3;j++)
          {
            char tempstring = temp15[j].charAt(0); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
            int tempint = tempstring - 'A' +1;
            
            if(dist[tempint]>cost[i][1])
            {
             cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance 
            }                               //of the operation
          }
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    
    
    
    
    
    
     
     
   
   
   private static int knockoutPath(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[0].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[9];
        double distProb[] = new double[9];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           double denominator = dist[ind] + graph[0][ind];
           double numerator = distProb[ind] * graph2[0][ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   
   private static int knockoutPathTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[0].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind] + graph[0][ind];
           double numerator = distProb[ind] * graph2[0][ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int knockoutPathComb(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]) * Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[0].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]) * Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind] + graph[0][ind];
           double numerator = distProb[ind] * graph2[0][ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = execution(prob);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
    
     
    
}