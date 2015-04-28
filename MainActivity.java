package com.example.jose.geotrigger;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class MainActivity extends ActionBarActivity {
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void aniadir(View view) throws FileNotFoundException {
        EditText palabra=(EditText)findViewById(R.id.editText);
        String auxiliar;
        auxiliar =palabra.getText().toString();
        try {
    File ruta_sd = Environment.getExternalStorageDirectory();
    File f = new File(ruta_sd.getAbsolutePath(), "palabras.txt");
    OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f,true));
            fout.write(auxiliar+"\n");
            fout.close();
            Toast.makeText(this,"Añadido con exito",Toast.LENGTH_LONG).show();
            contador++;
}catch (Exception e){
    Log.e("FIcheros","Error al escribir en el fichero");
}

    }

    public void mostrar(View view){
        TextView text=(TextView)findViewById(R.id.textView);
        try{

            File ruta_sd=Environment.getExternalStorageDirectory();
            File f=new File(ruta_sd.getAbsolutePath(),"palabras.txt");
            BufferedReader fin= new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            String auxiliar ="";
            contador=0;
            while(texto!=null) {
                contador++;
                auxiliar=auxiliar+texto+"\n";
                texto=fin.readLine();
            }
            text.setText(auxiliar);
                fin.close();
        }catch (Exception ignored){

        }

    }

    public void delete(View view){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "palabras.txt");
            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
            fout.close();
            Toast.makeText(this,"Eliminado todo el fichero",Toast.LENGTH_LONG).show();
            contador=0;
        }catch (Exception ignored){

        }
    }

    public void random(View view){
        

    }


}
