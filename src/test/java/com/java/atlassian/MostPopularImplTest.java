package com.java.atlassian;

import com.java.atlassian.impl.MostPopularImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 *  popularityTracker.increasePopularity(7);
 *  *
 *  *   popularityTracker.increasePopularity(7);
 *  *
 *  *   popularityTracker.increasePopularity(8);
 *  *
 *  *   popularityTracker.mostPopular();        // returns 7
 *  *
 *  *   popularityTracker.increasePopularity(8);
 *  *
 *  *   popularityTracker.increasePopularity(8);
 *  *
 *  *   popularityTracker.mostPopular();        // returns 8
 *  *
 *  *   popularityTracker.decreasePopularity(8);
 *  *
 *  *   popularityTracker.decreasePopularity(8);
 *  *
 *  *   popularityTracker.mostPopular();        // returns 7
 *  *
 *  *   popularityTracker.decreasePopularity(7);
 *  *
 *  *   popularityTracker.decreasePopularity(7);
 *  *
 *  *   popularityTracker.decreasePopularity(8);
 *  *
 *  *   popularityTracker.mostPopular();
 */



public class MostPopularImplTest {

    @Test
    public void testPopularity(){
        MostPopular popularityTracker = new MostPopularImpl();
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        Integer actual = popularityTracker.mostPopular();
        System.out.println(actual);
        Assert.assertEquals("7",String.valueOf(actual));
        popularityTracker.increasePopularity(8);
        popularityTracker.increasePopularity(8);
        actual = popularityTracker.mostPopular();
        System.out.println(actual);
        Assert.assertEquals("8",String.valueOf(actual));
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        actual = popularityTracker.mostPopular();
        System.out.println(actual);
        Assert.assertEquals("7",String.valueOf(actual));
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        actual = popularityTracker.mostPopular();
        System.out.println(actual);//-1
        Assert.assertEquals("-1",String.valueOf(actual));
    }

    @Test
    public void testPopularity2() throws  Exception{
        MostPopular popularityTracker = new MostPopularImpl();
        popularityTracker.increasePopularity(7);
        TimeUnit.SECONDS.sleep(1);
        popularityTracker.increasePopularity(8);
        Integer actual = popularityTracker.mostPopular();
        System.out.println(actual);
        TimeUnit.SECONDS.sleep(1);
        popularityTracker.increasePopularity(8);
        TimeUnit.SECONDS.sleep(1);
        popularityTracker.increasePopularity(7);
        actual = popularityTracker.mostPopular();
        System.out.println(actual);
    }
}
