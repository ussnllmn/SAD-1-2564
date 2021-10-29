import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {
    public StringSubscription stringSubscription;
    public String text;

    public void PrintToFile(String text,String file) throws IOException {
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(text);
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        stringSubscription = (StringSubscription) subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        this.text += item;
        stringSubscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("An error occurred.");
    }

    @Override
    public void onComplete() {
        System.out.println("Complete.");
    }
}
