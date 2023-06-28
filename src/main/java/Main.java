import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();

        int numbOfPersons = getNumbOfPersons(scanner);

        while (true) {
            System.out.println("Введите название товара");
            String nameProduct = scanner.next();
            double price = getPrice(scanner);

            calculator.addProduct(nameProduct, price);

            System.out.println("Товар добавлен");
            System.out.println("Хотите добавить еще один товар? Да/Завершить");
            String answer = scanner.next().toLowerCase();
            if (answer.equals("завершить")) {
                break;
            }
        }

        System.out.println(calculator.products);
        double priceForPerson = calculator.priceForPerson(numbOfPersons);
        String result = formatter.formatRub(priceForPerson);
        System.out.println("Каждый должен заплатить: " + result);
    }

    private static double getPrice(Scanner scanner) {
        double price = 0;
        while (price <= 0) {
            System.out.println("Введите цену в формате \"рублей.копеек\" (например 123.45)");
            String input = scanner.next();
            if (input.length() >= 4 && input.charAt(input.length() - 3) == '.') {
                try {
                    price = Double.parseDouble(input);
                    if (price <= 0) {
                        System.out.println("Цена товара должна быть больше нуля");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Произошла непредвиденная ошибка при преобразовании строки в число.");
                }
            } else {
                System.out.println("Неправильный формат ввода.");
            }
        }
        return price;
    }

    private static int getNumbOfPersons(Scanner scanner) {
        int numbOfPersons = 0;
        while (numbOfPersons <= 1) {
            System.out.println("На сколько человек необходимо разделить счет?");
            String input = scanner.next();
            try {
                numbOfPersons = Integer.parseInt(input);
                if (numbOfPersons <= 1) {
                    System.out.println("Ошибка. Число должно быть больше 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите целое число");
            }
        }
        return numbOfPersons;
    }
}

