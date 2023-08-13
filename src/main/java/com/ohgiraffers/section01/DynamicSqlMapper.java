package com.ohgiraffers.section01;

import com.ohgiraffers.common.SearchCriteria;
import com.ohgiraffers.common.TeamMemberDTO;

import java.util.List;

public interface DynamicSqlMapper {

    List<TeamMemberDTO> searchName(SearchCriteria searchCriteria);
}

