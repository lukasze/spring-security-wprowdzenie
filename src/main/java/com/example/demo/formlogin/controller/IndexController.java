package com.example.demo.formlogin.controller;

import com.example.demo.formlogin.model.Book;
import com.example.demo.formlogin.model.BookRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/")
public class IndexController {

    private final BookRepository bookRepository;

    public IndexController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books", bookRepository.findAll());
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/newBook")
    @Secured("ROLE_ADMIN")
    public String newBook(@ModelAttribute("book") Book book, Model model) {
        bookRepository.persist(book);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/";
    }
}
