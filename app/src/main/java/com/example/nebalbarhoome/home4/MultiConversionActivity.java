package com.example.nebalbarhoome.home4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class MultiConversionActivity extends Activity{

    private static final String SPINNER_FROM_POS = "SPINNER_FROM_POS";
    private static final String INPUT_TEXT = "input_text";

    private static final String DIM = "MultiConversionActivity.DIM";
    private static final String VAL = "VAL";

    private Dimension dimension;
    private int dim;
    private double value;
    private String unitName;
    private RecyclerView mRecyclerView;
    private UnitAdapter mUnitAdapter;
    private Spinner SpinnerFrom;
    private ArrayAdapter<String> mArrayAdapter;
    private EditText fromEditText;
    private String unitfrom;
    private int unitfromPos;
    private String input_string;
    private Conversion mConversion;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(SPINNER_FROM_POS, unitName);
        savedInstanceState.putString(INPUT_TEXT, fromEditText.getText().toString());
    }

    public static Intent newIntent(Context context, Dimension dimension, double value , int unitfromPos)
    {
        Intent intent = new Intent(context, MultiConversionActivity.class);
        // extras
        intent.putExtra(DIM, dimension.getId());
        intent.putExtra(VAL, value);
        intent.putExtra(SPINNER_FROM_POS , unitfromPos);

        return intent;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_conversion);
        mConversion = Conversion.getInstance(MultiConversionActivity.this);
        value = getIntent().getDoubleExtra(VAL,0.0);
        unitfromPos = getIntent().getIntExtra(SPINNER_FROM_POS,0);
        dim = getIntent().getIntExtra(DIM,0);
        dimension = Conversion.getInstance(this).getById(dim);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        SpinnerFrom = findViewById(R.id.spinner_from);
        fromEditText = findViewById(R.id.number_input);
        input_string = getIntent().getDataString();
        if (!(input_string == null || input_string.equals("")))
        {
            fromEditText.setText(input_string);
        }
        else if (value != 0)
        {
            String s = value+"";
            fromEditText.setText(s);
        }

        SpinnerFrom.setOnItemSelectedListener(new SpinnerListener());
        mArrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item );
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        fillSpinner(dimension);
        SpinnerFrom.setAdapter(mArrayAdapter);
        SpinnerFrom.setSelection(unitfromPos);

        //setSpinner(dimension);

        // restore saved state
        if(savedInstanceState != null)
        {
            handleSavedInstanceState(savedInstanceState);
        }

        // handle intent extras
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            handleExtras(extras);
        }
        fromEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s)
            {
                try
                {
                    value = Double.parseDouble(fromEditText.getText().toString());
                }
                catch(Exception e)
                {
                    value = 0;
                }
                updateUI();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        updateUI();

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        // restore saved state
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null)
        {
            super.onCreate(savedInstanceState);
            unitName = savedInstanceState.getString(SPINNER_FROM_POS);
            input_string = savedInstanceState.getString(INPUT_TEXT);
        }
    }

    private void handleSavedInstanceState(Bundle savedInstanceState)
    {
    }

    private void handleExtras(Bundle extras)
    {
    }
    class UnitHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;
        private int mIndex;

        UnitHolder (LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.spinner_item, parent, false));
            mTextView = itemView.findViewById(R.id.spinner_text);
        }

        Conversion c = Conversion.getInstance(MultiConversionActivity.this);

        void bind(int index)
        {
            mIndex = index;
            double d = c.convert(value,mArrayAdapter.getItem(unitfromPos),mArrayAdapter.getItem(mIndex));
            String s = d + " " + mArrayAdapter.getItem(mIndex);
            mTextView.setText(s);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public class UnitAdapter extends  RecyclerView.Adapter<UnitHolder>
    {
        @Override
        public UnitHolder onCreateViewHolder (ViewGroup viewGroup, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            return new UnitHolder(inflater, viewGroup);

        }

        @Override
        public void onBindViewHolder (UnitHolder holder, int position)
        {
            holder.bind(position);
        }

        @Override
        public int getItemCount ()
        {
            return mArrayAdapter.getCount();
        }
    }

    private void updateUI()
    {
        if (mUnitAdapter == null) {
            mUnitAdapter = new UnitAdapter();
            mRecyclerView.setAdapter(mUnitAdapter);
        } else {
            mUnitAdapter.notifyDataSetChanged();
        }
    }

    private void fillSpinner(Dimension d){
        mArrayAdapter.clear();

        for (int i = 0; i < d.getUnits().size(); i++) {
            Unit u = d.getUnits().get(i);
            mArrayAdapter.add(u.getLabelResource(i));
        }
        mArrayAdapter.notifyDataSetChanged();
        SpinnerFrom.setSelection(dim);
    }

    public class SpinnerListener implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected (AdapterView<?> adapterView, View view, int i, long l)
        {
            unitfromPos = i;
            Log.d("MultConversionActivity", "onItemSelected");
            updateUI();

        }

        @Override
        public void onNothingSelected (AdapterView<?> adapterView)
        {

        }
    }
    void setSpinner(Dimension dimension1)
    {
        if (dimension1 != null) {
            int spinnerPosition = mArrayAdapter.getPosition(dimension1.getLabelResource());
            SpinnerFrom.setSelection(spinnerPosition);
        }
    }
}
