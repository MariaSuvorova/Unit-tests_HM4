package Homework4.main;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}
