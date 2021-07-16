package com.vaibhavmojidra.workmanagerchainingworkersjava.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker3 extends Worker {

    public MyWorker3(@NonNull @org.jetbrains.annotations.NotNull Context context, @NonNull @org.jetbrains.annotations.NotNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Result doWork() {
        try{
            for(int i=1;i<=10;i++){
                Log.i("MyTag","W3: "+i);
                Thread.sleep(1000);
            }
            return Result.success();
        }catch (Exception e){
            return Result.failure();
        }
    }
}
