package com.jo.bookmanage.mapper;

import com.jo.bookmanage.bean.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;
import java.util.List;

@Mapper
public interface BookMapper {

    @Cacheable(value = "book",key = "#id")
    @Select("select * from book where id=#{id}")
    public List<Book> getById(int id);

    @Select("select * from book")
    public List<Book> getAll();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into book(name,author,price) values(#{name},#{author},#{price})")
    public int addbook(Book book);

    @Delete("delete from book where id=#{id}")
    public void deletebook(int id);

    @Update("update book set name=#{name},author=#{author},price=#{price} where id=#{id}")
    public void updatebook(Book book);
}
