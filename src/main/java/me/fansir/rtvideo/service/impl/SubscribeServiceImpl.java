package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.dao.SubscribeDao;
import me.fansir.rtvideo.model.Subscribe;
import me.fansir.rtvideo.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    SubscribeDao subscribeDao;

    @Override
    public List<Long> listSubscribePlayerId(Long viewerId, Integer state) {
        return subscribeDao.listSubscribePlayerId(viewerId, state);
    }

    @Override
    public Long addSubscribe(Long viewerId, Long playerId) {
        Subscribe subscribe = new Subscribe();
        subscribe.setViewerId(viewerId);
        subscribe.setOwnerId(playerId);
        subscribe.setState(StateCode.NORMAL);
        return this.addSubscribe(subscribe);
    }

    public Long addSubscribe(Subscribe subscribe) {
        Subscribe subscribe1 = subscribeDao.getSubscribe(subscribe.getViewerId(), subscribe.getOwnerId());
        if (subscribe1 == null) {
            subscribeDao.addSubscribe(subscribe);
        } else if (subscribe1.getState() != StateCode.NORMAL){
            subscribeDao.updateSubscribeState(subscribe.getViewerId(), subscribe.getOwnerId(), StateCode.NORMAL);
        }
        return subscribe.getId();
    }

    @Override
    public void deleteSubscribe(Long viewerId, Long playerId) {
        subscribeDao.updateSubscribeState(viewerId, playerId, StateCode.CANCEL);
    }

    @Override
    public Integer countFollowerNum(Long playerId) {
        return subscribeDao.countFollowerNum(playerId);
    }

    @Override
    public Boolean alreadySubscribed(Long viewerId, Long playerId) {
        Subscribe subscribe = subscribeDao.getSubscribe(viewerId, playerId);
        return subscribe != null && subscribe.getState() == StateCode.NORMAL;
    }
}
