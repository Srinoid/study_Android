/* ȭ�� �̵�

����Ʈ ����:
��Ƽ��Ƽ�� ��Ƽ��Ƽ ȣ��(�Ű�����)
� ����� ������ ���� �����ϱ� ���� ���

AndroidManifest.xml
��Ƽ��Ƽ �߰��� ���⿡ �ݵ�� ���
-android:versionCode="1"	���ۿ��� �������� ��������
-android:versionName="1.0" 	�Ϲ� ����ڿ��� �������� �������� 

*/
package kr.android.move;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity1 extends Activity implements View.OnClickListener{
	
	Button btnButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		//ID�� �ش�Ǵ� ��ü�� ������ ��ȯ
		btnButton = (Button) findViewById(R.id.button1);
		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
		btnButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// ȭ�� �̵�
		// ����Ʈ ��ü ����
		Intent intent = null;
		if(v.getId()==R.id.button1){
								//���� ��Ƽ��Ƽ, �̵��� ��Ƽ��Ƽ
			intent = new Intent(this, SecondActivity.class);
		}
		//����Ʈ�� �Ű������� ���� ��Ƽ��Ƽ ����
		startActivity(intent);
		
		
	}
	
	
	
	

	

}
