package jd.template;

/**
 * Created by jdev on 28.05.2017.
 */
public class Rocket {
    int id;
    String model;

    public Rocket(int id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Rocket{ id=" + id + ", model=" + model+ " }";
    }
}
