package com.example.todolist;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.omid.hw88.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UndoneTaskListFragment extends Fragment {
    private UndoneTaskAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private class UndoneTaskAdapter extends RecyclerView.Adapter<UndoneTaskViewHolder> {
        private List<Task> mUndoneTasks;

        public UndoneTaskAdapter(List<Task> undoneTasks) {
            this.mUndoneTasks = undoneTasks;
        }

        public int getItemViewType(int position) {
            if (((Task) this.mUndoneTasks.get(position)).isImportant()) {
                return 1;
            }
            return 0;
        }

        public UndoneTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            Log.i("TAG", "UndoneTask Adapter (onCreate view Holder)");
            LayoutInflater inflater = LayoutInflater.from(UndoneTaskListFragment.this.getActivity());
            if (viewType == 0) {
                view = inflater.inflate(R.layout.fragment_item_list, parent, false);
            } else {
                view = inflater.inflate(R.layout.fragment_item_list_important, parent, false);
            }
            return new UndoneTaskViewHolder(view);
        }


        public void onBindViewHolder(UndoneTaskViewHolder holder, int position) {
            Log.i("TAG", "UndoneTask Adapter (onBinde view holder)");
            holder.bindTask((Task) this.mUndoneTasks.get(position));
        }

        public int getItemCount() {
            return this.mUndoneTasks.size();
        }
    }

    private class UndoneTaskViewHolder extends RecyclerView.ViewHolder {
        private View mCurrentItemView;
        private Task mCurrentTask;
        private Button mSetDoneBtn;
        private TextView mSubtitleTxt;
        private TextView mTitleTxt;

        public UndoneTaskViewHolder(View itemView) {
            super(itemView);
            Log.i("TAG", "UndoneTaskLisk View Holder");
            this.mCurrentItemView = itemView;
            this.mTitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_title);
            this.mSubtitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_subtitle);
            this.mSetDoneBtn = (Button) itemView.findViewById(R.id.btn_list_item_done);
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    UndoneTaskListFragment.this.startActivity(TaskDetailPagerActivity.newIntent(UndoneTaskListFragment.this.getActivity(), UndoneTaskViewHolder.this.mCurrentTask.getId(), Integer.valueOf(2)));
                }
            });
            this.mSetDoneBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    UndoneTaskViewHolder.this.mCurrentTask.setDone(true);
                    UndoneTaskViewHolder.this.mCurrentItemView.setVisibility(View.GONE);
                    Snackbar.make(v, "'" + UndoneTaskViewHolder.this.mCurrentTask.getTtile() + "' was set to done.", -1).show();
                }
            });
        }


        public void bindTask(Task task) {
            this.mCurrentTask = task;
            this.mTitleTxt.setText(task.getTtile());
            if (this.mCurrentTask.isDone()) {
                this.mCurrentItemView.setVisibility(View.GONE);
            } else {
                this.mCurrentItemView.setVisibility(View.VISIBLE);
            }
            String time = task.getTime();
            String date = task.getDate();
            if (time != null && date != null) {
                this.mSubtitleTxt.setText(time + ", " + date);
            } else if (time != null && date == null) {
                this.mSubtitleTxt.setText(time);
            } else if (time == null && date != null) {
                this.mSubtitleTxt.setText(date);
            }
        }
    }

    public void onResume() {
        super.onResume();
        updateUI();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_undone_task_list, container, false);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.undone_tasks_recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public void updateUI() {
        this.mAdapter = new UndoneTaskAdapter(getUndoneTaskList(TaskList.getInstance().getTasks()));
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
        this.mAdapter.notifyDataSetChanged();
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