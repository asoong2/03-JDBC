package com.ohgiraffers.section01;

import com.ohgiraffers.common.TaskDTO;
import com.ohgiraffers.common.TeamMemberDTO;

import java.util.List;

public class PrintResult {
    public void printTeamList(List<TeamMemberDTO> teamList) {
        teamList.forEach(System.out::println);
    }
    public void printTaskList(List<TaskDTO> taskList) {taskList.forEach(System.out::println);}

    public void printErrorMessage(String errorCdoe) {
        String errorMessage = "";
        switch (errorCdoe) {
            case "selectList" : errorMessage = "팀원 목록 조회에 실패했습니다."; break;
            case "selectTaskList" : errorMessage = "업무 목록 조회에 실패했습니다."; break;
            case "searchName" : errorMessage = "해당 검색 결과에 해당하는 목록이 존재하지 않습니다."; break;

        }
        System.out.println(errorMessage);
    }

    public void printTeamMember(TeamMemberDTO teamMember) {
        System.out.println(teamMember);
    }


}
