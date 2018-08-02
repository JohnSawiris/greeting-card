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
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hello.hbs");
            }, new HandlebarsTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            //Get the user input\
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            // Pass collected data to the model
            model.put("recipient", recipient);
            model.put("sender", sender);
            // Then pass the model to the view
            return new ModelAndView(model, "greeting_card.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
