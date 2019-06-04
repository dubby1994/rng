package cn.dubby.random.string;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.apache.commons.text.RandomStringGenerator;

/**
 * @author dubby
 * @date 2019/4/28 14:28
 */
public class RandomStringGeneratorStudy {

    private static final int length = 128;

    public static void main(String[] args) {
        jdk();
        apacheRNG();
        apacheRandomString();
    }

    private static void jdk() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();

        System.out.println("jdk random");
        for (int i = 0; i < 5; ++i) {
            String randomLetters = generator.generate(length);
            System.out.println(randomLetters);
        }
        System.out.println();
    }

    private static void apacheRNG() {
        UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .usingRandom(rng::nextInt)
                .build();

        System.out.println("apache rng");
        for (int i = 0; i < 5; ++i) {
            String randomLetters = generator.generate(length);
            System.out.println(randomLetters);
        }
        System.out.println();
    }

    private static void apacheRandomString() {
        System.out.println("apache random string");
        for (int i = 0; i < 5; ++i) {
            System.out.println(RandomStringUtils.randomAlphabetic(length));
        }
        System.out.println();
    }

}
