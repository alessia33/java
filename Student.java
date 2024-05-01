class Student {
    private int id;
    private String name;
    private double feesPaid;

    // Constructor to initialize a Student object
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.feesPaid = 0;
    }

    // Create a method payFee to use for payment registration
    public void payFee(double amount) {
        // Check if the fee is within the $5000 limit
        if (feesPaid + amount <= 5000) {
            feesPaid += amount;
            System.out.println(name + " has paid $" + amount + " in fees.");
        } else {
            System.out.println("Payment failed. Limit exceeded for " + name);
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

}