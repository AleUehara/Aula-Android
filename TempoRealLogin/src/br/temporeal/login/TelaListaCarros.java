package br.temporeal.login;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import br.temporeal.domain.Carro;
import br.temporeal.domain.RepositorioCarro;
import br.temporeal.domain.RepositorioCarroScript;

public class TelaListaCarros extends ListActivity{
	
	public static RepositorioCarro repositorio;
	
	private List<Carro> carros;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		repositorio = new RepositorioCarroScript(this);
		atualizarLista();
	}

	protected void atualizarLista() {
		carros = repositorio.listarCarros();
		
		setListAdapter(new CarroListAdapter(this, carros));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Carro carro = carros.get(position);
		Intent it = new Intent(this, TelaFormularioCarro.class);
		it.putExtra(Carro._ID, carro.id);
		startActivityForResult(it, 1);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			atualizarLista();
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		repositorio.fechar();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 0, "Inserir Novo");
		menu.add(0, 1, 1, "Teste");
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Intent it = new Intent(this, TelaFormularioCarro.class);
			startActivity(it);
		case 1:
			break;
		}			
		return true;
	}
}
