import java.io.*;
import java.util.*;
class FastIn{
	private static BufferedReader br;
	private static StringTokenizer st;
	void in()throws IOException{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
	}

	String next(){
		return st.nextToken();
	}

	Integer nextInt(){
		return Integer.parseInt(next());
	}

	Float nextFloat(){
		return Float.parseFloat(next());
	}

	Long nextLong(){
		return Long.parseLong(next());
	}

	Double nextDouble(){
		return Double.parseDouble(next());
	}

	char nextChar(){
		return next().charAt(0);
	}
}