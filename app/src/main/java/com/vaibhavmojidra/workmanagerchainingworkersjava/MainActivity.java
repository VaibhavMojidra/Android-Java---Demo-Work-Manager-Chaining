package com.vaibhavmojidra.workmanagerchainingworkersjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.os.Bundle;

import com.vaibhavmojidra.workmanagerchainingworkersjava.databinding.ActivityMainBinding;
import com.vaibhavmojidra.workmanagerchainingworkersjava.workers.MyWorker1;
import com.vaibhavmojidra.workmanagerchainingworkersjava.workers.MyWorker2;
import com.vaibhavmojidra.workmanagerchainingworkersjava.workers.MyWorker3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.startWork.setOnClickListener(v->{
         startWorkers();
        });
    }

    private void startWorkers() {
        WorkManager workManager= WorkManager.getInstance(getApplicationContext());
        OneTimeWorkRequest worker1=new OneTimeWorkRequest.Builder(MyWorker1.class).build();
        OneTimeWorkRequest worker2=new OneTimeWorkRequest.Builder(MyWorker2.class).build();
        OneTimeWorkRequest worker3=new OneTimeWorkRequest.Builder(MyWorker3.class).build();
//        workManager
//                .beginWith(worker1)
//                .then(worker2)
//                .then(worker3)
//                .enqueue();//Chaining Workers
        List<OneTimeWorkRequest> oneTimeWorkRequests=new ArrayList<>();
        oneTimeWorkRequests.add(worker1);
        oneTimeWorkRequests.add(worker2);

        workManager
                .beginWith(oneTimeWorkRequests)
                .then(worker3)
                .enqueue();//Parallel Workers

    }
}