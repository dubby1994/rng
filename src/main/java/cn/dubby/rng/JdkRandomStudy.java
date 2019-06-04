package cn.dubby.rng;

import java.util.Random;

/**
 * @author dubby
 * @date 2019/4/28 14:41
 */
public class JdkRandomStudy {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(random.nextBoolean());
        System.out.println(random.nextDouble());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(10));
    }

}
