package br.temporeal.bemvindo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BemVindo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String login = getIntent().getStringExtra("login");
		
		TextView t = new TextView(this);
		t.setText("Bem Vindo outro Projeto: " + login);
		setContentView(t);
    }
}