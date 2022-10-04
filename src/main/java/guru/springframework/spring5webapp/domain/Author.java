package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(){

    }

    public Author(String nome, String lastName, Set<Book> books) {
        this.nome = nome;
        this.lastName = lastName;
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setNome(String nome){
        this.nome =nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
