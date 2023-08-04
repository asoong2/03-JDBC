//package com.ohgiraffers.section01.model.service;
//
//import com.ohgiraffers.section01.model.dao.MenuDAO;
//import com.ohgiraffers.section01.model.dto.CategoryDTO;
//import com.ohgiraffers.section01.model.dto.MenuDTO;
//
//import java.sql.Connection;
//import java.util.List;
//import java.util.Scanner;
//
//import static com.ohgiraffers.common.JDBCTemplate.getConnection;
//
//public class MenuView {
//
//    private NewService newService = new NewService();
//
//    public void displayMainMenu() {
//        /* - Scanner를 이용해 사용자가 입력하는 신규 카테고리 정보를 CategoryDTO 타입의 객체에 담는다.
//            Scanner를 이용해 사용자가 입력하는 신규 메뉴 정보를 MenuDTO 타입의 객체에 담는다.
//            CategoryDTO 타입의 객체는 MenuDTO 타입의 객체에 담는다. */
//
//        Connection con = getConnection();
//        Scanner sc = new Scanner(System.in);
//        MenuDAO menuDAO = new MenuDAO();
//
//        do {
//            System.out.println("========== 신규 카테고리 & 메뉴 추가 ==========");
//
//            /* 1. 카테고리 조회 후 출력 */
//            List<CategoryDTO> categoryList = newService.selectAllCategory();
//            for (CategoryDTO category : categoryList) {
//                System.out.println(category.getName());
//            }
//
//            System.out.println("=====================================");
//            System.out.print("등록하실 카테고리를 선택해주세요 : ");
//            String inputCategory = sc.nextLine();
//
//            CategoryDTO newCategory = new CategoryDTO();
//            newCategory.setName(inputCategory);
//            newCategory.setRefCategoryCode(null);
//
//            int result1 = menuDAO.insertNewCategory(con, newCategory);
//
//            /* 2-2. 방금 입력 된 카테고리의 코드 조회 */
//            int newCategorycode = menuDAO.selectLastCategoryCode(con);
//
//            /* 2-3. 메뉴 등록 */
//            MenuDTO newMenu = new MenuDTO();
//            System.out.print("등록하실 메뉴의 이름을 입력해주세요 : ");
//            String scMenu = sc.nextLine();
//            newMenu.setName(scMenu);
//
//            System.out.print("등록하실 메뉴의 가격을 입력해주세요 : ");
//            int scPrice = sc.nextInt();
//            newMenu.setPrice(scPrice);
//
//            System.out.print("등록하실 메뉴의 카테고리를 입력해주세요 : ");
//            CategoryDTO scCategory = sc.ne();
//            newMenu.setCategory(scCategory);
//            newMenu.setOrderableStatus("Y");
//
//            System.out.print("계속 등록 하시겠습니까? (예 / 아니오)");
//            sc.nextLine();
//            boolean isContinue = sc.nextLine().equals("예");
//
//            if(!isContinue) break;
//
//        } while (true);
//    }
//}
//
