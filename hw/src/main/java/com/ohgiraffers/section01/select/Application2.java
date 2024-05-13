package com.ohgiraffers.section01.select;

import com.ohgiraffers.common.JDBCTemplate;
import com.ohgiraffers.model.dto.CategoryDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

            /* Scanner 객체를 사용해 콘솔 창에서 입력 받은 categoryCode에 해당하는 행 데이터 조회
    => CategoryDTO 타입의 객체에 담고 출력 확인*/

        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        CategoryDTO row = null;
        List<CategoryDTO> caegoryList = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 카테고리 코드를 입력하세요 : ");
        String name = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("selectAllCategory");

            pstmt = con.prepareStatement(query);



        } catch (IOException e) {
            throw new RuntimeException();

        }

    }



}
