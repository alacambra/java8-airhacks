package com.airhacks.plainjpa;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
    }

    @Test
    public void dateConversion() {
        final long id = 1;
        this.et.begin();
        Spaceship actual = this.em.merge(new Spaceship(id, "nepomuk", 42, LocalDate.now().plusDays(1)));
        this.et.commit();
        this.em.clear();
        Spaceship fetched = this.em.find(Spaceship.class, id);
        assertThat(actual, is(fetched));
    }
}
