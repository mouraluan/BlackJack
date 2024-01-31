import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything enter to begin!");
        scan.nextLine();



        int playerCard1= drawRandomCard(), playerCard2 = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(playerCard1) + "\n and a \n " + cardString(playerCard2));


        int sumPlayer = playerCard1 + playerCard2;
        System.out.println("your total is: " + sumPlayer);
        System.out.println("Press anything enter to continue");
        scan.nextLine();

        int dealerCard1 = drawRandomCard(), dealerCard2 = drawRandomCard(), sumDealer = dealerCard1+dealerCard2;
        System.out.println("\n The dealer shows\n" + cardString(dealerCard1) + "\nand has a card facing down\n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

       
        String x = "";
        while (!x.equals("stay")) {
            x = hitOrStay();

            if (x.equals("hit"))  {
                int newcard = drawRandomCard();
                System.out.println("You get a\n" + cardString(newcard));
            
                sumPlayer+=newcard;
                System.out.println("yout total is: " + sumPlayer);
                isBurst(sumPlayer);
                continue;
            }  else if(x.equals("stay")){
                continue;
            }
            else {
                System.out.println("invalid option!");
            }
        }
        
        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are: \n" + cardString(dealerCard1)+"\nand a\n" + cardString(dealerCard2));


        while (sumDealer<17) {
            int newcard = drawRandomCard();
            System.out.println("Dealer gets a\n" + cardString(newcard));
            sumDealer+=newcard;
            System.out.println("Dealer's total is " + sumDealer);
        }
        
        if (sumDealer>21) {
            System.out.println("Bust! Dealer loses");
        } else if(sumPlayer>sumDealer){
            System.out.println("Player wins!");
        }else{
            System.out.println("Dealer wins!");
        }
         scan.close();

    }

    
    public static void isBurst(int sum){
        if(sum>21){
            System.out.println("Bust! Player loses");
            System.exit(0);
        }
    }

    public static String hitOrStay(){
        System.out.println("Do you wanna hit ou stay?");
        String x = scan.nextLine();

        while (!(x.equals("stay") || x.equals("hit"))) {
            System.out.println("Invalid answer");
            scan.nextLine();
        }

        return x;
    }
    public static int drawRandomCard() {
        double num = Math.random();
        int draw = (int)(num * 13) + 1;
        return draw;
    }
    public static String cardString(int cardNumber){
        switch (cardNumber) {
            case 1:
                return                  "   _____\n"+
                                        "  |A _  |\n"+ 
                                        "  | ( ) |\n"+
                                        "  |(_'_)|\n"+
                                        "  |  |  |\n"+
                                        "  |____V|\n";
            case 2: return                   "   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";
            case 3: return "   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            case 4:
            return  "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";
                
            case 5:
            return  "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";
                
            case 6:
            return "   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n";
                
            case 7:
            return  "   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n";
            case 8:
            return "   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";
            case 9:
            return  "   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n";
            case 10:
            return "   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n";
            case 11:
            return "   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";
            case 12:
            return "   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            case 13:
            return   "   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n";
            default:
            return "ERRO! CARTA NAO ENCONTRADA";
        }

       
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }

    }

