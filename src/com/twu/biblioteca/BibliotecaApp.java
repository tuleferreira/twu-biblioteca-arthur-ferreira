package com.twu.biblioteca;

import org.junit.runner.Computer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library mainLibrary = new Library();

        mainLibrary.addBookToList(new Book(1, "A Game of Thrones", "George R. R. Martin", "Fantasy", "Published in celebration of the twentieth anniversary of George R. R. Martin's landmark series, this lavishly illustrated special edition of A Game of Thrones-with gorgeous full-page illustrations in every chapter-revitalizes the fantasy masterpiece that became a cultural phenomenon.", LocalDate.of(1996, 8, 1), 4));
        mainLibrary.addBookToList(new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", "Pets", "Based on the popular @dog_feelings Twitter account by Matt Nelson of WeRateDogs fame, the Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Planner Calendar will warm the hearts of dog lovers and help keep them on task to allow plenty of time for walks, frens, and snoozles.", LocalDate.of(2019, 8, 1), 2));
        mainLibrary.addBookToList(new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", "Let the magic of J.K. Rowling's classic Harry Potter series take you back to Hogwarts School of Witchcraft and Wizardry. Issued to mark the 20th anniversary of first publication of Harry Potter and the Prisoner of Azkaban, this irresistible Gryffindor House Edition celebrates the noble character of the Hogwarts house famed for its courage, bravery and determination. Harry's third year at Hogwarts is packed with thrilling Gryffindor moments, including the appearance four of its most memorable alumni, Messrs Moony, Wormtail, Padfoot and Prongs!", LocalDate.of(1999, 7, 8), 5));
        mainLibrary.addBookToList(new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", "Computer Science", "'A refreshing variation on the will-intelligent-robots-bring-Armageddon genre . . . this colorful mixture of expert futurology and quirky speculation does not disappoint", LocalDate.of(2019, 7, 16), 4));

        sayHello();

        System.out.println(mainLibrary.showBooks());
    }

    private static void sayHello() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n");
    }
}
