/**
	@authors: Alex Clavelle, Kelsey Cameron
Description: Creates a K-ary heap where K is the maximum number of children for a non-leaf node.
 */
import java.util.*;
import java.io.*;

public class KAry {
	List<String> input;

	public static void main(String[] args) {
		String filepath = args[0];
		KAry k = new KAry();
		
		k.loadfile(filepath);
		for(String s : k.input){
			System.out.println(s);
			
		}

	}

	public boolean loadfile(String path) {
		input = new ArrayList<String>();
		Scanner filescn;
		int count = 0;
		try {
			filescn = new Scanner(new File(path));
			while (filescn.hasNextLine()) {
				String line = filescn.nextLine();
				input.add(line);
				count++;
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		if (input.size() == count) {
			System.out.println("File successfully loaded");
			return true;
		} else
			System.out.println("File load unsuccessfull. ");
			return false;
	}

}
