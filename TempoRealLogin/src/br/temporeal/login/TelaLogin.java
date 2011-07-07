package br.temporeal.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaLogin extends Activity implements OnClickListener {
	private static final String TAG = "temporeal";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        TextView t1 = (TextView) findViewById(R.id.texto1);
//        t1.settext
        
        Log.i("temporeal", "abriu a tela de login");
        
        //Ex1
        setContentView(R.layout.login);
        
        Button b = (Button) findViewById(R.id.login);
        b.setOnClickListener(this);

    }

	@Override
	public void onClick(View v) {
		TextView tLogin = (TextView) findViewById(R.id.campoLogin); 
		TextView tSenha = (TextView) findViewById(R.id.campoSenha);
		
		String login = tLogin.getText().toString();
		String senha = tSenha.getText().toString();
		
		if("temporeal".equalsIgnoreCase(login) && "123".equals(senha)){
			Log.i(TAG, "Login realizado com sucesso");
			Toast.makeText(this, "Login Correto", Toast.LENGTH_SHORT).show();
			
			Intent intent = new Intent(this, TelaListaCarros.class);
			intent.putExtra("login", login);
			
			startActivity(intent);
		}else{
			Log.i(TAG, "Erro de login. Tente novamente.");
			Toast.makeText(this, "Login incorreto", Toast.LENGTH_SHORT).show();
			
//			AlertDialog dialog = new AlertDialog.Builder(this).create();
//			dialog.setMessage("Login Incorreto");
//			dialog.setButton("OK", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			
			finish();
		}
		
		
	}
}