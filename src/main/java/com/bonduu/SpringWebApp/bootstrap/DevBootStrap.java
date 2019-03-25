package com.bonduu.SpringWebApp.bootstrap;

import com.bonduu.SpringWebApp.model.Author;
import com.bonduu.SpringWebApp.model.AuthorProfile;
import com.bonduu.SpringWebApp.model.Book;
import com.bonduu.SpringWebApp.model.Publisher;
import com.bonduu.SpringWebApp.repositories.AuthorProfileRepository;
import com.bonduu.SpringWebApp.repositories.AuthorRepository;
import com.bonduu.SpringWebApp.repositories.BookRepository;
import com.bonduu.SpringWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AuthorProfileRepository authorProfileRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AuthorProfileRepository authorProfileRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorProfileRepository = authorProfileRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("First Publishing House");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        AuthorProfile authPro1 = new AuthorProfile();
        authPro1.setDob("1990");
        authPro1.setEmail("abc@123.com");
        authPro1.setGender("Male");
        authorProfileRepository.save(authPro1);


        //Eric
        Author author1 = new Author("Eric", "Evans", authPro1);
        Book  book1 = new Book("Domain Driven Design", "1234", publisher);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);


        //Rod
        AuthorProfile authPro2 = new AuthorProfile();
        authPro2.setGender("Female");
        authPro2.setEmail("ada@abc.com");
        authPro2.setDob("1991");
        authorProfileRepository.save(authPro2);
        Author author2 = new Author("Rod", "Johnson", authPro2);
        Publisher publisher2 = new Publisher();


        publisher2.setName("Second Publishing House");
        publisher2.setAddress("11, Adu street, Ogba.");
        publisherRepository.save(publisher2);

        Book book2 = new Book("J2EE Development without EJB", "23444", publisher2 );
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
