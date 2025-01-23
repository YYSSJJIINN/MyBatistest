package com.ohgiraffers.run;

import com.ohgiraffers.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do{
            System.out.println("========== 메뉴 관리 작업 프로그램 ==========");
            System.out.println("1. 전체 메뉴 조회");
            System.out.println("2. 특정 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 기존 메뉴 정보 수정");
            System.out.println("5. 기존 메뉴 삭제");

            System.out.print("[SYSTEM] 희망 작업 번호를 입력하세요 : ");
            int num = sc.nextInt();

            switch(num) {
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectThatMenu(inputMenuCode()); break;
                case 3 : menuController.registMenu(inputMenu()); break;
                case 4 : menuController.modifyMenu(inputModifyMenu()); break;
                case 5 : menuController.deleteMenu(inputMenuCode()); break;
                default : System.out.println("[SYSTEM] 존재하지 않는 선택지를 고르셨습니다.");
            }
        } while(true);
    }

    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("[SYSTEM] 작업을 진행하고자 하는 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[SYSTEM] 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();

        System.out.println("[SYSTEM] 메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();

        System.out.println("[SYSTEM] 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[SYSTEM] 수정할 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();

        System.out.println("[SYSTEM] 수정할 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();

        System.out.println("[SYSTEM] 수정할 메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();

        System.out.println("[SYSTEM] 수정할 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
