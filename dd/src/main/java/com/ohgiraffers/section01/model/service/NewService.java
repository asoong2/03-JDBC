//package com.ohgiraffers.section01.model.service;
//
//import com.ohgiraffers.section01.model.dao.MenuDAO;
//import com.ohgiraffers.section01.model.dto.CategoryDTO;
//
//import java.sql.Connection;
//import java.util.List;
//
//import static com.ohgiraffers.common.JDBCTemplate.close;
//import static com.ohgiraffers.common.JDBCTemplate.getConnection;
//
//public class NewService {
//
//    private MenuDAO menuDAO = new MenuDAO();
//
//    public List<CategoryDTO> selectAllCategory() {
//        /* 1. Connection 생성 */
//        Connection con = getConnection();
//
//        /* 2. DAO 모든 카테고리 조회용 메소드를 호출하여 결과를 리턴 받기 */
//        List<CategoryDTO> categoryList = menuDAO.selectAllCategory(con);
//
//        /* 3. Connection 반납 */
//        close(con);
//
//        /* 4. 반환 받은 값 리턴 */
//        return categoryList;
//
//
//}
