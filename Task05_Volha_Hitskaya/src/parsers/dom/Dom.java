package parsers.dom;

import bean.Dish;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volha_Hitskaya on 3/2/2017.
 */
public class Dom {
    public static void main(String[] args) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("menu.xml");
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
        List<Dish> menu = process(reader);

        for (Dish dish : menu) {
            System.out.println(dish.getTitle());
            System.out.println(dish.getPortion());
        }
    } catch(
    XMLStreamException e)

    {
        e.printStackTrace();
    }

}

    private static List<Dish> process(XMLStreamReader reader) throws XMLStreamException {
        List<Dish> menu = new ArrayList<Dish>();
        Dish dish = null;
        MenuTagName elementName = null;
        while (reader.hasNext()) {    // определение типа "прочтённого" элемента (тега)    int type = reader.next();    switch (type) {    case XMLStreamConstants.START_ELEMENT:     elementName = MenuTagName.getElementTagName(reader       .getLocalName());     switch (elementName) {     case FOOD:      food = new Food();      Integer id = Integer.parseInt(reader.getAttributeValue(        null, "id"));      food.setId(id);      break;     }     break;

            case XMLStreamConstants.CHARACTERS:
                String text = reader.getText().trim();

                if (text.isEmpty()) {
                    break;
                }
                switch (elementName) {
                    case TITLE:
                        dish.setTitle(text);
                        break;
                    case PRICE:
                        dish.setPrice(text);
                        break;
                    case DESCRIPTION:
                        dish.setDescription(text);
                        break;
                    case PORTION:
                        Integer portion = Integer.parseInt(text);
                        dish.setPortion(portion);
                        break;
                }
                break;

            case XMLStreamConstants.END_ELEMENT:
                elementName = MenuTagName.getElementTagName(reader.getLocalName());
                switch (elementName) {

                    case DISH:
                        menu.add(dish);
                }
        }

    return menu;
}
}
