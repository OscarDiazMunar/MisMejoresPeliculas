package com.oscar.mismejorespeliculas.domain.usecase;

import io.reactivex.observers.DisposableObserver;

/**
 * The type Use case observer.
 *
 * @param <T> the type parameter
 */
public abstract class UseCaseObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
