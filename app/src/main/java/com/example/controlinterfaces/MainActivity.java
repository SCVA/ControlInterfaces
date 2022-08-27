package com.example.controlinterfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        findViewById( R.id.button2 ).setOnClickListener( this );
        findViewById( R.id.imageButton ).setOnClickListener( this );
        findViewById( R.id.checkBox ).setOnClickListener( this );
        CheckBox miSegunCkBox = (CheckBox) findViewById( R.id.checkBox2 );
        miSegunCkBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView miPrimerTxt = (TextView) findViewById( R.id.miPrimerTexto );
                if(isChecked){
                    miPrimerTxt.setTextSize( 50 );
                }else{
                    miPrimerTxt.setTextSize( 34 );
                }
            }
        } );
        LinearLayout miLayouPrincipal = (LinearLayout) findViewById( R.id.principal);
        CheckBox opcion = new CheckBox(this);
        opcion.setText("Aleatorio");
        opcion.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        miLayouPrincipal.addView( opcion );
    }

    private void presionarCheck(){
        CheckBox miPrimerCkBox = (CheckBox) findViewById( R.id.checkBox );
        EditText miPasword = (EditText) findViewById( R.id.tPassword );
        if (miPrimerCkBox.isChecked()){
            miPasword.setEnabled( false );
        }else{
            miPasword.setEnabled( true );
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                obtenerPsw();
                break;
            case R.id.imageButton:
                TextView miPrimerTxt = (TextView) findViewById( R.id.miPrimerTexto );
                miPrimerTxt.setText( "Eliminado" );
            case R.id.checkBox:
                presionarCheck();
            default:
                break;
        }
    }

    public void btnAccionarTexto(View v){
        accionarTexto();
    }

    private void accionarTexto(){
        TextView miPrimerTxt = (TextView) findViewById( R.id.miPrimerTexto );
        miPrimerTxt.setText( "Hola" );
        miPrimerTxt.setTextColor( Color.RED );
        miPrimerTxt.setTypeface( Typeface.MONOSPACE, Typeface.BOLD);
        String textoTextView = miPrimerTxt.getText().toString();
        Toast.makeText(this,textoTextView, Toast.LENGTH_LONG).show();
    }

    private void leerPasword(){
        EditText miPasword = (EditText) findViewById( R.id.tPassword );
        miPasword.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                obtenerPsw();
            }
        } );
    }

    private void obtenerPsw(){
        EditText miPasword = (EditText) findViewById( R.id.tPassword );
        String pasword = miPasword.getText().toString();
        Toast.makeText(MainActivity.super.getBaseContext(),pasword, Toast.LENGTH_SHORT).show();
    }

}