package cn.dubby.random.test;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author dubby
 * @date 2019/6/4 11:46
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode({Mode.All})
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class RNGPerformanceTest {

    Random random;

    UniformRandomProvider rng;

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(RNGPerformanceTest.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Setup
    public void setup() {
        random = new Random();
        rng = RandomSource.create(RandomSource.MT);
    }

    @Benchmark
    public void jdkSingleThread() {
        random.nextInt();
    }

    @Benchmark
    public void mtSingleThread() {
        rng.nextInt();
    }

}
