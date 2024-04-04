package com.ohgiraffers.semiproject.board.model.service;

import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRegistException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;

import java.util.List;
import java.util.Map;

public interface BoardServiceInter {


    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> findAllNotice(SelectCriteria selectCriteria);

    NoticeDTO findOneNotice(Long no);

    int selectTotalInquiryCount(Map<String, String> searchMap);

    List<InquiryDTO> findAllInquiry(SelectCriteria selectCriteria);

    InquiryDTO findOneInquiry(Long no);

    int selectTotalUserComplaintCount(Map<String, String> searchMap);

    List<UserReportDTO> findAllUserComplaint(SelectCriteria selectCriteria);

    void registNotice(NoticeDTO noticeDTO) throws NoticeRegistException;

    void updateNotice(NoticeDTO noticeDTO) throws NoticeModifyException;

    void deleteNotice(Long no)throws NoticeRemoveException;

    void insertInquiryAnswer(InquiryAnswerDTO inquiryAnswerDTO) throws NoticeRegistException;

    void inquiryUpdate(InquiryAnswerDTO inquiryAnswerDTO) throws NoticeModifyException;

    void inquiryDelete(Long no) throws NoticeRemoveException;

    int selectTotalProjectComplaintCount(Map<String, String> searchMap);

    List<ProjectReportHistoryDTO> findAllProjectComplaint(SelectCriteria selectCriteria);

    ProjectReportHistoryDTO findOneComplaintProject(Long no);

    UserReportDTO findOneComplaintUser(Long no);

    void complaintUserDelete(long no) throws NoticeRemoveException;

    void complaintProjectDelete(Long no) throws NoticeRemoveException;
}
