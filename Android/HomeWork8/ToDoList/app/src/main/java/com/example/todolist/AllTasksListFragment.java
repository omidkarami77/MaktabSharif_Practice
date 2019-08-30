package com.example.todolist;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.omid.hw88.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
    public class AllTasksListFragment extends Fragment {
    private AllTasksAdapter mAdapter;
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;


    public AllTasksListFragment() {
        // Required empty public constructor
    }


    private class AllTasksAdapter extends RecyclerView.Adapter<AllTasksViewHolder> {
        private List<Task> mAllTasks;

        public AllTasksAdapter(List<Task> allTasks) {
            this.mAllTasks = allTasks;
        }

        public int getItemViewType(int position) {
            if (((Task) this.mAllTasks.get(position)).isImportant()) {
                return 1;
            }
            return 0;
        }

        public AllTasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(AllTasksListFragment.this.getActivity());
            if (viewType == 0) {
                view = inflater.inflate(R.layout.fragment_item_list, parent, false);
            } else {
                view = inflater.inflate(R.layout.fragment_item_list_important, parent, false);
            }
            return new AllTasksViewHolder(view);
        }

        public void onBindViewHolder(AllTasksViewHolder holder, int position) {
            holder.bindTask((Task) this.mAllTasks.get(position));
        }

        public int getItemCount() {
            return this.mAllTasks.size();
        }
    }

    private class AllTasksViewHolder extends RecyclerView.ViewHolder {
        private Task mCurrentTask;
        public Button mSetTaskDoneBtn;
        public TextView mTaskSubtitleTxt;
        public TextView mTaskTitleTxt;

        public AllTasksViewHolder(View itemView) {
            super(itemView);
            this.mTaskTitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_title);
            this.mTaskSubtitleTxt = (TextView) itemView.findViewById(R.id.txt_list_item_subtitle);
            this.mSetTaskDoneBtn = (Button) itemView.findViewById(R.id.btn_list_item_done);
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AllTasksListFragment.this.startActivity(TaskDetailPagerActivity.newIntent(AllTasksListFragment.this.getActivity(), AllTasksViewHolder.this.mCurrentTask.getId(), Integer.valueOf(0)));
                }
            });
            this.mSetTaskDoneBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AllTasksViewHolder.this.mCurrentTask.setDone(true);
                    AllTasksViewHolder.this.mSetTaskDoneBtn.setVisibility(View.INVISIBLE);
                    Snackbar.make(v, "'" + AllTasksViewHolder.this.mCurrentTask.getTtile() + "' was set to done.", -1).show();
                }
            });
        }

        public void bindTask(Task task) {
            this.mCurrentTask = task;
            this.mTaskTitleTxt.setText(task.getTtile());
            if (task.isDone()) {
                this.mSetTaskDoneBtn.setVisibility(View.INVISIBLE);
            } else {
                this.mSetTaskDoneBtn.setVisibility(View.VISIBLE);
                this.mSetTaskDoneBtn.setVisibility(View.VISIBLE);
            }
            String time = task.getTime();
            String date = task.getDate();
            if (time != null && date != null) {
                this.mTaskSubtitleTxt.setText(time + ", " + date);
            } else if (time != null && date == null) {
                this.mTaskSubtitleTxt.setText(time);
            } else if (time == null && date != null) {
                this.mTaskSubtitleTxt.setText(date);
            }
        }
    }


    public void onResume() {
        super.onResume();
        updataUI();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_task_list, container, false);
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.all_tasks_recycler_view);
        this.mFab = (FloatingActionButton) view.findViewById(R.id.fab_all_tasks);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updataUI();
        this.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllTasksListFragment.this.startActivity(TaskDetailActivity.newIntent(AllTasksListFragment.this.getActivity(), null));
            }
        });
        return view;
    }

    public void updataUI() {
        this.mAdapter = new AllTasksAdapter(TaskList.getInstance().getTasks());
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
        this.mAdapter.notifyDataSetChanged();
    }

}