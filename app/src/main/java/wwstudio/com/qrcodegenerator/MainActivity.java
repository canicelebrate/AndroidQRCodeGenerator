package wwstudio.com.qrcodegenerator;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Bean
    EncodingHandler mEncodingHandler;

    @ViewById(R.id.et_qr_string)
    EditText mEditQRCode;

    @ViewById(R.id.iv_qr_image)
    ImageView mQRImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.btn_add_qrcode)
    void onGenerateQRCodeClicked(){
        try {
            String contentString = mEditQRCode.getText().toString();
            if (!contentString.equals("")) {
                Bitmap qrCodeBitmap = mEncodingHandler.createQRCode(contentString, 350);
                mQRImageView.setImageBitmap(qrCodeBitmap);
            }else {
                Toast.makeText(MainActivity.this, "Text can not be empty", Toast.LENGTH_SHORT).show();
            }

        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
