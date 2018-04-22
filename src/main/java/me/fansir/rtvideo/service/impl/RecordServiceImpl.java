package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.dao.RecordDao;
import me.fansir.rtvideo.model.Record;
import me.fansir.rtvideo.service.RecordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class RecordServiceImpl implements RecordService {

    Log logger = LogFactory.getLog(getClass());

    @Autowired
    RecordDao recordDao;

    @Override
    public List<Long> listRecordVideoId(Long uid, Integer state) {
        return recordDao.listRecordVideoId(uid, state);
    }

    @Override
    public Long addWatchRecord(Record record) {
        Record oriRecord = recordDao.getRecordByUserIdAndVideoId(record.getUserId(), record.getVideoId());
        if (oriRecord != null) {
            if (oriRecord.getState() != StateCode.NORMAL) {
                recordDao.updateRecordState(oriRecord.getId(), StateCode.NORMAL);
            }
            return oriRecord.getId();
        } else {
            recordDao.addWatchRecord(record);
            return record.getId();
        }
    }

    @Override
    public Long addWatchRecord(Long uid, Long vid) {
        Record record = new Record();
        record.setUserId(uid);
        record.setVideoId(vid);
        record.setState(StateCode.NORMAL);
        return this.addWatchRecord(record);
    }

    @Override
    public void updateRecordState(Long recordId, Integer state) {
        recordDao.updateRecordState(recordId, state);
    }

    @Override
    public void updateCertainUserRecordState(Long uid, Integer state) {
        recordDao.updateCertainUserRecordState(uid, state);
    }

    @Override
    public void deleteRecord(Long recordId) {
        this.updateRecordState(recordId, StateCode.DELETE);
    }

    @Override
    public void deleteRecord(Long viewerId, Long videoId) {
        recordDao.deleteRecord(viewerId, videoId);
    }

    @Override
    public void deleteAllRecord(Long uid) {
        this.updateCertainUserRecordState(uid, StateCode.DELETE);
    }

}
