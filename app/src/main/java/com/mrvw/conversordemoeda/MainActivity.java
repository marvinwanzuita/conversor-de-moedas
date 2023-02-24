package com.mrvw.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private Button botao;
    private Spinner converterDe;
    private Spinner converterPara;
    private EditText valorMoeda;

    String[] moedaParaConverter = {"Real", "Dólar", "Euro", "Libras Esterlinas", "Peso Argentino", "Peso Chileno"};
    String[] moedaASerConvertido = {"Dólar", "Real", "Euro", "Libras Esterlinas", "Peso Argentino", "Peso Chileno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversor();

    }

    public void conversor(){

        valorMoeda = findViewById(R.id.editTextValorMoeda);
        converterDe = findViewById(R.id.spnConverterDe);
        converterPara = findViewById(R.id.spnConverterPara);
        botao = findViewById(R.id.btnConverter);
        resultado = findViewById(R.id.txtResultado);



        ArrayAdapter<String> adapterParaConverter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                moedaParaConverter);

        ArrayAdapter<String> adapterASerConvertido = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                moedaASerConvertido);

        converterDe.setAdapter(adapterParaConverter);
        converterPara.setAdapter(adapterASerConvertido);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valorMoedaString = valorMoeda.getText().toString();
                Double valorMoedaDouble = Double.parseDouble(valorMoedaString);

                double resultadoConvertido = conversor(moedaParaConverter[converterDe.getSelectedItemPosition()],
                        moedaASerConvertido[converterPara.getSelectedItemPosition()],
                        valorMoedaDouble);

                String resultadoConvertidoString = String.format("%.2f", resultadoConvertido);

                resultado.setText(resultadoConvertidoString);
            }
        });

    }


    public double conversor(String converterDe, String converterPara, double valor){

        switch (converterDe){
            case "Real":
                return conversorReal(valor, converterPara);
            case "Dólar":
                return conversorDolar(valor, converterPara);
            case "Euro":
                return conversorEuro(valor, converterPara);
            case "Libras Esterlinas":
                return conversorLibrasEsterlinas(valor, converterPara);
            case "Peso Argentino":
                return conversorPesoArgentino(valor, converterPara);
            case "Peso Chileno":
                return conversorPesoChileno(valor, converterPara);
            default:
                return valor;
        }

    }

    public double conversorReal(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Dólar":
                return valor * 0.19;
            case "Euro":
                return valor * 0.18;
            case "Libras Esterlinas":
                return valor * 0.16;
            case "Peso Argentino":
                return valor * 38.05;
            case "Peso Chileno":
                return valor * 156.81;
            default:
                return valor;
        }

    }

    public double conversorDolar(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Real":
                return valor * 5.14;
            case "Euro":
                return valor * 0.94;
            case "Libras Esterlinas":
                return valor * 0.83;
            case "Peso Argentino":
                return valor * 195.33;
            case "Peso Chileno":
                return valor * 804.2;
            default:
                return valor;
        }

    }

    public double conversorEuro(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Real":
                return valor * 5.44;
            case "Dólar":
                return valor * 1.06;
            case "Libras Esterlinas":
                return valor * 0.88;
            case "Peso Argentino":
                return valor * 206.94;
            case "Peso Chileno":
                return valor * 852.03;
            default:
                return valor;
        }

    }

    public double conversorLibrasEsterlinas(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Real":
                return valor * 6.17;
            case "Dólar":
                return valor * 1.2;
            case "Euro":
                return valor * 1.13;
            case "Peso Argentino":
                return valor * 234.68;
            case "Peso Chileno":
                return valor * 966.39;
            default:
                return valor;
        }

    }

    public double conversorPesoArgentino(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Real":
                return valor * 0.026;
            case "Dólar":
                return valor * 0.0051;
            case "Euro":
                return valor * 0.0048;
            case "Libras Esterlinas":
                return valor * 0.0043;
            case "Peso Chileno":
                return valor * 4.12;
            default:
                return valor;
        }

    }

    public double conversorPesoChileno(double valor, String outraMoeda){

        switch (outraMoeda){
            case "Real":
                return valor * 0.0064;
            case "Dólar":
                return valor * 0.0012;
            case "Euro":
                return valor * 0.0012;
            case "Libras Esterlinas":
                return valor * 0.001;
            case "Peso Argentino":
                return valor * 0.24;
            default:
                return valor;
        }

    }


}