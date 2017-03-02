package bean;

import java.util.ArrayList;

/**
 * Created by Volha_Hitskaya on 3/2/2017.
 */
public class Menu {
    private String category;
    private ArrayList<Menu> menu = new ArrayList<Menu>();

    public ArrayList<Menu> getMenuList(ArrayList<Menu> menu)
    {
        return menu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
