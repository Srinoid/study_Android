/* �̺�Ʈ ó�� - �͸� ���� Ŭ���� ���

��ư �¿� ũ�� �ø���
-wrap_content: ���� �߽����� ��������� ���ΰ� ��
-match_parent: ����Ϳ� ��ġ

�͸� ���� Ŭ������ Ŭ�� �̺�Ʈ ó��
*/
package kr.android.event2;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {
	
	Button btn;
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button1);
        
        //�̺�Ʈ �ҽ��� �̺�Ʈ ������ �����ϸ鼭 �͸��� Ŭ���� ����
        //OnClickListener�������̽��� ������ �⺻ View����
        btn.setOnClickListener(new View.OnClickListener() {
        	//�̺�Ʈ �ڵ鷯
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateTime();
			}
		});
    }
    
    private void updateTime(){
    	btn.setText(sf.format(new Date()));
    }
}
