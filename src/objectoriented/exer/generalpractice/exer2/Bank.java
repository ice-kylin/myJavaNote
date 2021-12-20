package objectoriented.exer.generalpractice.exer2;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank(int sizeOfCustomer) {
        customers = new Customer[sizeOfCustomer];
    }

    public Bank addCustomer(String firstName, String lastName) {
        customers[numberOfCustomer++] = new Customer(firstName, lastName);

        return this;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}
