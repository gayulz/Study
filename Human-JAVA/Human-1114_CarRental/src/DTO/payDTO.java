package DTO;

public class payDTO extends Rental_Car{
    // Todo : DB Pay Table DTO
    private int day_price;
    private int over_price;

    public int getDay_price() {
        return day_price;
    }

    public void setDay_price(int day_price) {
        this.day_price = day_price;
    }

    public int getOver_price() {
        return over_price;
    }

    public void setOver_price(int over_price) {
        this.over_price = over_price;
    }
}
