package parsing_json;

        import java.lang.reflect.Field;
        import java.util.ArrayList;
        import java.util.Arrays;

public class ElementCollection extends ArrayList<Element> {

    public Element findByAtomicNumber(int atomic_number) {
        for(Element element : this) {
            if(element.getNumber() == atomic_number) {
                return element;
            }
        }
        return null;
    }

    public Element findByName(String name) {
        for(Element element : this) {
            if(element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection elementCollection = new ElementCollection();
        for(Element element : this) {
            Field[] fields = element.getClass().getDeclaredFields();
            for(Field field : fields) {
                if(field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    try {
                        if(field.get(element).equals(value)) {
                            elementCollection.add(element);
                        } else if (field.get(element) == value) {
                            elementCollection.add(element);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return elementCollection;
    }
}
