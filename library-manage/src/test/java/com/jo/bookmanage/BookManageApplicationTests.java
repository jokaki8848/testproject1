package com.jo.bookmanage;

import com.jo.bookmanage.bean.Book;
import com.jo.bookmanage.mapper.BookMapper;
import com.jo.bookmanage.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookManageApplicationTests {

    @Test
    public void addbook(Book book) {

    }

}
