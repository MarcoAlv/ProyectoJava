package functions;

public class User {

    private final int _id;
    private String _name;
    private String _lastName;

    private String _userName = null;
    private String _password = null;
    private int _age;
    private Integer _cell;
    private String _url;

    public User(int id, String name, String lastName, String userName, String password, int age, Integer cell, String url) {
        _id = id;
        _name = name;
        _lastName = lastName;
        _userName = userName;
        _password = password;
        _age = age;
        _cell = cell;
        _url = url;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public Integer get_id() {
        return _id;
    }

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public Integer get_cell() {
        return _cell;
    }

    public void set_cell(Integer _cell) {
        this._cell = _cell;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}

