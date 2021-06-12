import java.io.*;
import java.util.*;
public class Assignment{
	static HashSet<String> set;
	static int count=0;
	static double totalLength=0;


	public static void fetchProfanityWords(HashSet<String> set) throws Exception{
		String line;
		FileReader  file = new FileReader ("Profanitywords.txt");
		BufferedReader br = new BufferedReader(file);
		while((line = br.readLine()) != null) {
			line.trim();
			if(!line.equals("")) set.add(line.toLowerCase());
	    }
	    br.close();

	}


	public static void fetchTwittes() throws Exception{
		String line;
		FileReader  file = new FileReader ("Twittertweets.txt");
		BufferedReader br = new BufferedReader(file);
		int noOfSentence=1;
		  while((line = br.readLine()) != null) {
		  	int localCount=0;
	        String arr[] = line.split(" ");
	        totalLength+=arr.length;
	        for(int i=0;i<arr.length;i++){
	        	if(set.contains(arr[i].toLowerCase())) {count++; localCount++;}
	        }
	       double percentage=localCount/(arr.length*1.0);   
			int per=(int)(percentage*100);
			System.out.println("Degree of Profanity in "+noOfSentence+" sentence: "+per+"%");
			noOfSentence++;
	    }

		 br.close();

	}


	public static void main(String args[]) throws Exception{
		set = new HashSet<>();
		fetchProfanityWords(set);
		fetchTwittes();
		double percentage=count/totalLength;   
		int per=(int)(percentage*100);
		System.out.println("Total No of Profanity Words in whole chat: "+count);
		System.out.println("Degree of Profanity in whole chat: "+per+"%");
	}
}