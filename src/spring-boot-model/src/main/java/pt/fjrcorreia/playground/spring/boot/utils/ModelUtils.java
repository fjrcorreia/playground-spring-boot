package pt.fjrcorreia.playground.spring.boot.utils;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import pt.fjrcorreia.playground.spring.boot.api.Author;
import pt.fjrcorreia.playground.spring.boot.api.Book;
import pt.fjrcorreia.playground.spring.boot.model.AuthorTbl;
import pt.fjrcorreia.playground.spring.boot.model.BookTbl;

/**
 * @author Francisco Correia
 */
public class ModelUtils {


    private static final MapperFacade mapperFacade;

    static {

        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        mapperFacade = factory.getMapperFacade();
    }


    public static Author toAuthor(AuthorTbl authorTbl) {
        return mapperFacade.map(authorTbl, Author.class);
    }


    public static AuthorTbl toAuthorTbl(Author author) {
        return mapperFacade.map(author, AuthorTbl.class);
    }


    public static Book toBook(BookTbl bookTbl) {
        return mapperFacade.map(bookTbl, Book.class);
    }


    public static BookTbl toBookTbl(Book book) {
        return mapperFacade.map(book, BookTbl.class);
    }
}
