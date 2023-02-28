import java.util.Scanner;
class Bank_Details
{
    private String Accno;
    private String Name;
    private String Acc_type;
    private long Balance;
    Scanner sc=new Scanner(System.in);

    public void openAccount()
    {
        System.out.println("Enter Account No: ");
        Accno=sc.next();
        System.out.println("Enter Account Holders Name: ");
        Name=sc.next();
        System.out.println("Enter Account Type: ");
        Acc_type=sc.next();
        System.out.println("Enter Balance: ");
        Balance=sc.nextLong();


    }
    public void showAccount()
    {
        System.out.println("Account no: "+Accno);
        System.out.println("Account Holders Name: "+Name);
        System.out.println("Account Type: "+Acc_type);
        System.out.println("Balance: "+Balance);


    }
    public void Deposit()
    {
        long amt;
        System.out.println("Enter the amount to deposit: ");
        amt=sc.nextLong();
        Balance=Balance+amt;
        System.out.println("Balance After Deposit: "+Balance);


    }
    public void Withdraw()
    {
        long amt;
        System.out.println("Enter the amount to Withdraw: ");
        amt=sc.nextLong();

        if(Balance>=amt){
            Balance=Balance-amt;

            System.out.println("Balance After Withdrawal: "+Balance);

        }
        else
        {
            System.out.println("Your Balance is less than "+amt);
            System.out.println("\t Transaction Failed! ");
        }
    }

    public boolean search(String ac_no)
    {
        if(Accno.equals(ac_no))
        {
            showAccount();
            return true;
        }
        return false;
    }


}
public class BankingApp
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many Number of customers do you want to input: ");
        int n=sc.nextInt();

        Bank_Details C[]=new Bank_Details[n];
        for(int i=0;i<C.length;i++)
        {
            C[i]=new Bank_Details();
            C[i].openAccount();
        }

        int ch;
        do
        {
            System.out.println("***** Banking Application System *****");
            System.out.println(" 1.Display All Account Details\n 2.Search By Account Number\n 3.Deposit the amount\n 4.Withdraw the Amount\n 5.Exit\n");
            System.out.println("Enter Choice: ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                for(int i=0;i<C.length;i++)
                {
                    C[i].showAccount();
                }
                break;

                case 2:
                System.out.println("Enter the Account Number You Want to Search: ");
                String ac_no=sc.next();
                boolean found=false;
                for(int i=0;i<C.length;i++)
                {
                    found=C[i].search(ac_no);
                    if(found)
                    {
                        break;
                    }



                }
                if(!found)
                {
                    System.out.println("Search Failed! Account Number Doesn't Exists! ");
                }
                break;
                case 3:
                System.out.println("Enter the Account Number: ");
                ac_no=sc.next();
                found=false;

                for(int i=0;i<C.length;i++)
                {
                    found=C[i].search(ac_no);
                    if(found)
                    {
                        C[i].Deposit();
                        break;
                    }
                  
                }
                if(!found)
                {
                    System.out.println("Search Failed! Account Number Doesn't Exists! ");


                }
                break;
                case 4:
                System.out.println("Enter the Account Number: ");
                ac_no=sc.next();
                found=false;
                for(int i=0;i<C.length;i++)
                {
                    found=C[i].search(ac_no);
                    if(found)
                    {
                        C[i].Withdraw();
                        break;
                    }
                  
                }
                if(!found)
                {
                    System.out.println("Search Failed! Account Number Doesn't Exists! ");


                }
                break;
                case 5:
                System.out.println("See you Soon! ");
                break;



            



        }
        
    }
    while(ch!=5);
}
}

//Contributed by Shreyash