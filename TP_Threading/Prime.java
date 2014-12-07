public class Prime {

	public static interface PrimeListener {
		public void progress(int percentage);
	}

	public static int compute50000th(PrimeListener listener) {
		int nb = 50000;
		int status = 1, num = 3;
		int lastFound = 1;

		for (int count = 2; count <= nb;) {

			int progress = (count * 100) / nb;
			
			if(progress % 5 == 0)
				listener.progress(progress);

			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					status = 0;
					break;
				}
			}
			if (status != 0) {
				lastFound = num;
				count++;
			}
			status = 1;
			num++;
		}

		return lastFound;
	}
}
