package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_book")
    public ModelAndView getAllBook() {
        List<Book> list = bookService.getAllBook();
/*        ModelAndView m = new ModelAndView();
        m.setViewName("bookList");
        m.addObject("book", list);
        return m;*/
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_book";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBooks(mb);
        return "redirect:/my_books";
    }



}