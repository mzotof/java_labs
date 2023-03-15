public class Client {
    private final String name;
    private final String email;
    private final String address;
    private double balance;

    public Client(String name, String email, String address, double balance) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void makeTransaction(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return name + " (Email: " + email + ", Address: " + address + ", Balance: $" + balance + ")";
    }
}
