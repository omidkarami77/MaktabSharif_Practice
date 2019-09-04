package com.example.todolist;



import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.omid.hw88.R;

import java.util.Calendar;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {
    public static final String ARG_TASK_ID = "com.example.todolist.TaskDetailFragment.arg_task_id";
    private Button mCancelBtn;
    private Task mCurrentTask;
    private UUID mCurrentTaskId;
    private Button mDateBtn;
    private Button mDeleteBtn;
    private EditText mDescriptionEdt;
    private Button mDoneBtn;
    private CheckBox mIsDoneChk;
    private CheckBox mIsImportantChk;
    private Button mTimeBtn;


    public TaskDetailFragment() {
        // Required empty public constructor
    }

    public static TaskDetailFragment newInstance(UUID taskId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID, taskId);
        TaskDetailFragment fragment = new TaskDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentTaskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        if (mCurrentTaskId == null) {
            mCurrentTask = new Task();
        } else {
            mCurrentTask = TaskList.getInstance().getTask(mCurrentTaskId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_task_detail, container, false);
        mDescriptionEdt = (EditText) view.findViewById(R.id.edt_detail_description);
        mDateBtn = (Button) view.findViewById(R.id.btn_detail_date);
        mTimeBtn = (Button) view.findViewById(R.id.btn_detail_time);
        mIsImportantChk = (CheckBox) view.findViewById(R.id.chk_detail_important);
        mIsDoneChk = (CheckBox) view.findViewById(R.id.chk_detail_done);
        mCancelBtn = (Button) view.findViewById(R.id.btn_detail_cancel);
        mDoneBtn = (Button) view.findViewById(R.id.btn_detail_done);
        if (mCurrentTaskId != null) {
            mDescriptionEdt.setText(mCurrentTask.getTtile());
            mDateBtn.setText(mCurrentTask.getDate());
            mTimeBtn.setText(mCurrentTask.getTime());
            mIsImportantChk.setChecked(mCurrentTask.isImportant());
            mIsDoneChk.setChecked(mCurrentTask.isDone());
            mDoneBtn.setText("Update");
            mDeleteBtn = (Button) view.findViewById(R.id.btn_detail_delete_off);
            mDeleteBtn.setVisibility(8);
            mDeleteBtn = (Button) view.findViewById(R.id.btn_detail_delete_on);
        } else {
            mDeleteBtn = (Button) view.findViewById(R.id.btn_detail_delete_on);
            mDeleteBtn.setVisibility(8);
            mDeleteBtn = (Button) view.findViewById(R.id.btn_detail_delete_off);
        }
        mDescriptionEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TaskDetailFragment.this.mCurrentTask.setTtile(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        this.mDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentCalender = Calendar.getInstance();
                DatePickerDialog mDataPicker = new DatePickerDialog(TaskDetailFragment.this.getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        String dateFormat = String.format("%02d/%02d/%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)});
                        TaskDetailFragment.this.mDateBtn.setText(dateFormat);
                        TaskDetailFragment.this.mCurrentTask.setDate(dateFormat);
                    }
                }, mCurrentCalender.get(1), mCurrentCalender.get(2), mCurrentCalender.get(5));
                mDataPicker.setTitle("Set Task Date");
                mDataPicker.show();
            }
        });
        mTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                TimePickerDialog mTimePicker = new TimePickerDialog(TaskDetailFragment.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String timeFormat = String.format("%02d:%02d", new Object[]{Integer.valueOf(hourOfDay), Integer.valueOf(minute)});
                        TaskDetailFragment.this.mTimeBtn.setText(timeFormat);
                        TaskDetailFragment.this.mCurrentTask.setTime(timeFormat);
                    }
                }, mCurrentTime.get(11), mCurrentTime.get(12), true);
                mTimePicker.setTitle("Set Task Time");
                mTimePicker.show();
            }
        });
        mIsImportantChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TaskDetailFragment.this.mCurrentTask.setImportant(isChecked);
            }
        });
        this.mIsDoneChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TaskDetailFragment.this.mCurrentTask.setDone(isChecked);
            }
        });
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDetailFragment.this.getActivity().finish();
            }
        });
        mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskList.getInstance().removeTask(TaskDetailFragment.this.mCurrentTask);
                Toast.makeText(TaskDetailFragment.this.getActivity(), "Task Deleted.", 0).show();
                TaskDetailFragment.this.getActivity().finish();
            }
        });
        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TaskDetailFragment.this.mCurrentTask.getTtile() != null) {
                    if (TaskDetailFragment.this.mCurrentTaskId == null) {
                        TaskList.getInstance().addTask(TaskDetailFragment.this.mCurrentTask);
                        Toast.makeText(TaskDetailFragment.this.getActivity(), "New Task Added.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TaskDetailFragment.this.getActivity(), "Task Updated.", Toast.LENGTH_SHORT).show();
                    }
                    TaskDetailFragment.this.getActivity().finish();
                    return;
                }
                Snackbar.make(v, (CharSequence) "Title Must Be Set!", -1).show();
            }

        });
        return view;
    }
}