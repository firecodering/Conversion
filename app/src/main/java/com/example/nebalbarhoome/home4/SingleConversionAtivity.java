package com.example.nebalbarhoome.home4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SingleConversionAtivity extends Activity implements AdapterView.OnItemSelectedListener{

    private static final String SPINNER_FROM_POS = "SPINNER_FROM_POS";
    private static final String SPINNER_TO_POS = "SPINNER_TO_POS";
    private static final String INPUT_TEXT = "input_text";
    private Dimension selectedDimension;

    private Spinner SpinnerFrom, SpinnerTo , SpinnerDimension;
    private EditText fromEditText, ResultView;
    private ArrayAdapter<Dimension> dimensionArray;
    private ArrayAdapter<String> unitArrayaAapter;
    private String unitfrom;
    private String unitto;
    private String results;
    private String fromText;
    private Button ButtonAllConvert;
    private int unitfromPos;


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(SPINNER_FROM_POS, unitfrom);
        savedInstanceState.putString(SPINNER_TO_POS, unitto);
        savedInstanceState.putString(INPUT_TEXT, fromEditText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_conversion);
        if (savedInstanceState != null)
        {
            super.onCreate(savedInstanceState);
            unitfrom = savedInstanceState.getString(SPINNER_FROM_POS);
            unitto = savedInstanceState.getString(SPINNER_TO_POS);
            fromText = savedInstanceState.getString(INPUT_TEXT);
        }

        SpinnerDimension = (Spinner)findViewById(R.id.spinner_dimension);
        SpinnerDimension.setOnItemSelectedListener(this);
        dimensionArray =new ArrayAdapter<Dimension>(this,R.layout.spinner_item);
        dimensionArray.setDropDownViewResource(R.layout.spinner_item);
        SpinnerDimension.setAdapter(dimensionArray);
        for(Dimension d: Conversion.getInstance(this).getDimensions()) {
            dimensionArray.add(d);
        }
        dimensionArray.setNotifyOnChange(true);

        SpinnerFrom = (Spinner)findViewById(R.id.spinner_from);
        SpinnerFrom.setOnItemSelectedListener(this);
        SpinnerTo = (Spinner)findViewById(R.id.spinner_to);
        SpinnerTo.setOnItemSelectedListener(this);

        unitArrayaAapter = new ArrayAdapter<String>(this,R.layout.spinner_item);
        unitArrayaAapter.setDropDownViewResource(R.layout.spinner_item);
        SpinnerFrom.setAdapter(unitArrayaAapter);
        SpinnerTo.setAdapter(unitArrayaAapter);

        unitArrayaAapter.setNotifyOnChange(true);

        ResultView = (EditText)findViewById(R.id.editText_to);
        ResultView.setClickable(false);

        ButtonAllConvert = (Button)findViewById(R.id.button_all);
        ButtonAllConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input;
                try
                {
                    input = Double.parseDouble(fromEditText.getText().toString());
                }
                catch (Exception e)
                {
                    input = 0;
                }
                Intent intent = MultiConversionActivity.newIntent(SingleConversionAtivity.this, selectedDimension, Double.parseDouble(String.valueOf(input)),unitfromPos);
                startActivity(intent);
            }
        });

        fromEditText = (EditText)findViewById(R.id.editText_from);

        fromEditText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // change this to method
                textChange();

            }
        });
        if (!(fromText == null || fromText.equals("")))
        {
            fromEditText.setText(fromText);
            textChange();

        }


    }

    private void textChange() {

        Conversion c = Conversion.getInstance(SingleConversionAtivity.this);
        try
        {
            results= c.convert(Double.parseDouble(fromEditText.getText().toString()),unitfrom,unitto)+"";
        }
        catch (Exception e)
        {
            results = "0";
        }
        ResultView.setText(results);

    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){

        if(v.getParent() == SpinnerDimension){

            fillFromToSpinner(dimensionArray.getItem(position));

            SpinnerFrom.setSelection(Dimension.LENGTH);
            SpinnerTo.setSelection(Dimension.LENGTH);

            //If only first spinner is selected and
            //the from and to spinners are not clicked at all
            unitfrom = (String)(SpinnerFrom.getItemAtPosition(Dimension.LENGTH).toString());
            unitto = (String)(SpinnerTo.getItemAtPosition(Dimension.LENGTH).toString());
            //reset the result
            ResultView.setText("");
        }
        else if(v.getParent() == SpinnerFrom){
            unitfrom = (String)(SpinnerFrom.getSelectedItem().toString());
            unitfromPos = SpinnerFrom.getSelectedItemPosition();
            textChange();
        }

        else if(v.getParent() == SpinnerTo){
            unitto = (String)(SpinnerTo.getSelectedItem().toString());
            textChange();
        }
    }


    private void fillFromToSpinner(Dimension d){
        unitArrayaAapter.clear();
        selectedDimension = d;
        for (int i = 0; i < d.getUnits().size(); i++) {
            Unit u = d.getUnits().get(i);
            unitArrayaAapter.add(u.getLabelResource(i));
        }
        unitArrayaAapter.notifyDataSetChanged();
    }


}