package kr.android.gallery;

import java.io.FileOutputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity1 extends ActionBarActivity implements OnClickListener{	
	
	ImageView ivPhoto;
	TextView tvFileInfo;
	Button btnPhotoSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ivPhoto = (ImageView)findViewById(R.id.ivPhoto);
		tvFileInfo = (TextView)findViewById(R.id.tvFileInfo);
		btnPhotoSelect = (Button)findViewById(R.id.btnPhotoSelect);
		//��ư�� �̺�Ʈ �����ʿ� ����
		btnPhotoSelect.setOnClickListener(this);

		
	}

	@Override
	public void onClick(View v) {
		// �������� ȣ���ؼ� �޴����� ����� �̹����� �о����
		Intent intent = new Intent();
		//���� ���ҽ����� ��ϵ��� ACTI ON_GET_CONTENT �� ������ �� �ֵ��� ����
		intent.setAction(Intent.ACTION_GET_CONTENT);
		//image/jpeg, image/png, image/gif�� �̹��������� Ÿ������ ����
		intent.setType("image/*");
		startActivityForResult(intent, 0);		
	}
	
	//Activityȣ���ؼ� ������� �����͸� ���޹޴� �޼ҵ�
		@Override
		public void onActivityResult(int requestCode, int resultCode, Intent data){
			super.onActivityResult(requestCode, resultCode, data);
			
			if(data!=null){
				FileOutputStream fileOutputStream =null;
				try{
					Uri uri = data.getData();
					//�̹��� �信 �̹��� �����ֱ�
														//getContentResolver( )�� �Ű������� �Ͽ� �����͸� ȣ���� �� �ֵ��� ���ִ� ��ü
					Bitmap image = Images.Media.getBitmap(getContentResolver(), uri);
					ivPhoto.setImageBitmap(image);
					ivPhoto.setVisibility(View.VISIBLE);
					
					//�̹��� ���� ���� �� ǥ��
					tvFileInfo.setText("========�̹��� ����===========\n");
					tvFileInfo.append("URI: " + uri.toString()+"\n");
					tvFileInfo.append("Last Path Segemnt: "+uri.getLastPathSegment()+"\n");
					tvFileInfo.setVisibility(View.VISIBLE);
					
				}catch(Exception e){
					
				}finally{
					
				}
			}
		}	

}