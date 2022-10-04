package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
/*anotação que quer dizer que o será um bean e o spring ficará encarregado de fazer a injeção
de dependencias lembrar que ela é um esteriótipo para as
@Repository, @Service e @Controller*/

public class BootStrapData implements CommandLineRunner {
    final AuthorRepository authorRepository;
    final BookRepository bookRepository;

    final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author bukowski = new Author("Charles", "Bukowski");
        Book book = new Book("Mulheres","798273");
        //cria a ligação entre os dois, adicionando os elementos
        bukowski.getBooks().add(book);
        book.getAuthors().add(bukowski);
        //salvando no banco de dados, lembrar que todas as funcionalidades envolvendo banco estará na repository
        authorRepository.save(bukowski);
        bookRepository.save(book);
        //próximo exemplo
        Author stewart = new Author("James", "Stewart");
        Book book1 = new Book("Calculus 3", "837983");

        stewart.getBooks().add(book1);
        book1.getAuthors().add(stewart);

        authorRepository.save(stewart);
        bookRepository.save(book1);

        Publisher amazon = new Publisher("Amazon","QR 327 conjunto 2","Paraíba",
                "Joao Pessoa", "3213213" );

        publisherRepository.save(amazon);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers "+ publisherRepository.count());

    }

}
