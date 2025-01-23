package com.ohgiraffers.view;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        for(MenuDTO m : menuList) {
            System.out.println(m);
        }
    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch(successCode) {
            case "insert" : successMessage = "[SYSTEM] 신규 메뉴 등록를 성공하였습니다."; break;
            case "update" : successMessage = "[SYSTEM] 메뉴 정보 수정을 성공하였습니다."; break;
            case "delete" : successMessage = "[SYSTEM] 메뉴 삭제를 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch(errorCode) {
            case "selectList" : errorMessage = "[SYSTEM] 메뉴 목록 조회를 실패하였습니다."; break;
            case "selectOne" : errorMessage = "[SYSTEM] 개별 메뉴 조회를 실패하였습니다."; break;
            case "insert" : errorMessage = "[SYSTEM] 신규 메뉴 등록를 실패하였습니다."; break;
            case "update" : errorMessage = "[SYSTEM] 메뉴 정보 수정을 실패하였습니다."; break;
            case "delete" : errorMessage = "[SYSTEM] 메뉴 삭제를 실패하였습니다."; break;
            default : errorMessage = "[SYSTEM] 알 수 없는 오류가 발생했습니다. 다시 시도해주세요"; break;
        }
    }
}
