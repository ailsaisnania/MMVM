package com.example.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private  MutableLiveData<Integer> _result = new MutableLiveData<>(); //untuk mengamati perubahan data dari class lain
    public LiveData<Integer> result = _result; //hasil dari perubahan value disimpan secara statis dengan live data

//    method operasi perhitungan
    void calculate(String width, String height, String length){
        int result = Integer.parseInt(width)*Integer.parseInt(height)*Integer.parseInt(length);
        _result.setValue(result);
    }
}
