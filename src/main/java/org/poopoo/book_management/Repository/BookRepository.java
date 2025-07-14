package org.poopoo.book_management.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.poopoo.book_management.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final Map<Integer, Book> store = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public Book save(Book book) {
        if(book.getId() == null) {
            book.setId(seq.incrementAndGet());
        }

        store.put(book.getId(), book);

        return book;
    }



    public void delete(Integer id) {
        store.remove(id);
    }
}