package service.impl;

import enums.Genre;
import model.Book;
import service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    List<Book> book = new ArrayList<>();

    @Override
    public List<Book> createBooks(List<Book> books) {
        this.book.addAll(books);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return book;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        List<Book> b = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Write genre: ");
        String g = sc.next();
        for (Book book1 : book) {
            if (book1.getGenre().equals(Genre.valueOf(g))) {
                b.add(book1);
                return b;
            } else {
                return null;
            }


        }
        return b;
    }

    @Override
    public Book removeBookById(Long id) {

        System.out.println(book.removeIf(book2 -> book2.getId().equals(id)));
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {

        return book.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).toList();

    }

    @Override
    public List<Book> filterBooksByPublishedYear() {
        List<Book>b=book.stream().filter(book1 -> book1.getPublishedYear().isAfter(LocalDate.now().minusYears(10))).toList();
        return b;
    }

    @Override
    public List<Book> getBookByInitialLetter() {

        return null;
    }

    @Override
    public Book maxPriceBook() {

        return book.stream().max(Comparator.comparing(Book::getPrice)).orElseThrow();
    }
}
