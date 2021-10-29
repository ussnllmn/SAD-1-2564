import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber{
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(String item) {
        super.onNext(item);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
    }

    @Override
    public void onComplete() {
        super.onComplete();
    }
}
