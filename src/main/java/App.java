import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        },new HandlebarsTemplateEngine());

        get("/form1", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form1.hbs");
        },new HandlebarsTemplateEngine());

        post("/view", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String animalAge = request.queryParams("animalAge");
            String animalHealth = request.queryParams("animalHealth");
            String animalType = request.queryParams("animalType");
            if(animalType.equals("safe")){
                Animal regularAnimal = new Animal(animalName, animalAge, animalHealth, animalType);
                regularAnimal.save();
            }
            else if(animalType.equals("endangered")){
                Endangered endangeredAnimal = new Endangered(animalName, animalAge, animalHealth, animalType);
                endangeredAnimal.save();
            }
            List<Animal> allAnimal= Animal.all();
            model.put("animals", allAnimal);
            return new ModelAndView(model, "view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> allAnimal= Animal.all();
            model.put("animals", allAnimal);
            return new ModelAndView(model, "view.hbs");
        }, new HandlebarsTemplateEngine());

        post("/view1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("rangerName");
            String sightingLocation = request.queryParams("sightingLocation");

            Sightings newSighting1 = new Sightings(rangerName, sightingLocation);
            newSighting1.save();
            List<Sightings> allSightings = Sightings.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "view1.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> allSightings = Sightings.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "view1.hbs");
        }, new HandlebarsTemplateEngine());
    }
}