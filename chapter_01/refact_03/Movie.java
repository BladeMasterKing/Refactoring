package chapter_01.refact_03;

/**
 * @author jiansheng
 * @version 1.0.0
 * @date 2024/12/22 22:35
 */
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(int _priceCode, String _title) {
        this._priceCode = _priceCode;
        this._title = _title;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        this._priceCode = priceCode;
    }
}
