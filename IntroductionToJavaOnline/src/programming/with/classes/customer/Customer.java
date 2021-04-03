package programming.with.classes.customer;

public class Customer {
    String name = " ";
    String surName = " ";
    String patronymic = " ";
    String adress = " ";
    int cardNum = 0;
    int bankNum = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        String a = String.valueOf(cardNum);
        do {
            System.out.println("Number length -6");
        } while (!(a.length() == 6));
        this.cardNum = cardNum;

    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", adress='" + adress + '\'' +
                ", cardNum=" + cardNum +
                ", bankNum=" + bankNum +
                '}';
    }
}


