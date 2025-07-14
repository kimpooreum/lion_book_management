package org.poopoo.book_management.service;


import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.poopoo.book_management.Repository.AuthorRepository;
import org.poopoo.book_management.model.Author;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAll() { return authorRepository.findAll(); }

    public Author getById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("저자 없음"));
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Integer id, Author updatedAuthor) {
        return authorRepository.update(id, updatedAuthor);
    }

    public void delete(Integer id) {
        authorRepository.delete(id);
    }
}
