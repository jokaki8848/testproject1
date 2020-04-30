package com.jo.bookmanage.controller;

import com.jo.bookmanage.bean.Book;
import com.jo.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 去图书信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/books")
    public String getAll(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book/books";
    }

    /**
     * 查询书号
     *
     * @param bid
     * @param model
     * @return
     */
    @PostMapping("/book/query")
    public String getById(@RequestParam("bid") String bid, Model model) {
        List<Book> books = bookService.getById(Integer.parseInt(bid));
        model.addAttribute("books", books);
        return "/book/books";
    }

    /**
     * 去修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/book/{id}")
    public String toEditpage(@PathVariable("id") int id, Model model) {
        List<Book> list = bookService.getById(id);
        Book book = list.get(0);
        model.addAttribute("book", book);
        return "book/addbook";
    }

    /**
     * 修改书本信息
     *
     * @return
     */
    @PutMapping("/book")
    public String update(Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setPrice(price);
        bookService.update(book);
        return "redirect:/books";
    }

    /**
     * 去添加页面
     *
     * @return
     */
    @GetMapping("/book/add")
    public String toAddpage() {
        return "/book/addbook";
    }

    /**
     * 添加书本信息
     *
     * @param book
     * @return
     */
    @PostMapping("/book")
    public String addbook(Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setPrice(price);
        Integer id = bookService.addbook(book);
        return "redirect:/books";
    }

    /**
     * 删除信息
     *
     * @param id
     * @return
     */
    @GetMapping("/book/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }


}
