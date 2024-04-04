package com.ohgiraffers.semiproject.manager.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> findAllNotice(SelectCriteria selectCriteria);

    NoticeDTO findOneNotice(Long no);

    int selectTotalInquiryCount(Map<String, String> searchMap);

    List<InquiryDTO> findAllInquiry(SelectCriteria selectCriteria);

    InquiryDTO findOneInquiry(Long no);

    int selectTotalUserComplaintCount(Map<String, String> searchMap);

    List<UserReportDTO> findAllUserComplaint(SelectCriteria selectCriteria);

    int registNotice(NoticeDTO noticeDTO);

    int updateNotice(NoticeDTO noticeDTO);

    int deleteNotice(Long no);

    int insertInquiryAnswer(InquiryAnswerDTO inquiryAnswerDTO);

    int inquiryAnswerUpdate(InquiryAnswerDTO inquiryAnswerDTO);

    int inquiryDelete(Long no);

    int inquiryAnswerDelete(Long no);

    int selectTotalProjectComplaintCount(Map<String, String> searchMap);

    List<ProjectReportHistoryDTO> findAllProjectComplaint(SelectCriteria selectCriteria);

    ProjectReportHistoryDTO findOneComplaintProject(Long no);

    UserReportDTO findOneComplaintUser(Long no);

    int complaintUserAnswerDelete(long no);

    int complaintUserBoardDelete(long no);

    int complaintProjectDelete(Long no);
}
