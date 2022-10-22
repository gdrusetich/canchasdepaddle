package main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import controller.ConsultorasController;
import model.Consultora;
import model.RepositorioConsultoras;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.transaction.Transaction;

public class Routes {

  public static void main(String[] args) {
    System.out.println("Iniciando servidor");
    
    Spark.port(8080);
    Spark.staticFileLocation("/public");

    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    ConsultorasController consultorasController = new ConsultorasController();
    
    Spark.get("/", consultorasController::listar, engine);

    Spark.get("/blog", (request, response) -> {
      String cookie =  request.session().attribute("contadorVisitas");
      int nro = cookie == null ? 0 : Integer.parseInt(cookie);
      request.session().attribute("contadorVisitas", String.valueOf(nro + 1));
      return new ModelAndView( request.session().attribute("contadorVisitas"), "blog.html.hbs");
    }, engine);

    Spark.get("/consultoras/nueva", consultorasController::nueva, engine);
    Spark.get("/consultoras/:id", consultorasController::buscar, engine);
    Spark.post("/consultoras", consultorasController::crear);

    Spark.exception(PersistenceException.class, (e, request, response) -> {
      response.redirect("/500"); //TODO
    });

    Spark.before((request, response) -> {
      PerThreadEntityManagers.getEntityManager().clear();
    });
  }



}
