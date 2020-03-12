package com.example.texzad.zad1;

public class User {
    private long id;
    private Vacancy vacancy;

    public User(long id, Vacancy vacancy) {
        this.id = id;
        this.vacancy = vacancy;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    long getId() {
        return id;
    }
}
