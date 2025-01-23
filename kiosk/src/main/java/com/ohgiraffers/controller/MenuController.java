package com.ohgiraffers.controller;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.model.service.MenuService;
import com.ohgiraffers.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }


    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectThatMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO foundMenu = menuService.selectThatMenu(code);

        if(foundMenu != null) {
            printResult.printMenu(foundMenu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO newMenu = new MenuDTO();

        newMenu.setName(name);
        newMenu.setPrice(price);
        newMenu.setCategoryCode(categoryCode);

        if(menuService.registMenu(newMenu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menuToUpdate = new MenuDTO();
        menuToUpdate.setCode(code);
        menuToUpdate.setName(name);
        menuToUpdate.setPrice(price);
        menuToUpdate.setCategoryCode(categoryCode);

        if(menuService.modifyMenu(menuToUpdate)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if(menuService.deleteMenu(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }
}
