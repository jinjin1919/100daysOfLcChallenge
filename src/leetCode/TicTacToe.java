package leetCode;

public class TicTacToe {
	    
	    private int[] row; 
	    private int[] column; 
	    private int antiDiagonal;
	    private int diagonal; 
	    

	    /** Initialize your data structure here. */
	    public TicTacToe(int n) {
	        
	        this.row = new int[n]; 
	        
	        this.column = new int[n]; 
	        
	        this.antiDiagonal = 0;
	        this.diagonal = 0;   
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        
	    	if(player == 1) {
	    		
	    		this.row[row] += 1; 
		        this.column[col] += 1; 
	    		
	    	}else if(player == 2) {
	    		
	    		this.row[row] -= 1; 
		        this.column[col] -= 1; 
	    	}
	    	
	        
	        
	        if(row == col){ 
	        	
	        	if(player == 1) {
		    		
		    		this.diagonal += 1; 
			        this.diagonal += 1; 
		    		
		    	}else if(player == 2) {
		    		
		    		this.diagonal -= 1; 
			        this.diagonal -= 1; 
		    	}
	        }
	        
	        if((row + col) == (this.row.length - 1)){
	            
	        	if(player == 1) {
		    		
		    		this.antiDiagonal += 1; 
			        this.antiDiagonal += 1; 
		    		
		    	}else if(player == 2) {
		    		
		    		this.antiDiagonal -= 1; 
			        this.antiDiagonal -= 1; 
		    	}
	        }
	        
	        int n = this.row.length; 
	        
	        if(Math.abs(this.row[row]) == n || Math.abs(this.column[col]) == n || Math.abs(this.antiDiagonal) == n || Math.abs(this.diagonal) == n) {
	        	
	        	return player; 
	        	
	        	
	        }
	        
	        return 0; 
	      
	    }
	    
		public static void main(String[] args) {
			
			TicTacToe obj = new TicTacToe(3); 
			
			int param_1 = obj.move(0,0,1);
			
			System.out.println(param_1);
			
			int param_2 = obj.move(0,2,2);
			
			System.out.println(param_2);
			
		}

}
