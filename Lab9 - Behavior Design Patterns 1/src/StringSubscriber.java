import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {
    private StringSubscription stringSubscription;
    private String Data;

    public void StringSubscriber(String item,String file) throws IOException {

    }
    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(String item) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
