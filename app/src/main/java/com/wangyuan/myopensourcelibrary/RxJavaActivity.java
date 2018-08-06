package com.wangyuan.myopensourcelibrary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.annotation.Annotation;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 51talk on 2018/4/18.
 */

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mIvBitmap;
    Button mBtn;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.button1);
        mIvBitmap = findViewById(R.id.iv_bitmap);

        //RxJava2 俩种观察者 Observable和Flowable， 其中Flowable支持背压。背压是一种处理速度控制策略
        Flowable.just(R.mipmap.ic_launcher_round).map(new Function<Integer, Bitmap>() {
            @Override
            public Bitmap apply(Integer integer) throws Exception {
                return BitmapFactory.decodeResource(getResources(), integer);
            }
        }).subscribeOn(Schedulers.io())
            .subscribe(new Consumer<Bitmap>() {
                @Override
                public void accept(Bitmap bitmap) throws Exception {
                    if(bitmap == null)return;
                    if(mIvBitmap != null)mIvBitmap.setImageBitmap(bitmap);
                }
            });

        //rxjava 1.x.x
//        Observable.just(R.mipmap.ic_launcher_round).map(new Function<Integer, Bitmap>() {
//            @Override
//            public Bitmap apply(Integer integer) {
//                Bitmap b = BitmapFactory.decodeResource(getResources(), integer);
//                return b;
//            }
//        }).subscribeOn(Schedulers.io())//指定Subscribe的运行线程
//        .subscribe(new Consumer<Bitmap>() {
//            @Override
//            public void accept(Bitmap bitmap) {
//                if(bitmap == null)return;
//                if(mIvBitmap != null)mIvBitmap.setImageBitmap(bitmap);
//            }
//        });

        /*Observable.just(Student.parse())
            .flatMap(new Function<Student, ObservableSource<String>>() {
                @Override
                public ObservableSource<String> apply(Student s) throws Exception {
                    return Observable.fromArray(s.courseNameList);
                }
            }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mBtn.setText(mBtn.getText() + "," + s);
            }
        });*/


        /*String[] arr = {"this is ", "from a java", "programmer"};
        Observable.fromArray(arr)
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mBtn.setText(mBtn.getText() + "," + s);
            }
        });*/


        try {
            Annotation[] a = Class.forName("com.wangyuan.myopensourcelibrary.Student").getAnnotations();
            Observable.fromArray(a)/*.flatMap(new Function<Annotation, ObservableSource<String>>() {
                @Override
                public ObservableSource<String> apply(Annotation annotation) throws Exception {
                    return Observable.just(annotation.toString());
                }
            })*/.subscribe(new Consumer<Annotation>() {
                @Override
                public void accept(Annotation annotation) throws Exception {
                    String s = annotation.toString();
                    mBtn.setText(mBtn.getText() + "," + s);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//                .subscribeOn(Schedulers.io())
//            .subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String bitmap) {
//                    //自定义注解
//                    Class<Student> userClass = null;
//                    try {
//                        userClass = (Class<Student>) Class.forName("com.wangyuan.myopensourcelibrary.Student");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    Annotation[] annotations = userClass.getAnnotations();
//                    for (Annotation a : annotations) {
//                        String[] s = ((User)a).value();
//                        for (String item : s) {
//                            bitmap += "," + item;
//                        }
//                    }
//                    mBtn.setText(mBtn.getText() + "," + bitmap);
//                }
//            });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent i = new Intent(this, AnnotationActivity.class);
                startActivity(i);
                break;

            default:

                break;
        }
    }
}
