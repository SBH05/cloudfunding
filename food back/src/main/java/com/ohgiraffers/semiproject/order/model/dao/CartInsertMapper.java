package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CartInsertMapper {




    int addToCart(CartDTO cart);

    int insertCart(Map<String, Object> addToCart);
}
