package com.model;

public class Review {


    private byte rating;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        Object[] fields = new Object[]{"Рейтинг : ", rating, "Заработная плата: ", salary };
        StringBuilder s = new StringBuilder();
        for (Object field : fields
        ) {
            s.append(field);
        }
        return s.toString();
    }
}
