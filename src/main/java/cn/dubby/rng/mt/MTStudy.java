package cn.dubby.rng.mt;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

/**
 * @author dubby
 * @date 2019/6/4 11:41
 */
public class MTStudy {

    public static void main(String[] args) {
        UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
        int countTrue = 0, countFalse = 0;

        for (long i = 0; i < 10000 * 10000L; ++i) {
            boolean b = rng.nextBoolean();
            if (b) {
                ++countTrue;
            } else {
                ++countFalse;
            }
        }

        System.out.println("TRUE:\t" + countTrue);
        System.out.println("FALSE:\t" + countFalse);

        for (int i = 0; i < 1000; ++i) {
            Thread thread = new Thread(() -> {
                for (long j = 0; j < 10000 * 10L; ++j) {
                    rng.nextInt();
                }
                System.out.println(rng.nextInt());
            });
            thread.start();
        }

    }

}
