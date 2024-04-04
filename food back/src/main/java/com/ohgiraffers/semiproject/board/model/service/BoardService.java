package com.ohgiraffers.semiproject.board.model.service;

import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRegistException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.BoardMapper;
import com.ohgiraffers.semiproject.manager.model.dao.ManageProjectMapper;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.service.ManageProjectServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class BoardService implements BoardServiceInter {


    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<NoticeDTO> findAllNotice(SelectCriteria selectCriteria) {
        List<NoticeDTO> noticeDTOS = mapper.findAllNotice(selectCriteria);

        return noticeDTOS;
    }

    @Override
    public NoticeDTO findOneNotice(Long no) {
        NoticeDTO noticeDTO = mapper.findOneNotice(no);

        return noticeDTO;
    }

    @Override
    public int selectTotalInquiryCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalInquiryCount(searchMap);

        return result;
    }

    @Override
    public List<InquiryDTO> findAllInquiry(SelectCriteria selectCriteria) {
        List<InquiryDTO> inquiryDTOS = mapper.findAllInquiry(selectCriteria);

        System.out.println("inquiryDTOS ============================ " + inquiryDTOS);

        return inquiryDTOS;
    }

    @Override
    public InquiryDTO findOneInquiry(Long no) {

        InquiryDTO inquiryDTO = mapper.findOneInquiry(no);

        return inquiryDTO;

    }

    @Override
    public int selectTotalUserComplaintCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalUserComplaintCount(searchMap);
        return result;
    }

    @Override
    public List<UserReportDTO> findAllUserComplaint(SelectCriteria selectCriteria) {
        List<UserReportDTO> userReportDTOS = mapper.findAllUserComplaint(selectCriteria);

        return userReportDTOS;
    }

    @Override
    @Transactional
    public void registNotice(NoticeDTO noticeDTO) throws NoticeRegistException {
        int result = mapper.registNotice(noticeDTO);

        if(!(result > 0)) {
            throw new NoticeRegistException("등록에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void updateNotice(NoticeDTO noticeDTO) throws NoticeModifyException {

        int result = mapper.updateNotice(noticeDTO);

        if(!(result > 0)) {
            throw new NoticeModifyException("등록에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void deleteNotice(Long no) throws NoticeRemoveException {
        int result = mapper.deleteNotice(no);

        if(!(result > 0)) {
            throw new NoticeRemoveException("삭제에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void insertInquiryAnswer(InquiryAnswerDTO inquiryAnswerDTO) throws NoticeRegistException {
        int result = mapper.insertInquiryAnswer(inquiryAnswerDTO);

        if(!(result > 0)) {
            throw new NoticeRegistException("답변 등록에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void inquiryUpdate(InquiryAnswerDTO inquiryAnswerDTO) throws NoticeModifyException {
        int result = mapper.inquiryAnswerUpdate(inquiryAnswerDTO);

        if(!(result > 0)) {
            throw new NoticeModifyException("답변 등록에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void inquiryDelete(Long no) throws NoticeRemoveException {

        int result2 = mapper.inquiryAnswerDelete(no); // 답변 기록 삭제하는거

        int result = mapper.inquiryDelete(no); // 문의 기록 삭제하는거

        if(!(result > 0)) {
            throw new NoticeRemoveException("삭제에 실패했습니다");
        }
    }

    @Override
    public int selectTotalProjectComplaintCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalProjectComplaintCount(searchMap);
        return result;
    }

    @Override
    public List<ProjectReportHistoryDTO> findAllProjectComplaint(SelectCriteria selectCriteria) {
        List<ProjectReportHistoryDTO> inquiryDTOS = mapper.findAllProjectComplaint(selectCriteria);

        System.out.println("inquiryDTOS ============================ " + inquiryDTOS);

        return inquiryDTOS;
    }

    @Override
    public ProjectReportHistoryDTO findOneComplaintProject(Long no) {
        ProjectReportHistoryDTO projectReportHistoryDTO = mapper.findOneComplaintProject(no);

        return projectReportHistoryDTO;
    }

    @Override
    public UserReportDTO findOneComplaintUser(Long no) {
        UserReportDTO userReportHistoryDTO = mapper.findOneComplaintUser(no);

        return userReportHistoryDTO;
    }

    @Override
    @Transactional
    public void complaintUserDelete(long no) throws NoticeRemoveException {
        int result2 = mapper.complaintUserAnswerDelete(no); // 답변 기록 삭제하는거

        int result = mapper.complaintUserBoardDelete(no); // 문의 기록 삭제하는거

        if(!(result > 0)) {
            throw new NoticeRemoveException("삭제에 실패했습니다");
        }
    }

    @Override
    @Transactional
    public void complaintProjectDelete(Long no) throws NoticeRemoveException {
        int result = mapper.complaintProjectDelete(no);

        if(!(result > 0)) {
            throw new NoticeRemoveException("삭제에 실패했습니다");
        }
    }
}

