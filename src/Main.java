import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int moneyPlus = 0; // чтобы мусором не забивать :)
        int moneyMinus = 0;
        Scanner input = new Scanner(System.in);
        while (true){
            list();
            String userWord = input.nextLine();

            if(userWord.equals("end")){
                break;
            }
            int userNumber = Integer.parseInt(userWord);
            switch(userNumber) {
                case 1:
                    System.out.print("Введите сумму дохода: ");
                    String howMoney = input.nextLine();
                    moneyPlus += Integer.parseInt(howMoney);
                    break;

                case 2:
                    System.out.print("Введите сумму расходов : ");
                    howMoney = input.nextLine();
                    moneyMinus += Integer.parseInt(howMoney);
                    break;

                case 3:
                    String name1 = "УСН доходы";
                    String name2 = "УСН доходы минус расходы";

                    int count = (taxEarningsMinusSpendings(moneyPlus,moneyMinus) > taxEarningSpending(moneyPlus)) ? 1 : -1;

                    if(count == 1){
                        result(name1, taxEarningSpending(moneyPlus),  taxEarningsMinusSpendings(moneyPlus,moneyMinus));

                    }else{
                        result(name2,taxEarningsMinusSpendings(moneyPlus,moneyMinus),  taxEarningSpending(moneyPlus));
                    }

                    break;
            }
        }
    }
    public static  void result(String name, int a, int b){
        System.out.println("Мы советуем вам " + name + "\nВаш налог составит: "+ a +" рублей\nНалог на другой системе: "+ b+" рублей \nЭкономия: "+(b-a)+" рублей\n");
    }
    public static void list(){
        System.out.println("Выберите операцию и введите её номер:\n" +
                "1. Добавить новый доход\n" +
                "2. Добавить новый расход\n" +
                "3. Выбрать систему налогообложения");
    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static int taxEarningSpending(int earnings){
        return (int) (earnings * 0.06);
    }
}