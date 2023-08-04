package com.ohgiraffers.section01.run;

import com.ohgiraffers.section01.model.service.MenuView;

public class Application {
    public static void main(String[] args) {
    /* chap05-service-upgrade 프로젝트를 생성하여 신규 카테고리와 신규 메뉴에 대해
    Scanner로 사용자 입력을 받아 저장하는 기능 만들기
    (chap05 코드를 chap06과 유사한 구조로 변경해보는 연습)*/


        MenuView menuView = new MenuView();
        menuView.displayMainMenu();

    }
}
