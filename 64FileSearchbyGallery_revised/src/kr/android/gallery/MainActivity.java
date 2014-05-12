package kr.android.gallery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
     
public class MainActivity extends ActionBarActivity 
                          implements OnClickListener{

	ImageView photo;
	Button btn;
	TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		photo = (ImageView)findViewById(R.id.image);
		text = (TextView)findViewById(R.id.text);
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//�������� ȣ���ؼ� �޴����� ����� �̹����� �о����
		
		//ŶĹ������ ����ϴ� ���
		//Intent intent = new Intent();
		//intent.setAction(Intent.ACTION_GET_CONTENT);
		
		//ŶĹ ȣȯ���� ���� ��� ���
		Intent intent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		
		//image/jpeg,image/png,image/gif ...
		intent.setType("image/*");
		startActivityForResult(intent, 0);
	}
	
	//Activity ȣ���ؼ� ������� �����͸� ���޹޴� �޼���
	@Override
	protected void onActivityResult(int requestCode,
			              int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, 
				data);
		if(data!=null){
			FileOutputStream fileOut = null;
			try{
				Uri uri = data.getData();
				
				//ImageView�� �̹��� �����ֱ�
				//ŶĹ ȣȯ���� ���� ���� ��� : 
				//READ_EXTERNAL_STORAGE �߰�
				Bitmap image = 
				Images.Media.getBitmap(getContentResolver(), uri);
				
				photo.setImageBitmap(image);
				photo.setVisibility(View.VISIBLE);
				
				//�̹��� ���� ���� �� ǥ��
				text.setText("===�̹�������===\n");
				text.append("URI:"+uri.toString()+"\n");
				text.append("Last Path Segment:"+
				                uri.getLastPathSegment()+"\n");
				  
				Cursor c = getContentResolver().query(
						   Images.Media.EXTERNAL_CONTENT_URI, 
						   null, 
						   Images.Media._ID+"=?", 
			           new String[]{uri.getLastPathSegment()}, 
			                                              null);
				if(c.moveToFirst()){
					String imagePath = c.getString(
					c.getColumnIndexOrThrow(Images.Media.DATA));
				
					text.append("�����̹������:"+imagePath+"\n");
					
					File f = new File(imagePath);
					text.append("�̹����뷮:"+f.length()+"\n");
				}
				
				text.append("ũ��:"+image.getWidth()+"*"+
				                    image.getHeight());
				
				text.setVisibility(View.VISIBLE);
				
				//SDCard�� ����� ������ �о�鿩
				//���ø����̼� ���� ������ ����
				fileOut = openFileOutput("test.jpg",MODE_PRIVATE);
				              //����                ����Ƽ  ��Ʈ��
				image.compress(CompressFormat.JPEG, 100, fileOut);
				         
			}catch(Exception e){
				Log.e("FileSearchbyGallery","oi error",e);
			}finally{
				if(fileOut!=null)try{fileOut.close();}catch(IOException e){}
			}
		}
	}
}
