package br.temporeal.login;

import br.temporeal.domain.Carro;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TelaFormularioCarro extends Activity{
	
	static final int RESULT_SALVAR = 1;
	static final int RESULT_EXCLUIR = 2;
	
	private EditText campoNome;
	private EditText campoPlaca;
	private EditText campoAno;
	private Long id;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		TextView t = new TextView(this);
//		t.setText("aqui será o fomulario do carro");
//		setContentView(t);
		
		setContentView(R.layout.form_carro);
		
		campoNome = (EditText) findViewById(R.id.campoNome);
		campoPlaca= (EditText) findViewById(R.id.campoPlaca);
		campoAno = (EditText) findViewById(R.id.campoAno);
		
		id = null;
		
		Bundle extras = getIntent().getExtras();
		
//		if(extras != null){
//			id = extras.getLong(Carro._ID);
//			
//			if (id != null){
//				Carro c = buscarCarro()
//			}
//		}
		
		Button btSalvar = (Button) findViewById(R.id.btSalvar);
		btSalvar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salvar();
				
			}
		});
	}
	
	public void salvar(){
		int ano = 0;
		try{
			ano = Integer.parseInt(campoAno.getText().toString());
		}catch(NumberFormatException e){
			
		}
		
		Carro carro = new Carro();
		if(id != null){
			carro.id = id;
		}
		
		carro.nome = campoNome.getText().toString();
		carro.placa = campoPlaca.getText().toString();
		carro.ano = ano;
		
		salvarCarro(carro);
		
		setResult(RESULT_OK, new Intent());
		
		finish();
	}

	private void salvarCarro(Carro carro) {
		TelaListaCarros.repositorio.salvar(carro);
		
	}
	
	

}
