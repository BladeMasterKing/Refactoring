package chapter_01.step_03;

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
            Rental each = rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
            // 替换多余临时变量
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
