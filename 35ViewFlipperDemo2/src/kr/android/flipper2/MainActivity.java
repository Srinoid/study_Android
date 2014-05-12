package kr.android.flipper2;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Int2;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity implements View.OnTouchListener{
	
	ViewFlipper myViewFlipper;
	
	//��ġ �̺�Ʈ �߻� ������ x��ǥ ����
	float down_x;
	float up_x;
	
	int[] imageItems;
	ImageView iv1, iv2;
	int num;
	int cnt;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageItems = new int[]{R.drawable.image01,R.drawable.image02,R.drawable.image03};
		
		myViewFlipper = (ViewFlipper)findViewById(R.id.vfView);
		
		//�̹����� ViewFlipper�� ���
		for(int i : imageItems){
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(i);
			myViewFlipper.addView(imageView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		}
		
		myViewFlipper.setOnTouchListener(this);		
	}

	//
	//�̺�Ʈ �ڵ鷯
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		//��ġ �̺�Ʈ�� �Ͼ View�� ViewFlipper�� �ƴϸ� return
		if(v !=myViewFlipper){
			return false;
		}
		
		//��ǥ üũ
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			//��ġ ���� ���� x��ǥ ����
			down_x = event.getX();
		}else if(event.getAction()==MotionEvent.ACTION_UP){
			//��ġ�� ������ ���� �� ���� x��ǥ ����
			up_x = event.getX();
			
			if(up_x < down_x){
				//��ġ�� �� ���� �������� ����				
				myViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
				myViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
				myViewFlipper.showNext();
			}else if(up_x > down_x){
				//��ġ�� �� ������ �������� ����
				myViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
				myViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
				myViewFlipper.showPrevious();
			}			
		}		
		return true;
	}
}
