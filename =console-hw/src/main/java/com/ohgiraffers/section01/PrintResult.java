package com.ohgiraffers.section01;

import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;

import java.util.List;

public class PrintResult {
    public void printTeamList(List<TeamMemberDTO> teamList) {
        teamList.forEach(System.out::println);
    }
    public void printTaskList(List<TaskDTO> taskList) {taskList.forEach(System.out::println);}
    public void printTeamMember(TeamMemberDTO teamMember) {
        System.out.println(teamMember);
    }


    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch(successCode){
            case "insert" : successMessage = "새로운 팀원이 추가되었습니다."; break;
            case "update" : successMessage = "팀원 정보 수정에 성공하였습니다."; break;
            case "delete" : successMessage = "팀원을 제외시켰습니다."; break;
        }

        System.out.println(successMessage);
    }
    public void printErrorMessage(String errorCdoe) {
        String errorMessage = "";
        switch (errorCdoe) {
            case "selectList" : errorMessage = "팀원 목록 조회에 실패했습니다."; break;
            case "selectTaskList" : errorMessage = "업무 목록 조회에 실패했습니다."; break;
            case "searchName" : errorMessage = "해당 검색 결과에 해당하는 목록이 존재하지 않습니다."; break;
            case "insert" : errorMessage = "새로운 팀원을 추가하지 못했습니다."; break;
            case "update" : errorMessage = "팀원 정보 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "팀원을 제외시키지 못했습니다."; break;

        }
        System.out.println(errorMessage);
    }

}
