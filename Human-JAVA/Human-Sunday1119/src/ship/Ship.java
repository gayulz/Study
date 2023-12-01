package ship;

public class Ship {
    public String name;
    public String color;
    public String capacity;


    public String toString(){
        return String.format("Ship { name : '%s', color : '%s', logo : '%s' }\n", name, color, capacity);
    }
}
