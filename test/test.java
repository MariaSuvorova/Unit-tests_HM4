package Homework4.test;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepositoryMock;

    @BeforeEach
    void setUp() {     //создаем мок-объект для BookRepository
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
        
    }

    @AfterEach
    void tearDown() {
        bookService = null;
    }

    @Test
    @DisplayName("Проверка поиска книги по id")
    void testFindBookById() {
        when(bookRepositoryMock.findById("741")).thenReturn(new Book("741", "SomeBook", "SomeAuthor"));
        Book result = bookService.findBookById("741");
        assertEquals("SomeBook", result.getTitle());
        assertEquals("SomeAuthor", result.getAuthor());
    }

    @Test
    @DisplayName("Проверяем метод поиска всех книг")
    void testFindAllBooks() {
        when(bookRepositoryMock.findAll())
                .thenReturn(List.of(new Book("741", "SomeBook", "SomeAuthor")));
        List<Book> result = bookService.findAllBooks();
        assertEquals(1, result.size());
    }
}