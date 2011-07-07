package br.temporeal.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaBemVindo extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String nome = getIntent().getStringExtra("login");
		
		TextView t = new TextView(this);
		t.setText("Bem vindo " + nome);
		setContentView(t);
	}
}
