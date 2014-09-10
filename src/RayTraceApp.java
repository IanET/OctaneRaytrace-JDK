import Flog.*;

public class RayTraceApp {
    // Pulled from the Octane sources
    static int MIN_ITERATIONS = 32;
    static long REFERENCE_SCORE = 739989;
    
	public class Data {
        long runs;
        long elapsed;
    }

	public static void main(String[] args) {
		System.out.println("Raytrace...");
		RayTraceApp rta = new RayTraceApp();
		rta.run();
 		System.out.println("Done.");
	}
	
	public void run() {
		// Warmup
         Measure(null);
         // Benchmark
         Data data = new Data();
         while (data.runs < MIN_ITERATIONS) {
             Measure(data);
             System.out.println("Runs: " + data.runs + ", Elapsed: " + data.elapsed);
         }
         long usec = (data.elapsed * 1000) / data.runs;
         long score = (REFERENCE_SCORE / usec) * 100;
         System.out.println("Score: " + score);
	}
    
    public void Measure(Data data) {
        // Run for a second
        long start = System.currentTimeMillis();
        long elapsed = 0;
        int i = 0;

        while (elapsed < 1000) {
            RayTracer.renderScene();
            i++;
            elapsed = System.currentTimeMillis() - start;
        }

        if (data != null) {
            data.runs += i;
            data.elapsed += elapsed;
        }
    }
    
}
