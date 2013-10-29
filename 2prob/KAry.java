/**
@authors: Alex Clavelle, Kelsey Cameron
Description: Creates a K-ary heap where K is the maximum number of children for a non-leaf node.
*/
import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import java.io.IOException;
public class KAry{
	public static void main(String[] args){
		//read each operation from the file into a map.
		Map <String, Integer> ops = new HashMap<String, Integer>();
		//new stuff with scanner
	  BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		try{
			Scanner input = new Scanner(new File("in.txt"));
			String splitMe = input.nextLine();
			String[] split = splitMe.split(" ");
			ops.put(split[0],Integer.parseInt(split[1]));
			
		}
	catch(Exception e){
			System.out.println("file not found");
			System.exit(1);
		}
	}
}
