package tasks.task4;

public class Container {
    String company;

    public Container() {
        int i = (int) (Math.random() * 5 + 1);
        switch (i) {
            case 1 -> company = "IKEA";
            case 2 -> company = "21vek";
            case 3 -> company = "Oma";
            case 4 -> company = "Jacobs";
            case 5 -> company = "Adidas";

        }
    }

    @Override
    public String toString() {
        return "Container{ Company: " + company + " }";
    }
}
