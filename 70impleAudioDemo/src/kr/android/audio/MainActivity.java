package kr.android.audio;

import java.io.File;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	MediaPlayer mediaPlayer;
	Button btnPlayLocal, btnPlayServer, btnPlaySDCard, btnPause, btnReplay;
	int playbackPosition = 0;
	
	File sd_path = Environment.getExternalStorageDirectory();
	final String AUDIO_PATH ="http://192.168.0.20:8080/web/girlgeneration.mp3";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnPlayLocal =(Button)findViewById(R.id.btnPlayLocal);
		btnPlayServer =(Button)findViewById(R.id.btnPlayServer);
		btnPlaySDCard =(Button)findViewById(R.id.btnPlaySDCard);		
		btnPause =(Button)findViewById(R.id.btnPause);
		btnReplay =(Button)findViewById(R.id.btnReplay);
		
		btnPlayLocal.setOnClickListener(this);
		btnPlayServer.setOnClickListener(this);
		btnPlaySDCard.setOnClickListener(this);
		btnPause.setOnClickListener(this);
		btnReplay.setOnClickListener(this);	
	}
	
	//�������� ������ �ޱ�
	private void playAudioServer(String url) throws Exception{
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setDataSource(url);
		mediaPlayer.prepare();
		mediaPlayer.start();		
	}
	
	//����Ǿ� �ִ� ������ ȣ��
	private void playAudioLocal() throws Exception{
		mediaPlayer = MediaPlayer.create(this, R.raw.girlgeneration);
		mediaPlayer.start();
	}
	
	//SDCard���� ������ ȣ��
	private void playAudioSD() throws Exception{
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setDataSource(sd_path.getAbsolutePath()+"/"+ "2n1.mp3");
//		mediaPlayer.setDataSource(sd_path.getAbsolutePath()+"/Music/"+ "girlgeneration.mp3");
		mediaPlayer.prepare();
		mediaPlayer.start();		
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		killMediaPlayer();
	}

	//MediaPlayer �ڿ� ����
	private void killMediaPlayer(){
		if(mediaPlayer!=null){
			try{
				mediaPlayer.release();
			}catch(Exception e){
				Log.e("SimpleAudio", "Release Error", e);
			}
		}
	}



	@Override
	public void onClick(View v) {

		if(v.getId()==R.id.btnPlayLocal){			//�������
			//����� ������ ȣ��
			try {
				mediaPlayer.stop();				
				playAudioLocal();		
				
			} catch (Exception e) {
				Log.e("SimpleAudio", "Play Error", e);
			}
		}else if(v.getId()==R.id.btnPlaySDCard){
			//SDCard�� ������ ȣ��
			try {
				mediaPlayer.stop();				
				playAudioSD();				
			} catch (Exception e) {
				Log.e("SimpleAudio", "Play Error", e);
			}
		
		}else if(v.getId()==R.id.btnPlayServer){			
			//�������� ������ ȣ��			
			try {
				mediaPlayer.stop();
				playAudioServer(AUDIO_PATH);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(v.getId()==R.id.btnReplay){	//��� �簳
			if(mediaPlayer!=null && !mediaPlayer.isPlaying()){
				//���������� ��� ��ġ�� �̵�
				mediaPlayer.seekTo(playbackPosition);
				//���
				mediaPlayer.start();				
			}			
			
		}else if(v.getId()==R.id.btnPause){		//��� �Ͻ�����
			
			if(mediaPlayer!=null){
				//�Ͻ����� ������ ��� ��ġ ����
				playbackPosition = mediaPlayer.getCurrentPosition();
				//�Ͻ�����
				mediaPlayer.pause();				
			}			
		}
	}
}