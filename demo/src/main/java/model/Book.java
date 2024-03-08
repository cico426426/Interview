package model;

public class Book {
    private int ISBN;
    private String name;
    private String author;
    private String introduction;
    public Book(int ISBN, String name, String author, String introduction){
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }

}
