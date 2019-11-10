package menumaker.domain.ingredients;

public class DomainUtil {

    public static final String vegetableUrlPrefix = "assets/images/vegetables/";

    public static String createImageUrl(String type, String name) {
        StringBuilder builder = new StringBuilder();
        switch (type) {
            case vegetableUrlPrefix :
                builder.append(vegetableUrlPrefix);
                builder.append(name);
                return builder.toString();
            default:
                return null;
        }
    }
}
