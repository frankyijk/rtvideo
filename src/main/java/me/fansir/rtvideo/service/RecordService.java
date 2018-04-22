package me.fansir.rtvideo.service;

import me.fansir.rtvideo.model.Record;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface RecordService {
    List<Long> listRecordVideoId(Long uid, Integer state);
    Long addWatchRecord(Record record);
    Long addWatchRecord(Long uid, Long vid);
    void deleteRecord(Long recordId);
    void deleteRecord(Long viewerId, Long videoId);
    void deleteAllRecord(Long uid);
    void updateRecordState(Long recordId, Integer state);
    void updateCertainUserRecordState(Long uid, Integer state);
}
