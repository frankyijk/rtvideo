package me.fansir.rtvideo.service;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface SubscribeService {
    List<Long> listSubscribePlayerId(Long viewerId, Integer state);
    Long addSubscribe(Long viewerId, Long playerId);
    void deleteSubscribe(Long viewerId, Long playerId);
    Integer countFollowerNum(Long playerId);
    Boolean alreadySubscribed(Long viewerId, Long playerId);
}
