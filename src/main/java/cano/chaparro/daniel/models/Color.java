package cano.chaparro.daniel.models;

public class Color {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantoneValue;

    public Color(int id, int year, String color, String pantoneValue) {
        this.id = id;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantoneValue;
    }

    public Color() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }

    public void setPantoneValue(String pantoneValue) {
        this.pantoneValue = pantoneValue;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", pantoneValue='" + pantoneValue + '\'' +
                '}';
    }
}
