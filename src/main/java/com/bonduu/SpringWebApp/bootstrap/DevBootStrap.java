package com.bonduu.SpringWebApp.bootstrap;

import com.bonduu.SpringWebApp.model.Author;
import com.bonduu.SpringWebApp.model.Book;
import com.bonduu.SpringWebApp.repositories.AuthorRepository;
import com.bonduu.SpringWebApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {
        Author mainAuthor = new Author("Peter", "Molokwu");
        Book book1 = new Book("newDawn", "4546", "Eric Banner");
        mainAuthor.getBooks().add(book1);
        book1.getAuthors().add(mainAuthor);
        authorRepository.save(mainAuthor);
        bookRepository.save(book1);

        Author secAuthor = new Author("Addy", "Snokkle");
        Book book2 = new Book("Celebate", "8979", "Peter Shapiro");
        secAuthor.getBooks().add(book2);

        authorRepository.save(secAuthor);
        bookRepository.save(book2);
    }
}
