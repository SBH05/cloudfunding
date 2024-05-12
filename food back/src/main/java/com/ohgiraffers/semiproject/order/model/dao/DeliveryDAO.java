package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDAO {
    private final SqlSession sqlSession;

    @Autowired
    public DeliveryDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertDeliver(DeliverDTO deliverDTO, int member) {
        sqlSession.insert("deliveryMapper.insertDeliver", deliverDTO);
        return deliverDTO.getDeliverCode();
    }
}