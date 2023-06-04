package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel; //menyimpan dan mengembalikan data yang terikat dengan suatu activity maupun fragment
    private EditText editLength, editWidth, editHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        define letak variabel pada layout
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        editHeight = findViewById(R.id.edit_height);
        editLength = findViewById(R.id.edit_length);
        editWidth = findViewById(R.id.edit_width);
        btnCalculate = findViewById(R.id.button_calculate);
        tvResult = findViewById(R.id.txt_result);

        btnCalculate.setOnClickListener(new View.OnClickListener() { //onclik button

            @Override
            public void onClick(View view) {

                //ambil value dari edit text dan mengubahnya menjadi string
                String length = editLength.getText().toString();
                String width = editWidth.getText().toString();
                String height = editHeight.getText().toString();

//              memberi pesan error
                if (width.isEmpty()){
                    editWidth.setError("Enter Width!");
                } else if(height.isEmpty()){
                    editHeight.setError("Enter Height!");
                }else if(length.isEmpty()){
                    editHeight.setError("Enter Length!");
                }else {
                    viewModel.calculate(width, height, length); //menjalankan method calculate
                }
            }
        });
        displayResult(); //menampilkan hasil (dari method displayResult)
}

private void displayResult(){
        viewModel.result.observe(this, new Observer<Integer>() { //callback Observer berfungsi untuk melakukan perubahan data pada UI.
            @Override
            public void onChanged(Integer result) {
                tvResult.setText(String.valueOf(result));
            }
        });
}
//private void calculate(String width, String height, String length){
//        String result = String.valueOf(Integer.parseInt(width)*Integer.parseInt(height)*Integer.parseInt(length));
//}
}





