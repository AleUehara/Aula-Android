package br.temporeal.sms;

import br.livroandroid.utils.Notificacao;
import br.livroandroid.utils.Sms;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

/**
 * BroadcastReceiver que exibe um alerta Toast quando um SMS e recebido
 * 
 */
public class ReceberSms extends BroadcastReceiver {
	private static final String CATEGORIA = "temporeal";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(CATEGORIA, ">" + intent.getAction());

		Sms sms = new Sms();
		//L� a mensagem
		SmsMessage msg = sms.receberMensagem(intent);
		String celular = msg.getDisplayOriginatingAddress();
		String mensagem = msg.getDisplayMessageBody();

		String texto = "ReceberSms: recebeu sms[" + celular + "] -> " + mensagem;

		Log.i(CATEGORIA, texto);

//		Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
		Notificacao n = new Notificacao(context,R.drawable.smile,new Intent("FAZER_ALGO"));
		n.criarNotificacao("Mensagem recebida", "Teste de Notifica��o", "Por favor leia esta notifica��o");
	}
}
