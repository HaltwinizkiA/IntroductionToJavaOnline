package programming_with_classes.bank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bank {
Client[] clients;
Scanner scanner=new Scanner(System.in);
public Bank createBank(){
    Bank bank=new Bank();
    bank.clients=new Client[3];
    bank.clients[0]=new Client("Lesha",new Account[3]);
    bank.clients[0].accounts[0]=new Account(9875,450,true);
    bank.clients[0].accounts[1]=new Account(9876,-500,true);
    bank.clients[0].accounts[2]=new Account(9877,400,true);
    bank.clients[1]=new Client("Sasha",new Account[2]);
    bank.clients[1].accounts[0]=new Account(5012,50,true);
    bank.clients[1].accounts[1]=new Account(5013,6000,false);
    bank.clients[2]=new Client("Max",new Account[4]);
    bank.clients[2].accounts[0]=new Account(4202,0,true);
    bank.clients[2].accounts[1]=new Account(4203,1000,false);
    bank.clients[2].accounts[2]=new Account(4201,200,true);
    bank.clients[2].accounts[3]=new Account(4203,-20,true);

    searchUnlockAccount(bank.clients[1]);
    searchUnlockAccount(bank.clients[2]);
    sortAccount(bank.clients[0]);
    getBalance(bank.clients[0]);
    getBalance(bank.clients[1]);
    getBalance(bank.clients[2]);
    negativeBalance(bank.clients[0]);
    negativeBalance(bank.clients[1]);
    positiveBalance(bank.clients[0]);

    return bank;
}
public Account blockOrUnlocking(Account account){
    System.out.println("1-block 2-unlock");
    switch (scanner.nextInt()) {

        case 1->account.state=false;
        case 2->account.state=true;
        default -> account.state=false;
    }
    return account;

}
public void searchUnlockAccount(Client client){
    System.out.println("Client name :"+client.name);
for (int i=0;i<client.accounts.length;i++){

    if (client.accounts[i].state){
        System.out.println(client.accounts[i]);
    }
}

}
public Client sortAccount(Client client){
    System.out.println("sort account by value :"+client.name);
    Arrays.sort(client.accounts,new SortByBalance());
    for (Account ac:client.accounts){
        System.out.println(ac.toString());
    }

    return client;

}
public double getBalance(Client client){
    double balance=0;
    for (int i=0;i<client.accounts.length;i++){
        if (client.accounts[i].state){
        balance+=client.accounts[i].value;}
    }
    System.out.println("Client :"+client.name+" balance: "+balance);
    return balance;
}
public double negativeBalance(Client client){
    double negative=0;
    for (int i=0;i<client.accounts.length;i++){
        if (client.accounts[i].state){
        if (client.accounts[i].value<0){
        negative+=client.accounts[i].value;
        }
        }
    }
    System.out.println("Client: "+client.name+" negative balance: "+negative);
    return negative;
}
public double positiveBalance(Client client){
    double positive=0;
    for (int i=0;i<client.accounts.length;i++){
        if (client.accounts[i].state){
            if (client.accounts[i].value>0){
                positive+=client.accounts[i].value;
            }
        }
    }
    System.out.println("Client: "+client.name+" positive balance: "+positive);
    return positive;
}

class SortByBalance implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        if (o1.value>o2.value){
            return 1;
        }
        if (o1.value<o2.value){
            return -1;
        }
        return 0;
    }
}
}
//4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//        счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//        всем счетам, имеющим положительный и отрицательный балансы отдельно.
