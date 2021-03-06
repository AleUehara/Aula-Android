package br.temporeal.musica;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Exemplo de mp3
 * 
 * @author ricardo
 *
 */
public class TempoRealMusica extends Activity {
	private static final String CATEGORIA = "temporeal";
	private MediaPlayer player;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);

		try {
			player = new MediaPlayer();
			player.setDataSource("/sdcard/linkin_park1.mp3");
			player.prepare();
			player.start();
		} catch (Exception e) {
			Log.e(CATEGORIA,e.getMessage(),e);
		}

		TextView text = new TextView(this);
		text.setText("Exemplo mp3.");
		setContentView(text);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (player != null) {
			player.stop();
			player.release();
		}
	}
}