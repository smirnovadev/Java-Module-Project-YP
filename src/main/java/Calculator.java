public class Calculator {
    double totalPrice = 0;
    String products = "Добавленные товары:";

    public void addProduct(String name, double price) {
        products =  products + "\n" + name;
        totalPrice = totalPrice + price;
    }

    public double priceForPerson(int numbOfPersons) {
        return totalPrice / numbOfPersons;
    }

}

