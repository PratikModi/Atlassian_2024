package com.java.atlassian.impl;

import com.java.atlassian.MostPopular;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * popularityTracker.increasePopularity(7);
 *
 *   popularityTracker.increasePopularity(8);
 *
 *   popularityTracker.mostPopular();        // returns 8
 *
 *   popularityTracker.increasePopularity(8);
 *
 *   popularityTracker.increasePopularity(7);
 *
 *   popularityTracker.mostPopular();        // returns 7
 */
public class MostPopularImpl implements MostPopular {

    private Map<Integer,Integer> contentMap;

    private Map<Integer,Popular> contentMapWithTime;

    //7--1, T1
    //8--1, T2

    private Integer mostPopular;

    public MostPopularImpl() {
        this.contentMap = new HashMap<>();
        this.contentMapWithTime = new HashMap<>();
    }

    @Override
    public void increasePopularity(Integer contentId) {
        //contentMap.put(contentId,contentMap.getOrDefault(contentId,0)+1);
        contentMapWithTime.putIfAbsent(contentId,new Popular(contentId,0, Instant.now().toEpochMilli()));
        contentMapWithTime.get(contentId).setPopularity(contentMapWithTime.get(contentId).getPopularity()+1);
        contentMapWithTime.get(contentId).setTime(Instant.now().toEpochMilli());
    }

    @Override
    public Integer mostPopular() {
        System.out.println(contentMapWithTime);
        if(!contentMapWithTime.isEmpty()) {
            List<Map.Entry<Integer, Popular>> sortedContentIds = new ArrayList<>(contentMapWithTime.entrySet());
            sortedContentIds = sortedContentIds.stream().sorted((e1, e2) -> e2.getValue().getPopularity()==e1.getValue().getPopularity()?e2.getValue().getTime().compareTo(e1.getValue().getTime()):e2.getValue().getPopularity()-e1.getValue().getPopularity()).collect(Collectors.toList());
            return sortedContentIds.get(0).getKey();
        }
        return -1;
    }

    @Override
    public void decreasePopularity(Integer contentId) {
        if(contentMap.containsKey(contentId)){
            contentMap.put(contentId,contentMap.get(contentId)-1);
            if(contentMap.get(contentId)==0)
                contentMap.remove(contentId);
        }else{
            throw new RuntimeException("Invalid Content Id!!");
        }
    }
}

class Popular{
    Integer contentId;
    Integer popularity;
    Long time;

    public Popular(Integer contentId, Integer popularity, Long time) {
        this.contentId = contentId;
        this.popularity = popularity;
        this.time = time;
    }

    public Integer getContentId() {
        return contentId;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public Long getTime() {
        return time;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Popular{" +
                "contentId=" + contentId +
                ", popularity=" + popularity +
                ", time=" + time +
                '}';
    }
}
