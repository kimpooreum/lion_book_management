package org.poopoo.book_management.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.poopoo.book_management.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    private final Map<Integer, Author> store = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<Author> findAll() {
        return new ArrayList<>(store.values());
    }

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(seq.incrementAndGet());
        }
        store.put(author.getId(), author);

        return author;
    }

    public Optional<Author> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public Author update(Integer id, Author updatedAuthor) {
        if (!store.containsKey(id)) {
            throw new NoSuchElementException(id +"의 저자가 없습니다.");
        }

        updatedAuthor.setId(id);
        store.put(id, updatedAuthor);

        return updatedAuthor;
    }

    public void delete(Integer id) {
        store.remove(id);
    }
}
