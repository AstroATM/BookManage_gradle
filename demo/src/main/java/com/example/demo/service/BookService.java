package com.example.demo.service;

import com.example.demo.form.BookForm;
import com.example.demo.resources.BookRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Book;

@Service
@Transactional
public class BookService {

  @Autowired
  BookRepository repository;

  //データベースから本の一覧を取得する
  public List<Book> findAll() {
    return repository.findAll();
  }

  //データベースにデータを登録する
  public void insert(BookForm bookForm) {
    // データベースに登録する値を保持するインスタンス
    Book book = new Book();

    // 画面から受け取った値をデータベースに保存するインスタンスに渡す
    book.setTitle(bookForm.getTitle());
    book.setPrice(bookForm.getPrice());

    // データベースに登録する
    repository.save(book);
  }
}
