import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher<String> {

    final ExecutorService executor = Executors.newFixedThreadPool(4);
    ArrayList<StringSubscriber> stringSubscribers = new ArrayList<>();
    ArrayList<StringSubscription> subscriptionArrayList = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        StringSubscription stringSubscription = new StringSubscription(executor);

        this.subscriptionArrayList.add(stringSubscription);
        stringSubscription.get_Subscriber((StringSubscriber) subscriber);

        this.stringSubscribers.add((StringSubscriber) subscriber);
        subscriber.onSubscribe(stringSubscription);
        stringSubscription.setClass_type(subscriber.getClass());
    }

    public void publish(String text) {

        for (StringSubscription stringSubscription : subscriptionArrayList) {

            if(stringSubscription.getClass_type() == AlphabetSubscriber.class) {
                Pattern pattern = Pattern.compile("[a-zA-Z]");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()){
                    System.out.format("Found \"%s\" in Text Write into AlphabetSubscriber.txt"+"\n", matcher.group());
                    stringSubscription.send(text);
                }
            }

            if (stringSubscription.getClass_type()== NumberSubscriber.class) {
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    System.out.format("Found \"%s\" in Text Write into NumberSubscriber.txt"+"\n", matcher.group());
                    stringSubscription.send(text);
                }
            }

            if (stringSubscription.getClass_type() == SymbolSubscriber.class){
                Pattern pattern = Pattern.compile("\\W");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()){
                    System.out.format("Found \"%s\" in Text Write into SymbolSubscriber.txt"+"\n", matcher.group());
                    stringSubscription.send(text);
                }
            }
        }
    }
}