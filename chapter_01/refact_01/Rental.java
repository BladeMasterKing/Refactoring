package chapter_01.refact_01;

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
}
