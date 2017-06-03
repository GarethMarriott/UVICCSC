/* Aggregate.java
   CSC 225 - Summer 2017

   Some starter code for programming assignment 1, showing
   the command line argument parsing and the basics of opening
   and reading lines from the CSV file.

   B. Bird - 04/26/2017

   -------------------------

   Implimented by:
   Gareth Marriott
   V00875748
   05/22/2017
*/


import java.io.*;
import java.util.*;

public class Aggregate{


	public static void showUsage(){
		System.err.printf("Usage: java Aggregate <function> <aggregation column> <csv file> <group column 1> <group column 2> ...\n");
		System.err.printf("Where <function> is one of \"count\", \"sum\", \"avg\"\n");
	}


	public static void main(String[] args){

		//At least four arguments are needed
		if (args.length < 4){
			showUsage();
			return;
		}
		String agg_function = args[0];
		String agg_column = args[1];
		String csv_filename = args[2];
		String[] group_columns = new String[args.length - 3];
		for(int i = 3; i < args.length; i++)
			group_columns[i-3] = args[i];

		if (!agg_function.equals("count") && !agg_function.equals("sum") && !agg_function.equals("avg")){
			showUsage();
			return;
		}

		BufferedReader br = null;

		try{
			br = new BufferedReader(new FileReader(csv_filename));
		}catch( IOException e ){
			System.err.printf("Error: Unable to open file %s\n",csv_filename);
			return;
		}

		String header_line;
		try{
			header_line = br.readLine(); //The readLine method returns either the next line of the file or null (if the end of the file has been reached)
		} catch (IOException e){
			System.err.printf("Error reading file\n", csv_filename);
			return;
		}
		if (header_line == null){
			System.err.printf("Error: CSV file %s has no header row\n", csv_filename);
			return;
		}

		//Split the header_line string into an array of string values using a comma
		//as the separator.
		String[] column_names = header_line.split(",");

		//As a diagnostic, print out all of the argument data and the column names from the CSV file
		//(for testing only: delete this from your final version)

		System.out.println("Aggregation function: "+agg_function);
		System.out.println("Aggregation column: "+agg_column);


		for (String s: group_columns)
			System.out.println("Grouping column: "+s);
		System.out.println();

		for (String s: column_names)
			System.out.println("CSV column name: "+s);


		//... Your code here ...

    ArrayList<String> file = new ArrayList<String>();
    try {
      while (true) {
        String curLine = br.readLine();
        if (curLine == null) {
          break;
        }
        file.add(curLine);    //Worst case O(N) expected case O(1)
      }
    }catch (Exception e) {
      e.printStackTrace();
    }
    // System.out.println(file);
    // System.out.println(file.get(3));

    int agg_column_num = -1;
    for (int i = 0; i<column_names.length; i++) {
      if (agg_column.equals(column_names[i])) {
        agg_column_num = i;
      }
    }
    if(agg_column_num == -1){
      System.out.println();
      System.out.println();
      showUsage();
      return;
    }
    //System.out.println(agg_column_num);

    int[] group_columns_num = new int[group_columns.length];
    for (int i = 0; i<group_columns.length; i++) {
      for (int j = 0; j<column_names.length; j++) {
        if (group_columns[i].equals(column_names[j])) {
          group_columns_num[i] = j;
        }
      }
    }

    // for (int i : group_columns_num) {
    //   System.out.println(i);
    // }


	}

  private static void sum(){

  }

  private static void count(){

  }

  private static void avg(){
    
  }

}
