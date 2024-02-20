package leetCode;

public class KokoEatingBanana {

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
	
}
