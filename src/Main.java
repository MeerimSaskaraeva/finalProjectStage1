import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.

        Book book1 = new Book(1L, "MOON", Genre.FANTASY, BigDecimal.valueOf(1000), "SOME", Language.ENGLISH, LocalDate.of(2002, 3, 4));
        Book book2 = new Book(2L, "MOON", Genre.DETECTIVE, BigDecimal.valueOf(2000), "MEN", Language.ENGLISH, LocalDate.of(2012, 3, 4));
        Book book3 = new Book(3L, "MOON", Genre.ROMANCE, BigDecimal.valueOf(3000), "WOMAN", Language.ENGLISH, LocalDate.of(2022, 3, 4));
        Book book4 = new Book(4L, "MOON", Genre.HISTORICAL, BigDecimal.valueOf(4000), "KIDS", Language.ENGLISH, LocalDate.of(2013, 3, 4));
        Book book5 = new Book(5L, "MOON", Genre.FANTASY, BigDecimal.valueOf(1000), "SOME", Language.ENGLISH, LocalDate.of(2009, 3, 4));

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        BookServiceImpl bookService = new BookServiceImpl();

        while (true) {

            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1 -> System.out.println(bookService.createBooks(bookList));
                case 2 -> System.out.println(bookService.getAllBooks());
                case 3 -> System.out.println(bookService.getBooksByGenre(Arrays.toString(Genre.values())));
                case 4 -> {
                    Scanner scan = new Scanner(System.in);
                    System.out.println(bookService.removeBookById(scan.nextLong()));
                }
                case 5 -> System.out.println(bookService.sortBooksByPriceInDescendingOrder());
                case 6-> System.out.println(bookService.filterBooksByPublishedYear());
                case 7-> System.out.println(bookService.maxPriceBook());
            }

        }
    }
}