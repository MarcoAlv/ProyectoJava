package functions;

public class UserBuilder {
    private final Func functions = new Func();
    private final int _id = Func.getMaxId("usersdata");
    private String _name;
    private String _lastName;
    private String _userName = null;
    private String _password = null;
    private int _age;
    private Integer _cell;
    private final String _url;

    public UserBuilder() {
        if (this._password != null) {
            this._password = functions.passwordGen(new int[]{1,1,1,1},
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                            "!@#$%^&*()_+-={}[]|\\:;\"'<>,.?/0123456789",
                    12);
        }
        this._url = functions.passwordGen(new int[]{1, 1, 0, 1},
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",
                8).concat(String.format("%06d", this._id));
    }

    public User buildUser() {
        boolean wasCreated;
        wasCreated = functions.createUser(this._id, this._name,
                this._lastName, this._userName,
                this._password, this._age,
                this._cell, this._url);

        if (!wasCreated) {
            return null;
        }

        return new User(this._id, this._name,
                this._lastName, this._userName,
                this._password, this._age,
                this._cell, this._url);
    }

    public UserBuilder name(String _name) {
        this._name = _name;
        return this;
    }

    public UserBuilder lastName(String _lastName) {
        this._lastName = _lastName;
        return this;
    }

    public UserBuilder userName(String _userName) {
        this._userName = _userName;
        return this;
    }

    public UserBuilder password(String _password) {
        this._password = _password;
        return this;
    }

    public UserBuilder age(int _age) {
        this._age = _age;
        return this;
    }

    public UserBuilder cell(int _cell) {
        this._cell = _cell;
        return this;
    }

}
