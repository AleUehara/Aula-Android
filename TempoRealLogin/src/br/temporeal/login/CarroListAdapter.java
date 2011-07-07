package br.temporeal.login;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.temporeal.domain.Carro;

public class CarroListAdapter extends BaseAdapter{
	
	private Context context;
	private List<Carro> lista;

	public CarroListAdapter(Context context, List<Carro> carros) {
		this.context = context;
		this.lista = carros;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Carro c = lista.get(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.detalhes_carro, null);
		
		TextView nome = (TextView) view.findViewById(R.id.nome);
		nome.setText(c.nome);
		
		TextView placa= (TextView) view.findViewById(R.id.placa);
		placa.setText(c.placa);

		TextView ano = (TextView) view.findViewById(R.id.ano);
		ano.setText(String.valueOf(c.ano));
		
		
		return view;
	}
	
}