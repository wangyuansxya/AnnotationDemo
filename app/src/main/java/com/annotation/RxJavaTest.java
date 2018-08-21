package com.annotation;

import android.graphics.Bitmap;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by 51talk on 2018/4/18.
 */

public class RxJavaTest {


    public static void main(String[] args) {
        //
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("this is");
                emitter.onNext("a java");
                emitter.onNext("programmer");
                emitter.onComplete();
            }
        });

        Observable<String> from = Observable.fromArray("this is ", "from a java", "programmer");

        Observable<String> just = Observable.just("this is ", "just a java", "programmer");



        Observer<String> subscriber = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Subscriber<String> subscriber1 = new Subscriber<String>() {

            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        //observable.subscribe(subscriber);
//        from.subscribe(subscriber);
        just.map(new Function<String, Bitmap>() {
            @Override
            public Bitmap apply(String integer) throws Exception {
                return null;
            }
        }).subscribe(new Observer<Bitmap>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bitmap bitmap) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });



    }

}
