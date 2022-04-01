package com.example.tp2303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static Connection conn = null;
    private Button bok;
    private Spinner sp1;
    private EditText pseudo, mdp, cmdp;
    private CheckBox lundi, mardi, mercredi, jeudi, vendredi;
    private RadioButton deb, inter, hautlvl;
    private RadioGroup rg1;
    private String radioSelected;

    ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        bok = (Button) findViewById(R.id.ok);
        sp1 = (Spinner) findViewById(R.id.spinner);
        pseudo = (EditText) findViewById(R.id.editTextTextPersonName3);
        mdp = (EditText) findViewById(R.id.editTextTextPersonName2);
        cmdp = (EditText) findViewById(R.id.editTextTextPersonName);
        lundi = (CheckBox) findViewById(R.id.checkBox);
        mardi = (CheckBox) findViewById(R.id.checkBox3);
        mercredi = (CheckBox) findViewById(R.id.checkBox4);
        jeudi = (CheckBox) findViewById(R.id.checkBox5);
        vendredi = (CheckBox) findViewById(R.id.checkBox6);
        deb = (RadioButton) findViewById(R.id.radioButton);
        inter = (RadioButton) findViewById(R.id.radioButton3);
        hautlvl = (RadioButton) findViewById(R.id.radioButton4);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);

        MysqlConnexion();
    }


    private void MysqlConnexion(){
        String jdbcURL = "jdbc:mysql://10.4.253.120:3306/assos";
        String user = "connect";
        String passwd = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL,user,passwd);
            Toast.makeText(MainActivity.this, "Connexion à la base réussie", Toast.LENGTH_LONG).show();
            Log.i("I/TAG", String.valueOf(conn));

        } catch ( ClassNotFoundException e) {
            Toast.makeText(MainActivity.this, "Driver manquant." + e.getMessage().toString(), Toast.LENGTH_LONG).show();

        } catch ( java.sql.SQLException ex ) {
            Toast.makeText(MainActivity.this, "Connexion au serveur impossible." + ex.getMessage().toString(), Toast.LENGTH_LONG).show();
            Log.d("error", "SQLException: " + ex.getMessage());
            Log.d("error","SQLState: " + ex.getSQLState());
            Log.d("error","VendorError: " + ex.getErrorCode());

            Log.i("I/TAG", String.valueOf(ex));
        }
    }

    public void bok(View view) {

        if (mdp.getText().toString().equals(cmdp.getText().toString()) ) {
            try {
                String sqlins = "insert into inscript (Pseudo, Motdepasse,Association, Disposemaine, Niveau) values (?,?,?,?,?)";
                PreparedStatement pstmins = conn.prepareStatement(sqlins);
                pstmins.setString(1, pseudo.getText().toString());
                pstmins.setString(2, mdp.getText().toString());
                pstmins.setString(3, sp1.getSelectedItem().toString());
                pstmins.setString(4, Arrays.toString(array.toArray()));
                pstmins.setString(5, String.valueOf(rg1));
                pstmins.executeUpdate();

            } catch (SQLException seinst) {
                Toast.makeText(MainActivity.this, "liste." + seinst.toString(), Toast.LENGTH_LONG).show();
                Log.d("MainActivity", seinst.getMessage());
            }
        }
        else
        {
            pseudo.setText("");
            mdp.setText("");
            Toast.makeText(MainActivity.this, "Mots de passe différents", Toast.LENGTH_LONG).show();
        }

    }

    public ArrayList<String> checked(View view)
    {
        array = new ArrayList<String>();

        if(lundi.isChecked())
            array.add(lundi.getText().toString());
        if(mardi.isChecked())
            array.add(mardi.getText().toString());
        if(mercredi.isChecked())
            array.add(mercredi.getText().toString());
        if(jeudi.isChecked())
            array.add(jeudi.getText().toString());
        if(vendredi.isChecked())
            array.add(vendredi.getText().toString());

        Log.i("I/TAG", Arrays.toString(array.toArray()));

        return array;
    }

    public String clickRadio(View view)
    {
        RadioButton radioButton = (RadioButton) findViewById(rg1.getCheckedRadioButtonId());
        radioSelected = String.valueOf(radioButton.getText());
        Log.i("I/TAG", radioSelected);

        return radioSelected;
    }
}