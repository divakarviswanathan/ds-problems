package edu.diva.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SumSet {
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       for (int x: partial) s += x;
       if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        /*Integer[] numbers = {3,9,8,4,5,7,10};
        int target = 15;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
        */
    	 int[][] cargoList = {{38, 130, 500},{21, 280, 1800},{13, 120, 1500}};
        for(int num : findTruckCargo(300, cargoList)) {
        	System.out.println(num);
        }
    }
    
    static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
        List<Integer> remainingCargoPositions = new ArrayList<>();
    	for(int i = 0; i< cargoList.length;i++) {
    		remainingCargoPositions.add(i);
    	}
    	Map<Integer, int[]> profitContainerMap = new HashMap<>(1024,1.0f);
    	profitContainerMap.put(0, new int[] {0});
    	findPossibilities(0, cargoList, maxCargoWeight, new ArrayList<Integer>(), profitContainerMap);
    	int maxProfit = 0;
    	for(int key : profitContainerMap.keySet()) {
    		if(maxProfit < key) {
    			maxProfit = key;
    		}
    	}
        
    	return profitContainerMap.get(maxProfit);
    }



    static void putInProfitMap(int[][] cargoList, List<Integer> containerPositions, Map<Integer, int[]> profitContainerMap) {
    	int profit = 0;
    	int[] cargos = new int[containerPositions.size()+1];
    	int i = 0;
    	for(int position : containerPositions) {
    		profit += cargoList[position][2];
    		cargos[i] = cargoList[position][0];
    		i++;
    	}
        cargos[i] = profit;
    	profitContainerMap.put(profit, cargos);
    }

    static void findPossibilities(int start, int[][] cargoList, int maxCargoWeight, List<Integer> remainingCargoPositions, List<Integer> containerPositions, Map<Integer, int[]> profitContainerMap) {
        int capacity = 0;
        for(int i : containerPositions) {
        	capacity += cargoList[i][1];
        }
        if(capacity == maxCargoWeight) {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        }
        if(capacity > maxCargoWeight) {
        	containerPositions.remove(containerPositions.size()-1);
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        } else {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        }
        for(int i=start;i<cargoList.length;i++) {
        	if(start != 0) {
        		remainingCargoPositions.remove((Integer) i);
        	}
            ArrayList<Integer> containerPositionsTemp = new ArrayList<Integer>(containerPositions);
            containerPositionsTemp.add(i);
            findPossibilities(i+1, cargoList,maxCargoWeight,remainingCargoPositions,containerPositionsTemp, profitContainerMap);
        }
        return;
    }
    
    static void findPossibilities(int start, int[][] cargoList, int maxCargoWeight, List<Integer> containerPositions, Map<Integer, int[]> profitContainerMap) {
        int capacity = 0;
        for(int i : containerPositions) {
        	capacity += cargoList[i][1];
        }
        if(capacity == maxCargoWeight) {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        }
        if(capacity > maxCargoWeight) {
        	containerPositions.remove(containerPositions.size()-1);
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        } else {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        }
        for(int i=start;i<cargoList.length;i++) {
            ArrayList<Integer> containerPositionsTemp = new ArrayList<Integer>(containerPositions);
            containerPositionsTemp.add(i);
            findPossibilities(i+1, cargoList,maxCargoWeight,containerPositionsTemp, profitContainerMap);
        }
        return;
    }
    
    static void addToProfitMap(int[][] cargoList, List<Integer> containerPositionsP, Map<Integer, int[]> profitContainerMap, int maxCargoWeight) {
    	List<Integer> containerPositions = new ArrayList<>(containerPositionsP);
    	int capacity = 0;
        for(int i : containerPositions) {
        	capacity += cargoList[i][1];
        }
        if(capacity == maxCargoWeight) {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        } else if(capacity > maxCargoWeight) {
        	containerPositions.remove(containerPositions.size()-1);
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        } else {
        	putInProfitMap(cargoList, containerPositions, profitContainerMap);
        }
    }
    static void findPossibilitiesIterative(int start, int[][] cargoList, int maxCargoWeight, List<Integer> containerPositions, Map<Integer, int[]> profitContainerMap) {
    	for(int i = 0;i<cargoList.length;i++) {
    		containerPositions.add(i);
    		for( int j=i+1;j<cargoList.length;j++) {
    			containerPositions.add(j);
    			addToProfitMap(cargoList, containerPositions, profitContainerMap, maxCargoWeight);
    		}
    	}
        for(int i=start;i<cargoList.length;i++) {
            ArrayList<Integer> containerPositionsTemp = new ArrayList<Integer>(containerPositions);
            containerPositionsTemp.add(i);
            findPossibilities(i+1, cargoList,maxCargoWeight,containerPositionsTemp, profitContainerMap);
        }
        return;
    }
}