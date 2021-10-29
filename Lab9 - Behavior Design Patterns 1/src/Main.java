import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        StringPublisher publisher = new StringPublisher();
        AlphabetSubscriber alphabetSubscriber = new AlphabetSubscriber();
        NumberSubscriber numberSubscriber = new NumberSubscriber();
        SymbolSubscriber symbolSubscriber = new SymbolSubscriber();

        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(numberSubscriber);
        publisher.subscribe(symbolSubscriber);

        boolean loopInput = true;
        while (loopInput) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter text : ");
            String text = input.nextLine();
            System.out.println("From input text : " + text);
            publisher.publish(text);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text = input.nextLine();
        System.out.println("From input text : "+text);
        publisher.publish(text);
    }
}
