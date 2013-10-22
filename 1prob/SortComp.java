/**
@Authors: 
Alex Clavelle
Kelsey Cameron

*/
import java.util.LinkedList;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.*;
class SortComp{
	public static void main(String[] args){
		Path path = Paths.get(args[0]);
		LinkedList file = parseFile(path);		

		
	}

	public static LinkedList<String> parseFile(Path path){
		LinkedList<String> lines = new LinkedList<String>();
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedReader reader = Files.newBufferedReader(path,charset)){
			String line = null;
			while((line = reader.readLine()) != null){
				lines.add(line);
				System.out.println(line);
			}
		asdasdasdafghfdyutdyuti
		catch (IOException x){
			System.err.format("IOException: %s%n",x);
		}
		return lines;
	}
}
