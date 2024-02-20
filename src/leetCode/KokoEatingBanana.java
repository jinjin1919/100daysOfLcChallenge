package leetCode;

public class KokoEatingBanana {
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

	public int minEatingSpeed(int[] piles, int h) {

		int max = piles[0];

		for (int pile : piles) {
			max = Math.max(max, pile);
		}

		int left = 1;
		int right = max;
		while (left < right) {
			int mid = (left + right) / 2;
			int time = findTime(mid, piles);
			
			// If Koko can finish all the piles within h hours, set right equal to middle signifying that all speeds greater than middle are workable but less desirable by Koko. 
			//Otherwise, set left equal to middle+1 signifying that all speeds less than or equal to middle are not workable.

			if (time <= h) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return right;
	}

	public int findTime(int speed, int[] piles) {

		int t = 0;
		for (int pile : piles) {
			t += Math.ceil(pile / (double) speed);
		}

		return t;
	}
	
	public static void main(String[] args) {
		
	}
	
}
