package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CartMapper {

    List<CartInsertDTO> cartPage(String userId);

     int addToCart(ProjectOptionDTO selectedOption);


    ProjectFileDTO cartFile(int projectCode);
}
