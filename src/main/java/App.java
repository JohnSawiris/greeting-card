// Import Spark library
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        // Let Spark look into public folder for additional resources
        staticFileLocation("/public");
        // Setup a route
        get("/", (request, response) -> {
                return new ModelAndView(new HashMap(), "hello.hbs");
            }, new HandlebarsTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            return new ModelAndView(new HashMap(), "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
