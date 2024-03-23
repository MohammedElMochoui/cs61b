package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;


public class GuitarHero {
    final static String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    final GuitarString[] concerts;

    public GuitarHero() {
        concerts = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < KEYBOARD.length(); i++) {
            int freq = (int) (440 * Math.pow(2, (i - 24) / 12));
            concerts[i] = new GuitarString(freq);
        }
    }

    public void pluckString(int i) {
        if (i >= 0 && i < concerts.length)
            concerts[i].pluck();
    }

    public double sampleSuperPosition() {
        double result = 0.0;
        for (GuitarString concert : concerts) {
            result += concert.sample();
        }
        return result;
    }

    public void tic() {
        for (GuitarString concert : concerts) {
            concert.tic();
        }
    }

    public static void main(String[] args) {
        GuitarHero g = new GuitarHero();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                g.pluckString(index);
            }

            double sample = g.sampleSuperPosition();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            g.tic();
        }
    }

}
