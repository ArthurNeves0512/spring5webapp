package guru.springframework.spring5webapp.controller;


import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
lembrando que a controller será onde ficara os endpoints
 */

@Controller
public class BookController {

    final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(path = "/books")
     public String listarLivros(Model model){
            model.addAttribute("books",bookRepository.findAll());

         return "books/list";
     }
}
