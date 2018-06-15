package com.zkh.controller;

import com.zkh.exception.CustomException;
import com.zkh.pojo.Book;
import com.zkh.pojo.Movie;
import com.zkh.service.BookService;
import com.zkh.util.ControllerUtil;
import com.zkh.util.DataPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by nfc on 2018-06-14.
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;



    @GetMapping("/list")
    public String list(Model model,Integer p){
        p = p == null ? 1 : (p < 1 ? 1 : p);
        DataPage<Book> page = bookService.selectPage(p,10,6);
        return View("booklist",model,page);
    }

    @GetMapping("/create")
    public String create(){
        return View("create");
    }

    @PostMapping("/create")
    public String createSubmit(Model model, @Valid Book book, BindingResult bindingResult) throws CustomException {
        if(!bindingResult.hasErrors()){
           bookService.insert(book);
            return RedirectTo("/book/booklist");
        }else{
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
        }

        return View("list",model,book);
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) throws CustomException {
        Book book = bookService.findByPrimaryKey(id);
        return View("delete",model,book);
    }

    @GetMapping("/deleteSubmit/{id}")
    public String deleteSubmit(@PathVariable("id") Integer id){
        bookService.deleteByPrimaryKey(id);
        return RedirectTo("/movie/list");
    }

    @GetMapping("/details/{id}")
    public String details(Model model,@PathVariable("id") Integer id) throws CustomException {
        Book book = bookService.findByPrimaryKey(id);
        return View("details",model,book);
    }

    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") Integer id) throws CustomException {
        Book book = bookService.findByPrimaryKey(id);
        return View("edit",model,book);
    }

    @PostMapping("/update")
    public String updateSubmit(Model model,@Validated Book book,BindingResult bindingResult) throws CustomException {
        if(!bindingResult.hasErrors()){
            bookService.updateByPrimaryKey(book.getId(),book);
            return RedirectTo("/movie/list");
        }else{
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
        }

        return View("edit",model,book);
    }
}
