/* RadioButton - ������ ����/����/�� �ؽ�Ʈ ��� 
 * 
 * �̺�Ʈ�ҽ��� �̺�Ʈ ������ ����-�͸� ���� Ŭ���� ���
 * �ʱ��� ���õ� �� ǥ��
 * �ʱ�  ���� ���̿� ��ư ����
 * 
 * --------------------------------------------------------------------------------
 * ���̿���ư �⺻ ���� ������ 
 * java�� xml���� ��� �� �� ������ xml���� ����ȭ �Ͽ� java�ڵ带 ���̴� ���� ����
 * 
*/
package kr.android.radio;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	RadioGroup rGroup;
	TextView tv;
			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        tv = (TextView)findViewById(R.id.textView1);
        
        
        //�ʱ�  ���� ���̿� ��ư ����
        rGroup.check(R.id.radio2);
        
        //�ʱ��� ���õ� �� ǥ��
        RadioButton rb = (RadioButton)findViewById(rGroup.getCheckedRadioButtonId());
        tv.setText("�⺻ ����: "+ rb.getText());       
        
        //�̺�Ʈ�ҽ��� �̺�Ʈ ������ ����-�͸� ���� Ŭ���� ���
        rGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {        	
			
        	//�̺�Ʈ �ڵ鷯
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rb =(RadioButton)findViewById(checkedId);				
				tv.setText( "����� ����: "+ rb.getText());				
			}
		});     
    }
}