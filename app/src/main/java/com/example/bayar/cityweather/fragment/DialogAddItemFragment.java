package com.example.bayar.cityweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DialogAddItemFragment extends DialogFragment {

    public interface addCityInterface {
        void addCity(String cityName);
    }

    @BindView(R.id.dialog_et)
    EditText name;

    private Unbinder unbinder;
    private MainActivity mListener;

    public static DialogAddItemFragment newInstance() {
        return new DialogAddItemFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_add_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mListener = (MainActivity) getActivity();
    }

    @OnClick(R.id.dialog_cancel_btn) void onCancel() {
        dismiss();
    }

    @OnClick(R.id.dialog_add_btn) void onAdd() {
        String cityName = name.getText().toString();
        mListener.addCity(cityName);
        dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
