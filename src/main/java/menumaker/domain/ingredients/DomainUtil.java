package menumaker.domain.ingredients;

public class DomainUtil {

    public static final String vegetableUrlPrefix = "assets/images/vegetables/";
    public static final String meatUrlPrefix = "assets/images/meat/";


    public static String createImageUrl(String type, String name) {
        StringBuilder builder = new StringBuilder();
        switch (type) {
            case vegetableUrlPrefix :
                builder.append(vegetableUrlPrefix);
                return buildImageLink(builder,name);
            case meatUrlPrefix :
                builder.append(meatUrlPrefix);
                return buildImageLink(builder,name);
            default:
                return null;

        }
    }

    private static String buildImageLink(StringBuilder builder, String name) {
        builder.append(name);
        builder.append(".png");
        return builder.toString();
    }
}
