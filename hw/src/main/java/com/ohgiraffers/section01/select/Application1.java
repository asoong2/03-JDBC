package com.ohgiraffers.section01.select;

import com.ohgiraffers.common.JDBCTemplate;
import com.ohgiraffers.model.dto.CategoryDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class Application1 {
    public static void main(String[] args) {

        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        CategoryDTO categoryDTO = null;
        List<CategoryDTO> categoryList = null;

        Properties prop = new Properties();


        try {
            categoryList = new ArrayList<>();

            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("selectAllCategory");

            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            while( rset.next()) {
                categoryDTO = new CategoryDTO();

                categoryDTO.setCode(rset.getInt("category_code"));
                categoryDTO.setName(rset.getString("category_name"));
                categoryDTO.setRefCategoryCode(rset.getInt("ref_category_code"));

                categoryList.add(categoryDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        for( CategoryDTO row : categoryList) {
            System.out.println(row);
        }


    }
}