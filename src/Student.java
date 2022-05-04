public class Student extends User {

    private int discount;
    public Student(String name, String sex, String Aadhaar, int discount) {
        this.setName(name);
        this.setSex(sex);
        this.setAadhaar(Aadhaar);
        this.setDiscount(discount);
        this.setCert(0);
        this.setBalance(0);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Name:" + this.getName() + "\nSex:" + this.getSex() +
                "\nAadhaar:" + this.getAadhaar() + "\nDiscount:" + this.getDiscount();
    }

}
