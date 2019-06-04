package cn.dubby.random.test;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dubby
 * @date 2019/6/3 20:52
 */
public class SeedTest {

    @Before
    public void before() {
        System.out.println();
    }

    @Test
    public void JDK() {
        Random random1 = new Random(1);
        Random random2 = new Random(1);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            list1.add(random1.nextInt());
            list2.add(random2.nextInt());
        }
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void MT() {
        UniformRandomProvider rng1 = RandomSource.create(RandomSource.MT, 1);
        UniformRandomProvider rng2 = RandomSource.create(RandomSource.MT, 1);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            list1.add(rng1.nextInt());
            list2.add(rng2.nextInt());
        }
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void ISAAC() {
        UniformRandomProvider rng1 = RandomSource.create(RandomSource.ISAAC, 1);
        UniformRandomProvider rng2 = RandomSource.create(RandomSource.ISAAC, 1);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            list1.add(rng1.nextInt());
            list2.add(rng2.nextInt());
        }
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void WELL_512_A() {
        UniformRandomProvider rng1 = RandomSource.create(RandomSource.WELL_512_A, 1);
        UniformRandomProvider rng2 = RandomSource.create(RandomSource.WELL_512_A, 1);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            list1.add(rng1.nextInt());
            list2.add(rng2.nextInt());
        }
        System.out.println(list1);
        System.out.println(list2);
    }

}
