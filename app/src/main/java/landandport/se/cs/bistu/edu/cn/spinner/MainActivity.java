package landandport.se.cs.bistu.edu.cn.spinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText et_input;
    String str_input = null;
    double input;

    TextView textResult;

    String spin_choice;
    String spin_unit1;
    String spin_unit2;
    private Spinner choiceSpinner = null;
    private Spinner unitSpinner1 = null;
    private Spinner unitSpinner2 = null;
    ArrayAdapter<String> choiceAdapter = null;
    ArrayAdapter<String> unitAdapter1 = null;
    ArrayAdapter<String> unitAdapter2 = null;
    static int choicePosition = 2;

    private String[] choice = new String[]{"长度", "时间", "质量"};

    private String[][] unit1 = new String[][]
            {
                    {"mm", "cm", "dm", "m", "km"},
                    {"sec", "min", "hour"},
                    {"carat", "gram", "kilogram", "ton"}
            };
    private String[][] unit2 = new String[][]
            {
                    {"mm", "cm", "dm", "m", "km"},
                    {"sec", "min", "hour"},
                    {"carat", "gram", "kilogram", "ton"}
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input = (EditText) findViewById(R.id.et_input);
        setSpinner();

    }

    /*
     * 设置下拉框
     */
    private void setSpinner() {

        textResult = (TextView) findViewById(R.id.textResult);

        choiceSpinner = (Spinner) findViewById(R.id.spinner_choice);
        unitSpinner1 = (Spinner) findViewById(R.id.spinner_unit1);
        unitSpinner2 = (Spinner) findViewById(R.id.spinner_unit2);

        //绑定适配器和值
        choiceAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, choice);
        choiceSpinner.setAdapter(choiceAdapter);
        choiceSpinner.setSelection(2, true);  //设置默认选中项，此处为默认选中第2个值

        unitAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, unit1[2]);
        unitSpinner1.setAdapter(unitAdapter1);
        unitSpinner1.setSelection(0, true);  //默认选中第0个

        unitAdapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, unit2[2]);
        unitSpinner2.setAdapter(unitAdapter2);
        unitSpinner2.setSelection(0, true); //默认选中第0个

        choiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {

                unitAdapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, unit1[position]);
                // 设置二级下拉列表的选项内容适配器
                unitSpinner1.setAdapter(unitAdapter1);
                choicePosition = position;

                unitAdapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, unit2[position]);
                // 设置二级下拉列表的选项内容适配器
                unitSpinner2.setAdapter(unitAdapter2);
                choicePosition = position;

                spin_choice = choiceSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        unitSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin_unit1 = unitSpinner1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        unitSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_input = et_input.getText().toString();
                input = Double.parseDouble(str_input);
                spin_unit2 = unitSpinner2.getSelectedItem().toString();
                double result=0;
                switch (spin_choice) {
                    case "长度":
                        switch (spin_unit1) {
                            case "mm":
                                switch(spin_unit2){
                                    case "mm":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "cm":
                                        result=input/10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "dm":
                                        result=input/100;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "m":
                                        result=input/1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "km":
                                        result=input/1000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "cm":
                                switch(spin_unit2){
                                    case "mm":
                                        result=input*10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "cm":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "dm":
                                        result=input/10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "m":
                                        result=input/100;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "km":
                                        result=input/100000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "dm":
                                switch(spin_unit2){
                                    case "mm":
                                        result=input*100;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "cm":
                                        result=input*10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "dm":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "m":
                                        result=input/10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "km":
                                        result=input/10000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "m":
                                switch(spin_unit2){
                                    case "mm":
                                        result=input*1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "cm":
                                        result=input*100;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "dm":
                                        result=input*10;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "m":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "km":
                                        result=input/1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "km":
                                switch(spin_unit2){
                                    case "mm":
                                        result=input*1000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "cm":
                                        result=input*10000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "dm":
                                        result=input*10000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "m":
                                        result=input*1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "km":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                        }
                        break;

                }
                switch (spin_choice) {
                    case "时间":
                        switch (spin_unit1) {
                            case "sec":
                                switch (spin_unit2) {
                                    case "sec":
                                        result = input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "min":
                                        result = input / 60;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "hour":
                                        result = input / 3600;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "min":
                                switch (spin_unit2) {
                                    case "sec":
                                        result = input * 60;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "min":
                                        result = input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "hour":
                                        result = input / 60;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "hour":
                                switch (spin_unit2) {
                                    case "sec":
                                        result = input *3600;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "min":
                                        result = input * 60;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "hour":
                                        result = input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;

                        }
                        break;

                }
                switch (spin_choice) {
                    case "质量":
                        switch (spin_unit1) {
                            case "carat":
                                switch(spin_unit2){
                                    case "carat":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "gram":
                                        result=input/5;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "kilogram":
                                        result=input/5000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "ton":
                                        result=input/5000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "gram":
                                switch(spin_unit2){
                                    case "carat":
                                        result=input*5;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "gram":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "kilogram":
                                        result=input/1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "ton":
                                        result=input/1000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "kilogram":
                                switch(spin_unit2){
                                    case "carat":
                                        result=input*5000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "gram":
                                        result=input*1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "kilogram":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "ton":
                                        result=input/1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                            case "ton":
                                switch(spin_unit2){
                                    case "carat":
                                        result=input*5000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "gram":
                                        result=input*1000000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "kilogram":
                                        result=input*1000;
                                        textResult.setText("Result:  " + result);
                                        break;
                                    case "ton":
                                        result=input;
                                        textResult.setText("Result:  " + result);
                                        break;
                                }
                                break;
                        }
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


    }
}