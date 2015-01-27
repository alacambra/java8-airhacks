package com.airhacks.plainjpa;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adam-bien.com
 */
public class SpaceshipTest {

    EntityManager em;
    EntityTransaction et;

    @Before
    public void instantiate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        this.em = emf.createEntityManager();
        this.et = this.em.getTransaction();
        this.et.begin();
        this.em.merge(new Spaceship("nepomuk", 42, false));
        this.em.merge(new Spaceship("falcon", 1000, true));
        this.em.merge(new Spaceship("x-wing", 800, false));
        this.et.commit();
    }

    @Test
    public void count() {
        List<Spaceship> all = getAll();
        long count = all.parallelStream().
                filter(s -> s.getSpeed() > 1).
                count();
        assertThat(count, is(3l));
    }

    List<Spaceship> getAll() {
        return this.em.createNamedQuery(Spaceship.findAll, Spaceship.class).
                getResultList();
    }

    @Test
    public void averageSpeed() {
        List<Spaceship> all = getAll();
        final ToIntFunction<? super Spaceship> name = s -> {
            return s.getSpeed();
        };
        double averageSpeed = all.parallelStream().
                mapToInt(name).
                average().
                getAsDouble();
        assertTrue(averageSpeed > 0);
    }

    @Test
    public void groupByHyperspeed() {
        ConcurrentMap<Boolean, List<Spaceship>> byHyperspeed
                = getAll()
                .parallelStream()
                .collect(
                        Collectors.groupingByConcurrent(Spaceship::isHyperspeed));
        List<Spaceship> fast = byHyperspeed.get(true);
        assertThat(fast.size(), is(1));
        List<Spaceship> slow = byHyperspeed.get(false);
        assertThat(slow.size(), is(2));
        System.out.println("Map: " + byHyperspeed);

    }

}
