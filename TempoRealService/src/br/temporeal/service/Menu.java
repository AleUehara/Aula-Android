package br.temporeal.service;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Exemplos de Service
 * 
 * @author rlecheta
 * 
 */
public class Menu extends ListActivity {

	private static final String[] ops = new String[] {
		"Iniciar Serviço","Parar Serviço","Iniciar BroadcastReceiver"};

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		int layout = android.R.layout.simple_list_item_1;
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,layout, ops);
		this.setListAdapter(adaptador);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
			case 0:
				startService(new Intent("SERVICE_LEGAL"));
				break;
			case 1:
				stopService(new Intent("SERVICE_LEGAL"));
				break;
			case 2:
				Intent intent = new Intent("RECEIVER_LEGAL");
				intent.putExtra("msg", "Mensagem legal");
				sendBroadcast(intent);
				Toast.makeText(this, "Mensagem enviada a outra aplicação !", Toast.LENGTH_SHORT).show();
				break;
			default:
				finish();
		}
	}
}