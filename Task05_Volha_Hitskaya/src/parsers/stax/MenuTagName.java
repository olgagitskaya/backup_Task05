package parsers.stax;

/**
 * Created by Volha_Hitskaya on 3/2/2017.
 */
public class MenuTagName {

        public static MenuTagName getElementTagName(String element) {
            switch (element) {
                case "dish":
                    return DISH;
                case "price":
                    return PRICE;
                case "description":
                    return DESCRIPTION;
                case "portion":
                    return PORTION;
                case "menu":
                    return MENU;
                case "title":
                    return TITLE;
                case "photo":
                    return PHOTO;
                case "category":
                    return CATEGORY;

                default:
                    throw new EnumConstantNotPresentException(MenuTagName.class, element);
            }
        }
    }
