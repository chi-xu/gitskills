package com.util;

import java.util.ArrayList;
import java.util.List;


import com.bocloud.trainning.model.Menu;

public class MenuTree {
    
    public static List<Menu> buildByRecursive(List<Menu> menus) {
        List<Menu> trees = new ArrayList<Menu>();
        String i="0";
        for (Menu menu : menus) {
            if (i.equals(menu.getPid())) {
                trees.add(findChildren(menu,menus));
            }
        }
        return trees;
    }

   /**
    * 
    * @param menu
    * @param menus
    * @return
    */
    public static Menu findChildren(Menu menu,List<Menu> menus) {
        menu.setChildren(new ArrayList<Menu>());
        for (Menu it : menus) {
            if(menu.getMid().equals(it.getPid())) {
                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<Menu>());
                }
                menu.getChildren().add(findChildren(it,menus));
            }
        }
        return menu;
    }

}
