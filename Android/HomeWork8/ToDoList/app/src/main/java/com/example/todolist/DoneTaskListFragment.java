package com.example.todolist;


import android.os.Bundle;
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
public class DoneTaskListFragment extends Fragment {
    private DoneTaskListAdapter mAdapter;
    private RecyclerView mRecyclerView;


    public DoneTaskListFragment() {
        // Required empty public constructor
    }





    private class DoneTaskListAdapter extends RecyclerView.Adapter<DoneTaskListViweHolder> {
        private List<Task> mDoneTasks;

        public DoneTaskListAdapter(List<Task> doneTasks) {
            this.mDoneTasks = doneTasks;
        }

        public int getItemViewType(int position) {
            if (((Task) this.mDoneTasks.get(position)).isImportant()) {
                return 1;
            }
            return 0;
        }

        public DoneTaskListViweHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(DoneTaskListFragment.this.getActivity());
            if (viewType == 0) {
                view = inflater.inflate(R.layout.fragment_item_list, parent, false);
            } else {
                view = inflater.inflate(R.layout.fragment_item_list_important, parent, false);
            }
            Log.i("TAG", "DoneTaskList mAdapter(onCreateViewHolder)");
            return new DoneTaskListViweHolder(view);
        }

        public void onBindViewHolder(DoneTaskListViweHolder holder, int position) {
            holder.bindTask((Task) this.mDoneTasks.get(position));
            Log.i("TAG", "DoneTaskList mAdapter(onBindeViewHolder)");
        }

        public int getItemCount() {
            return this.mDoneTasks.size();
        }
    }

    private class DoneTaskListViweHolder extends RecyclerView.ViewHolder {
        private View mCurrentItemView;
        private Task mCurrentTask;
        private Button mSetDoneBnt;
        private TextView mSubtitleTxt;
        private TextView mTitleTxt;

        public DoneTaskListViweHolder(View itemView) {
            super(itemView);
            this.mCurrentItemView = itemView;
            this.mTitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_title);
            this.mSubtitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_subtitle);
            this.mSetDoneBnt = (Button) itemView.findViewById(R.id.btn_list_item_done);
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DoneTaskListFragment.this.startActivity(TaskDetailPagerActivity.newIntent(DoneTaskListFragment.this.getActivity(), DoneTaskListViweHolder.this.mCurrentTask.getId(), Integer.valueOf(1)));
                }
            });
        }

        public void bindTask(Task task) {
            this.mCurrentTask = task;
            this.mTitleTxt.setText(task.getTtile());
            if (this.mCurrentTask.isDone()) {
                this.mCurrentItemView.setVisibility(View.VISIBLE);
                this.mSetDoneBnt.setVisibility(View.INVISIBLE);
            } else {
                this.mCurrentItemView.setVisibility(View.INVISIBLE);
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
        View view = inflater.inflate(R.layout.fragment_done_task_list, container, false);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.done_tasks_recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        this.mAdapter = new DoneTaskListAdapter(getDoneTaskList(TaskList.getInstance().getTasks()));
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    private List<Task> getDoneTaskList(List<Task> tasks) {
        List<Task> doneTaskList = new ArrayList();
        for (Task task : tasks) {
            if (task.isDone()) {
                doneTaskList.add(task);
            }
        }
        return doneTaskList;
    }

}