package prestongarno.com.core;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;

import java.io.Closeable;

/**
 * Created by preston on 6/7/17.
 *
 * The interface to implement in order to start Firebindings on annotated fields @Firebind
 ****************************************/
public interface Firebindable extends Closeable {

	/*****************************************
     * @return the database reference bound to this ViewModel
     ****************************************/
    DatabaseReference getReference();

    public default void init(F model) {

    }

    /** disconnect all of the Firebase Value/ChildEventListeners
     */
    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    default void close() {
        // TODO disconnect all of the Firebase Value/ChildEventListeners
    }

    /** @return the location of the data, if any
     */
    @Nullable
    static <D extends LiveData<T>, T> DatabaseReference getReferenceOf(D data) {
        // TODO: 6/7/17 just a map for Listeners + String/Db URIs ?
        throw new UnsupportedOperationException("This will be resolved at compile");
    }
}
