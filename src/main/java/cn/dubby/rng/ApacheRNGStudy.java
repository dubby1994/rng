package cn.dubby.rng;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

/**
 * @author dubby
 * @date 2019/4/28 14:24
 */
public class ApacheRNGStudy {

    public static void main(String[] args) {
        UniformRandomProvider rng = RandomSource.create(RandomSource.MT);

        System.out.println(rng.nextBoolean());
        System.out.println(rng.nextDouble());
        System.out.println(rng.nextInt());
        System.out.println(rng.nextInt(10));
    }

}
