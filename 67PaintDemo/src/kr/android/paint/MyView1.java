package kr.android.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView1 extends View{
	//Activity���� Ŀ���� �並 ����ϱ� ����
	public MyView1(Context context){
		super(context);
	}
	
	//XML�� element�� ������ �ݵ�� �Ʒ� ������ ����
	public MyView1(Context context, AttributeSet attributeSet){
		super(context, attributeSet);
	}
	
	//�׸� �׸���
	public void onDraw(Canvas canvas){
		//��׶��� ����
		canvas.drawColor(Color.BLACK);
		//�׸��� �ɼ� ����
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//drawLine
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(10);
					//����x, ����y, ��x, ��y, Paint��ü
		canvas.drawLine(50, 0, 50, 100, paint);
		
		
	}

}