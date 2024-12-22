package chapter_01.step_02;

/**
 * @author jiansheng
 * @version 1.0.0
 * @date 2024/12/22 22:39
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(int _daysRented, Movie _movie) {
        this._daysRented = _daysRented;
        this._movie = _movie;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
