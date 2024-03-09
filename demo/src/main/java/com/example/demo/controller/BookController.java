package com.example.demo.controller;


import com.example.demo.form.BookForm;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
  @Autowired
  BookService service;

  @GetMapping("/book-list")
  public String BookList(Model model) {
    List<Book> bookList = service.findAll();
    model.addAttribute("bookList", bookList);
    return "bookList";
  }

  @GetMapping("/book-create")
  public String createBook(Model model) {
    model.addAttribute("bookForm",new BookForm());

    return "add";
  }

  @PostMapping("/book-create")
  public String saveBook(@ModelAttribute BookForm bookForm, Model model) {
    service.insert(bookForm);

    return "redirect:/book-list";
  }
}
