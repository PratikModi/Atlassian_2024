package com.java.atlassian;


/**
 * interface MostPopular {
 *
 *     void increasePopularity(Integer contentId);
 *
 *     Integer mostPopular();
 *
 *     void decreasePopularity(Integer contentId);
 * }
 *
 * Sample execution:
 *
 * [
 *
 *   popularityTracker.increasePopularity(7);
 *
 *   popularityTracker.increasePopularity(7);
 *
 *   popularityTracker.increasePopularity(8);
 *
 *   popularityTracker.mostPopular();        // returns 7
 *
 *   popularityTracker.increasePopularity(8);
 *
 *   popularityTracker.increasePopularity(8);
 *
 *   popularityTracker.mostPopular();        // returns 8
 *
 *   popularityTracker.decreasePopularity(8);
 *
 *   popularityTracker.decreasePopularity(8);
 *
 *   popularityTracker.mostPopular();        // returns 7
 *
 *   popularityTracker.decreasePopularity(7);
 *
 *   popularityTracker.decreasePopularity(7);
 *
 *   popularityTracker.decreasePopularity(8);
 *
 *   popularityTracker.mostPopular();        // returns -1 since there is no content with popularity greater than 0
 * ]
 *
 *
 * Map<Integer,Integer>  Key = contentid , Value-- No.Of Votes --- O(nLogN)
 * Sort It out based it's value --- Desc -- 1st
 * Increase the popolarity --- O(1)
 * if Map has content od -- current value+1 , 1 -- O(1)
 * if Map has content id -- currentValue-1 ,
 */
public class TestClass {

    public String testMethod(){
        return "Test";
    }
}
