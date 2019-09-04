package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class TaskDetailActivity extends SingleFragmentActivity {
    public static final String INTENT_EXTRA_KEY = "com.example.todolist.TaskDetailActivity.activity_intent_key";

    public static Intent newIntent(Context orgin, UUID taskId) {
        Intent intent = new Intent(orgin, TaskDetailActivity.class);
        intent.putExtra(INTENT_EXTRA_KEY, taskId);
        return intent;
    }

    public Fragment createFragment() {
        return TaskDetailFragment.newInstance((UUID) getIntent().getSerializableExtra(INTENT_EXTRA_KEY));
    }
}