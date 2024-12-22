package chapter_01.refact_01;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author jiansheng
 * @version 1.0.0
 * @date 2024/12/22 22:40
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name, Vector<Rental> rentals) {
        this._name = name;
        this._rentals = rentals;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            // Extract Method
            thisAmount = amountFor(each);
//            switch (each.getMovie().getPriceCode()) {
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if (each.getDaysRented() > 2) {
//                        thisAmount += (each.getDaysRented() - 2) * 1.5;
//                    }
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDREN:
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3) {
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    }
//                    break;
//            }
            frequentRenterPoints++;

            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

//    private double amountFor(Rental each) {
//        double thisAmount = 0;
//        switch (each.getMovie().getPriceCode()) {
//            case Movie.REGULAR:
//                thisAmount += 2;
//                if (each.getDaysRented() > 2) {
//                    thisAmount += (each.getDaysRented() - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                thisAmount += each.getDaysRented() * 3;
//                break;
//            case Movie.CHILDREN:
//                thisAmount += 1.5;
//                if (each.getDaysRented() > 3) {
//                    thisAmount += (each.getDaysRented() - 3) * 1.5;
//                }
//                break;
//        }
//        return thisAmount;
//    }
    // 修改变量名，增强可读性
    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2) {
                    result += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (aRental.getDaysRented() > 3) {
                    result += (aRental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
