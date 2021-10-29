import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private final ExecutorService executor;
    private StringSubscriber stringSubscriber;
    private Object class_type;
    private String text = "";

    public StringSubscription(ExecutorService executor) {
        this.executor = executor;
    }

    public void get_Subscriber(StringSubscriber stringSubscriber){
        this.stringSubscriber = stringSubscriber;
    }

    @Override
    public void request(long n) {
        if (this.text == "")
            this.stringSubscriber.onComplete();
        else {
            String Buffer = this.text.substring(0,this.text.length() < (int)n? this.text.length():(int)n);
            this.text = this.text.substring(this.text.length() < (int)n? this.text.length():(int)n, this.text.length());
            this.stringSubscriber.onNext(Buffer);
        }
    }

    @Override
    public void cancel() {
        System.out.println("Cancel.");
    }

    public void setClass_type(Object type){
        this.class_type = type;
    }

    public Object getClass_type(){
        return this.class_type;
    }

    public void send(String text){
        this.text = text+"\n";
        executor.execute(() -> {
            stringSubscriber.onNext("");
        });
    }
}