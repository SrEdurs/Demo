package es.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import es.demo.model.Pagina;
import es.demo.service.PaginaService;

@Controller
public class HomeController {

    final PaginaService paginaService;

    public HomeController(PaginaService paginaService) {
        this.paginaService = paginaService;
    }

    @GetMapping("/")
    public String getPage(ModelMap interfazConPantalla) {

        Pagina pagina = paginaService.getRepo().findById(1);
        interfazConPantalla.addAttribute("pagina", pagina);
         return "index"; 
    }
    
}
