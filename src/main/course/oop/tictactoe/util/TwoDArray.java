package main.course.oop.tictactoe.util;

import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {

	int arr[][];
	int defaultValue;

	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		defaultValue = defaultVal;
		arr = new int[rows][];
		for (int a = 0; a < rows; a++){
			arr[a] = new int[cols];
			fill(arr[a], defaultVal);
		}
	}
	
	private void fill(int[] is, int defaultVal) {
		for (int a = 0; a < is.length; a++){
				is[a] = defaultVal;
		}
	
}

	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		defaultValue = defaultVal;
		for (int a = 0; a < arr.length; a++) {
			fill(arr[a], defaultVal);
		}
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		String response = "Failure: "+val+" is not allowed.";
		if (val != defaultValue && arr[row][col] == defaultValue){
			arr[row][col] = val;
			response = "Success! "+val+" was inserted.";
		}
		else if(val != defaultValue && arr[row][col] != defaultValue){
			response = "Failure: "+row+", "+col+" is not empty.";
		}

		return response;
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */

		return arr[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < arr.length; a++){
			for (int b = 0; b < arr[a].length; b++){
				sb.append(arr[a][b] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		String response = "Rows: " + arr.length +"\nColumns: "+ arr[0].length +"\nUnique Values: ";
		ArrayList<Integer> vals = new ArrayList<Integer>();
		ArrayList<Integer> counts = new ArrayList<Integer>();

		for (int a = 0; a < arr.length; a++){
			for (int b = 0; b < arr[a].length; b++){
				if(vals.contains(arr[a][b])){
					int c = vals.indexOf(arr[a][b]);
					counts.set(c, counts.get(c) + 1);
				}
				else{
					vals.add(arr[a][b]);
					counts.add(1);
				}
			}
		}
		response += vals.size() + "\n";
		for( int d = 0; d < vals.size(); d++){
			response += "value: " + vals.get(d) + " count: " +counts.get(d) +"\n";
		}

		return response;
	}		

}
