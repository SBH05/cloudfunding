package com.ohgiraffers.semiproject.order.model.service;

import com.ohgiraffers.semiproject.common.exception.cart.CartRegistException;
import com.ohgiraffers.semiproject.order.model.dao.CartInsertMapper;
import com.ohgiraffers.semiproject.order.model.dao.CartMapper;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectFileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class CartService {

    private final CartMapper Mapper;
    private final CartInsertMapper cartInsertMapper;

    public CartService(CartMapper mapper, CartInsertMapper cartInsertMapper) {
        this.Mapper = mapper;
        this.cartInsertMapper = cartInsertMapper;
    }

    public List<CartInsertDTO> cart(String userId) {

        List<CartInsertDTO> cart = Mapper.cartPage(userId);
        System.out.println("cart = " + cart);

        return cart;
    }


    public void addToCart(CartDTO cart) throws CartRegistException {
//        세션에서 cart라는 이름으로 저장된 cartDTO객체 가져온다.
//        CartDTO cart = (CartDTO) session.getAttribute("cart");


//        샂용자의 세션에서 장바구니 가져오고 없으면 장바구니 생성
//        if (cart == null) {
//            cart = new CartDTO();
//        }
//
//        log.info("================================ selectOption " + selectedOption);
//        log.info("===================================== session " + session);

        int result = cartInsertMapper.addToCart(cart);

//        int result2 = Mapper.addToOption(session);
        if(!(result > 0)) {
            throw new CartRegistException("장바구니 등록에 실패하셨습니다.");
        }

//
//        session.setAttribute("cart", cart);
    }

    public void insertCart(Map<String, Object> addToCart) {

        int result = cartInsertMapper.insertCart(addToCart);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    public ProjectFileDTO cartFile(int projectCode) {
        ProjectFileDTO projectFileDTO = Mapper.cartFile(projectCode);
        return projectFileDTO;
    }
}
