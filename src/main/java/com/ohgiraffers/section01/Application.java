package com.ohgiraffers.section01;

import com.ohgiraffers.common.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PjController pjController = new PjController();

        do {
            System.out.println("========= 팀원 관리 프로그램 ==========");
            System.out.println("1. 팀원 / 업무 정보 조회");
            System.out.println("2. 신규 팀원 추가");
            System.out.println("3. 팀원 정보 수정");
            System.out.println("4. 팀원 정보 삭제");
            System.out.print("관리하고자 하는 번호를 입력하세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1 : selectInfo(); break;
                case 2 : pjController.registTeam(inputTeam()); break;
                case 3 : pjController.modifyTeam(inputModifyMenu()); break;
                case 4 : pjController.deleteTeam(inputId()); break;
                default:
                    System.out.println("잘못 된 메뉴를 선택하셨습니다.");
            }
        } while (true);
    }


    private static void selectInfo() {
        Scanner sc = new Scanner(System.in);
        PjController pjController = new PjController();
        do{
            System.out.println("========= 팀원 / 업무 정보 조회 ==========");
            System.out.println("1. 전체 팀원 조회");
            System.out.println("2. 전체 업무 조회");
            System.out.println("3. 팀원 이름 검색 혹은 업무에 배정된 팀원 확인");
            System.out.print("원하시는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1 : pjController.selectAllTeamMember(); break;
                case 2 : pjController.selectAllTask(); break;
                case 3 : pjController.searchName(inputSearchCriteria()); break;
                case 9 : break;
            }

        } while (true);

    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);

        System.out.print("검색 기준을 입력해주세요(팀원명 / 업무명) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }


    private static Map<String, String> inputTeam() {
        Scanner sc = new Scanner(System.in);
        System.out.print("추가하실 팀원의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("추가하실 팀원의 이메일을 입력하세요 : ");
        String email = sc.nextLine();
        System.out.print("추가하실 팀원의 핸드폰 번호를 입력하세요 : ");
        String phone = sc.nextLine();
        System.out.print("추가하실 팀원의 업무 코드를 입력해주세요 : ");
        String taskCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("email", email);
        parameter.put("phone", phone);
        parameter.put("taskCode", taskCode);

        return parameter;

    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정하실 팀원의 ID를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("수정하실 팀원의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정하실 팀원의 이메일을 입력하세요 : ");
        String email = sc.nextLine();
        System.out.print("수정하실 팀원의 핸드폰 번호를 입력하세요 : ");
        String phone = sc.nextLine();
        System.out.print("수정하실 팀원의 업무 코드를 입력해주세요 : ");
        String taskCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("name", name);
        parameter.put("email", email);
        parameter.put("phone", phone);
        parameter.put("taskCode", taskCode);

        return parameter;
    }

    private static Map<String, String> inputId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제하실 팀원의 ID를 입력해주세요 : ");
        String id = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);

        return parameter;
    }

}
