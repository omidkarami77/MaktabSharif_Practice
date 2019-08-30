package com.example.todolist;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.omid.hw88.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDetailPagerActivity extends AppCompatActivity {
    public static final String EXTRA_TAB_ID = "com.example.omid.hw88.TaskDetailPagerActivity.extra_tab_id";
    public static final String EXTRA_TASK_ID = "com.example.omid.hw88.TaskDetailPagerActivity.extra_task_id";
    private Integer mTabId;
    private Task mTask;
    private UUID mTaskId;
    private List<Task> mTaskList;
    private ViewPager mViewPager;


    public static Intent newIntent(Context orgin, UUID taskId, Integer tabId) {
        Intent intent = new Intent(orgin, TaskDetailPagerActivity.class);
        intent.putExtra(EXTRA_TASK_ID, taskId);
        intent.putExtra(EXTRA_TAB_ID, tabId);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_task_detail_pager);
        this.mViewPager = (ViewPager) findViewById(R.id.task_detail_pager);
        this.mTaskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);
        this.mTabId = Integer.valueOf(getIntent().getIntExtra(EXTRA_TAB_ID, 0));
        this.mTask = TaskList.getInstance().getTask(this.mTaskId);
        switch (this.mTabId.intValue()) {
            case 0:
                this.mTaskList = TaskList.getInstance().getTasks();
                break;
            case 1:
                this.mTaskList = getDoneTaskList(TaskList.getInstance().getTasks());
                break;
            case 2:
                this.mTaskList = getUndoneTaskList(TaskList.getInstance().getTasks());
                break;
            default:
                this.mTaskList = null;
                break;
        }
        this.mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            public Fragment getItem(int position) {
                return TaskDetailFragment.newInstance(((Task) TaskDetailPagerActivity.this.mTaskList.get(position)).getId());
            }

            public int getCount() {
                return TaskDetailPagerActivity.this.mTaskList.size();
            }
        });
        this.mViewPager.setCurrentItem(this.mTaskList.indexOf(this.mTask));
    }

    private List<Task> getDoneTaskList(List<Task> tasks) {
        List<Task> undoneTaskList = new ArrayList();
        for (Task task : tasks) {
            if (!task.isDone()) {
                undoneTaskList.add(task);
            }
        }
        return undoneTaskList;

    }

    private List<Task> getUndoneTaskList(List<Task> tasks) {
        List<Task> undoneTaskList = new ArrayList();
        for (Task task : tasks) {
            if (!task.isDone()) {
                undoneTaskList.add(task);
            }
        }
        return undoneTaskList;
    }

}