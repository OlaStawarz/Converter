package com.example.converter;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private Button btnClear;
    private TextView textView;
    private EditText editText;
    private static final String TAG = "MyActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnSpinner();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        textView.setVisibility(View.INVISIBLE);
    }



    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Euro");
        list.add("Dolary");
        list.add("Funty");
        list.add("Złoty");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);

    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(20);
                //((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTextSize(20);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {


        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnClear = (Button) findViewById(R.id.btnClear);
        editText = (EditText) findViewById(R.id.passValue);
        textView = (TextView) findViewById(R.id.result);

        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                editText.getText().clear();
            }
        });

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String spinner2Choice = spinner2.getSelectedItem().toString();
                String userAmountPassed = editText.getText().toString();
                double convertValue;
                String spinner1current;
                String spinner2current;

               /* Toast.makeText(MainActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();*/

                if (TextUtils.isEmpty(userAmountPassed)){
                    editText.setError("To pole nie może być puste");
                    Log.i(TAG, "Brak kwoty");
                    return;
                }

                if (spinner1.getSelectedItem() == "Euro") {

                    spinner1current = "EUR";
                    switch (spinner2Choice) {
                        case "Funty":
                            spinner2current = "GBP";
                            convertValue = 0.901;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Dolary":
                            spinner2current = "USD";
                            convertValue = 1.1002;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Złoty":
                            spinner2current = "PLN";
                            convertValue = 4.5246;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Euro":
                            sameCurrencyMessage();
                            break;
                    }
                } else if (spinner1.getSelectedItem() == "Funty"){

                    spinner1current = "GBP";
                    switch (spinner2Choice){
                        case "Euro":
                            spinner2current = "EUR";
                            convertValue = 1.1168;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Dolary":
                            spinner2current = "USD";
                            convertValue = 1.2386;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Złoty":
                            spinner2current = "PLN";
                            convertValue = 5.0698;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Funty":
                            sameCurrencyMessage();
                    }
                } else if (spinner1.getSelectedItem() == "Dolary"){

                    spinner1current = "USD";
                    switch (spinner2Choice){
                        case "Euro":
                            spinner2current = "EUR";
                            convertValue = 0.9017;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Funty":
                            spinner2current = "GBP";
                            convertValue = 0.8074;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Złoty":
                            spinner2current = "PLN";
                            convertValue = 4.0933;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Dolary":
                            sameCurrencyMessage();
                    }
                } else {

                    spinner1current = "PLN";
                    switch (spinner2Choice) {
                        case "Euro":
                            spinner2current = "EUR";
                            convertValue = 0.2203;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Funty":
                            spinner2current = "GBP";
                            convertValue = 0.1972;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Dolary":
                            spinner2current = "USD";
                            convertValue = 0.2443;
                            Converter(convertValue, spinner1current, spinner2current);
                            break;
                        case "Złoty":
                            sameCurrencyMessage();
                    }
                }
            }

        });
    }

    private void Converter(double converterAmount, String spinner1current, String spinner2current){
        double val = Double.parseDouble(editText.getText().toString()) * converterAmount;
        textView.setVisibility(View.VISIBLE);
        val *= 100;
        val = Math.round(val);
        val /= 100;
        String pom = String.valueOf(val);
        String message = editText.getText() + " " + spinner1current + " = " + pom + " " + spinner2current;
        textView.setText(message);
    }

    private void sameCurrencyMessage(){
        textView.setVisibility(View.VISIBLE);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setText(R.string.message);
    }
}