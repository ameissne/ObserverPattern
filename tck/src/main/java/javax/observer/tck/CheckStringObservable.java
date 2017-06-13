package javax.observer.tck;

import javax.observer.Observable;
import javax.observer.Subscription;
import java.util.Objects;

/**
 * @author AMeissne
 */
public class CheckStringObservable {
    
    public static void checkStringObservableBasicMethods(final Observable<String> observable) {
        Objects.requireNonNull(observable);
        observable.getValue();
        observable.value();
        observable.value().orElse(null);

        Subscription willChangeSubscription = observable.onWillChange(e -> new RuntimeException("FAIL"));
        willChangeSubscription.unsubscribe();

        Subscription changedSubscription = observable.onChanged(e -> new RuntimeException("FAIL"));
        changedSubscription.unsubscribe();
    }

}
