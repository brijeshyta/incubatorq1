package knight;
import java.util.Random;
import java.util.Vector;

public class Chess {
	
	/*
	 * Function to select a random valid move from the given
	 * position
	 */
	
	int make_move(int pos) {
		/* Movement matrix */
		Vector<Pair> moves = new Vector<Pair>();
		moves.add(new Pair(0,4));
		moves.add(new Pair(0,6));
		
		moves.add(new Pair(1,8));
		moves.add(new Pair(1,6));
		
		moves.add(new Pair(2,7));
		moves.add(new Pair(2,9));
		
		moves.add(new Pair(3,8));
		moves.add(new Pair(3,4));
		
		moves.add(new Pair(4,9));
		moves.add(new Pair(4,0));
		moves.add(new Pair(4,3));
		
		moves.add(new Pair(6,1));
		moves.add(new Pair(6,7));
		moves.add(new Pair(6,0));
		
		moves.add(new Pair(7,2));
		moves.add(new Pair(7,6));
		
		moves.add(new Pair(8,1));
		moves.add(new Pair(8,3));
		
		moves.add(new Pair(9,2));
		moves.add(new Pair(9,4));
		
		Vector<Integer> allowedMoves = new Vector<Integer>();
		
		moves.forEach(move -> { 
				if(pos == move.getKey()) {
					allowedMoves.add(move.getValue());
				}
			});
		
		Random rand = new Random();
		int randMove = rand.nextInt(allowedMoves.size());
		
		return allowedMoves.elementAt(randMove);
		
	}
	
	/*
	 *  Function that makes T moves and returns the path
	 */
	public int[] nMoves(int T) {
		int pos = 0;

		int path[] = new int[T];
		for (int i=0; i<=T-1; i++) {
			pos = this.make_move(pos);
			path[i] = pos;
		}
		return path;
	}
	
	
	public static void main (String args[]) {
		
		Chess chess = new Chess();
		Statistics stat;
		double S;
		int path[];
		/*
		 * After T =10 moves, what is the expected value of the quantity S mod 10 ?
		 */
		System.out.println("After T = 10 moves, what is the expected value of the quantity S mod 10 ?");
		path = chess.nMoves(10);
		S = new Statistics(path).getSum();
		System.out.println(S%10);
		System.out.println("");
		
		/*
		 * After T = 10 moves, what is the standard deviation of the quantity S mod 10?
		 */
		System.out.println("After T = 10 moves, what is the standard deviation of the quantity S mod 10?");
		path = chess.nMoves(10);
		int sdArray[] = new int[path.length], sum =0;
		for(int i=0; i<path.length; i++) {
			sum += path[i];  
			sdArray[i] = sum%10;
		}
		S = new Statistics(sdArray).getStdDev();
		//System.out.println("path -> " + Arrays.toString(path));
		//System.out.println("SD Array -> " + Arrays.toString(sdArray));
		System.out.println(S);
		System.out.println("");

		
		/*
		 * After T = 1024 moves, what is the expected value of the quantity S mod 1024?
		 */
		System.out.println("After T = 1024 moves, what is the expected value of the quantity S mod 1024?");
		path = chess.nMoves(1024);
		S = new Statistics(path).getSum();
		System.out.println(S%1024);
		System.out.println("");
		
		/*
		 * After T = 1024 moves, what is the standard deviation of the quantity S mod 1024?
		 */
		
		System.out.println("After T = 1024 moves, what is the standard deviation of the quantity S mod 1024?");
		path = chess.nMoves(1024);
		sdArray = new int[path.length];
		sum =0;
		for(int i=0; i<path.length; i++) {
			sum += path[i];  
			sdArray[i] = sum%1024;
		}
		S = new Statistics(sdArray).getStdDev();
		//System.out.println("path -> " + Arrays.toString(path));
		//System.out.println("SD Array -> " + Arrays.toString(sdArray));
		System.out.println(S);
		System.out.println("");
		
		
		/*
		 * After T = 10 moves, what is the probability that the sum S is divisible by 5, given that it is divisible by 7.
		 */
		
		// Running for 10000 cases
		System.out.println("After T = 10 moves, what is the probability that the sum S is divisible by 5, given that it is divisible by 7.");
		int count7=0, count5=0;
		for(int i=1 ; i<=100000; i++) {
			path = chess.nMoves(10);
			S = new Statistics(path).getSum();
			if(S%7 == 0) {
				count7++;
				if(S%5 == 0) count5++;
			}
		}
		System.out.println( (double) count5/count7);
		System.out.println("");

		
		/*
		 * After T = 1024 moves, what is the probability that the sum S is divisible by 23, given that it is divisible by 29.
		 */
		System.out.println("After T = 1024 moves, what is the probability that the sum S is divisible by 23, given that it is divisible by 29.");
		int count29=0, count23=0;
		for(int i=1 ; i<=100000; i++) {
			path = chess.nMoves(1024);
			S = new Statistics(path).getSum();
			if(S%29 == 0) {
				count29++;
				if(S%23 == 0) count23++;
			}
		}
		System.out.println( (double) count23/count29);
		System.out.println("");
	}
	
	

}
