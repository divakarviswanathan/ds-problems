package edu.diva.ds.arrays;

public class ArraySplitDP {

	public static void main(String[] args) {
		int arr[] = {3,1,1,2,2,15};
		System.out.println(isSplittable(arr));
	}
	
	public static boolean isSplittable(int[] arr) {
		int sum = calculateSum(arr);
		if(sum%2 == 0) {
			boolean table[][] = constructDynamicTable(arr, sum);
			return table[arr.length][sum/2];
		}
		return false;
	}
	
	public static int calculateSum(int arr[]) {
		int sum = 0;
		for(int i =0;i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static boolean[][] constructDynamicTable(int arr[], int sum) {
		boolean table[][] = new boolean[arr.length+1][sum/2+1];
		
		for(int i=0;i<=arr.length;i++)
			table[i][0] = true;
		
		for(int i=1;i<=(sum/2);i++)
			table[0][i] = false;
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=(sum/2);j++) {
				table[i][j] = table[i-1][j];
				if(arr[i-1] <= j ) {
					table[i][j] = arr[i-1] == j || table[i-1][j-arr[i-1]];
				}
			}
		}
		//printTable(table, sum);
		return table; 
	}
	
	private static void printTable(boolean[][] table, int sum) {
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<=(sum/2);j++) {
				System.out.print(table[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
