package org.poopoo.book_management.service;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.poopoo.book_management.Repository.AuthorRepository;
import org.poopoo.book_management.Repository.BookRepository;
import org.poopoo.book_management.model.Book;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("책 없음"));
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Integer id, Book book) {
        getById(id);
        book.setId(id);

        return bookRepository.save(book);
    }


    public void delete(Integer id) {
        bookRepository.delete(id);
    }
}
