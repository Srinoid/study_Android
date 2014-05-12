/* CheckBox

import android.widget.CompoundButton;
implements CompoundButton.OnCheckedChangeListener

*/
package kr.android.check;


import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener{

	CheckBox cb;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = (CheckBox)findViewById(R.id.checkBox1);
        
        //�̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
        cb.setOnCheckedChangeListener(this);        
    }
    
    //�̺�Ʈ �ڵ鷯
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		if( isChecked){
			cb.setText("üũ�� ����");
		}else{
			cb.setText("üũ���� ���� ����");
		}
	}   
}