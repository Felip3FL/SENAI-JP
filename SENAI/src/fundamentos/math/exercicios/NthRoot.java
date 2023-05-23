package fundamentos.math.exercicios;

public class NthRoot {
	public static double nthRoot(int n, double A) {
		double x0 = 1;
		boolean accurate = false;
		while (!accurate) {
			double x1 = (1 / (double) n) * ((n - 1) * x0 + A / pow(x0, n - 1));
			accurate = accurate(x0, x1);
			x0 = x1;
		}
		return x0;
	}
	
	private static double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * pow(x, n-1);
    }
	
	private static boolean accurate(double x0, double x1) {
		return Math.abs(x1 - x0) < 0.000001;
	}
}