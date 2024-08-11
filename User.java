import java.util.HashMap;
import java.util.Scanner;
class User {

    
    Scanner sc = new Scanner(System.in);
  //  HashMap <Long,Integer> map = new HashMap<>();
    HashMap <Integer,Integer> balances = new HashMap<>();
    static HashMap<Integer, HashMap<String,String>> hash = new HashMap<Integer,HashMap<String,String>>();

    public void Insert(int n1,int n2,String name)
    {
        if(hash.containsKey(n1))
        {
            System.out.println("ACCOUNT NUMBER ALREADY EXITS");
        }
        else{
            String s = Integer.toString(n2);
            HashMap<String,String> mp = new HashMap<>();
            mp.put("name",name);
            mp.put("pin",s);
            hash.put(n1,mp);
            // System.out.println(hash);
            // System.out.println(hash.get(n1).get("name"));
            System.out.println("PIN Number Created ");
        }
        
    }

    public void Check(int acc,int n1)
    {
        if(hash.containsKey(acc))
        {
        String s = Integer.toString(n1);

        if(hash.get(acc).get("pin").equals(s))
        {
            System.out.println();
            System.out.println("**** WELCOME "+ hash.get(acc).get("name") +" ****");
            System.out.println();
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Transation");
            System.out.println();
            
            int user = acc;
            
            int a = sc.nextInt();
            switch(a)
            {
                case 1:
                System.out.println("Enter amount to Deposit");
                int amt = sc.nextInt();
                if(balances.containsKey(user)){
                int currentBalance = balances.getOrDefault(user, 0);
                int newBalance = currentBalance + amt;
                balances.put(user, newBalance);
                System.out.println("Sucessful");
                }
                else{
                    balances.put(user,amt);
                }
                break;
                case 2:
                    System.out.println("Enter amount to WithDraw");
                    int mon = sc.nextInt();
                    if(balances.containsKey(user)){
                        int currentBalance = balances.getOrDefault(user, 0);
                        int newBalance = currentBalance - mon;
                        if(newBalance > 0){
                            balances.put(user, newBalance);
                            System.out.println("Successful");
                            System.out.println();
                        }
                        else{
                            System.out.println("Insufficent Balance !!!!");
                            System.out.println();
                            return;
                        }
                    }
                    else{
                        System.out.println();
                        System.out.println("Insufficent Balance !!!!");
                    }
                    break;
                case 3:
                    System.out.println("ACCOUNT BalANCE");
                    if(balances.containsKey(user))
                    {
                        System.out.println(balances.get(user));
                    }
                    else{
                        balances.put(user,0);
                        System.out.println(balances.get(user));
                    }
                    break;
                case 4:
                    
                    System.out.println("Enter Transaction ACC number");
                    int accnum = sc.nextInt();
                    System.out.println("Enter your amount ");
                    int amount = sc.nextInt();
                    int current = balances.getOrDefault(user, 0);
                    if(current < amount){
                        System.out.println("Insufficent Balance !!!!");
                        System.out.println();
                        
                    }
                    else{
                    if(hash.containsKey(accnum))
                    {

                        int val = accnum;
                        if(balances.containsKey(val)){
                            int old = balances.getOrDefault(val,0);
                            int newBalance = old + amount;
                            balances.put(val, newBalance);

                            System.out.println("Sucessfully Transactioned");
                            System.out.println();
                        }
                        else{
                            balances.put(val,amount);
                            System.out.println("Sucessfully Transactioned");
                            System.out.println();
                        }
                        int currentBalance = balances.getOrDefault(user, 0);
                        int newBalance = currentBalance - amount;
                        balances.put(user,newBalance);
                    }
                    else{
                        System.out.println("NO ACCOUNT HOLDER");
                        System.out.println();
                    }
                }

            }
        }
        else{
            System.out.println("Invalid Pin Number !!!!");
        }
    }
    else{
        System.out.println("Invalid Account Number");
    }
    
    }
}