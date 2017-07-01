package com.coaster.android.coaster;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
    }

    public void HandleClick(View arg) {
        Intent scannerIntent = new Intent("com.google.zxing.client.android.SCAN");

        switch (arg.getId()) {

            case R.id.butQR:
                scannerIntent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                break;

            case R.id.butProd:
                scannerIntent.putExtra("SCAN_MODE", "PRODUCT_MODE");
                break;

            case R.id.butOther:
                scannerIntent.putExtra("SCAN_FORMATS", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR");
                break;

            default:
                throw new RuntimeException("Invalid case id: " + arg.getId());
        }

        try {
            startActivityForResult(scannerIntent, 0); //Barcode Scanner to scan for us
        } catch (ActivityNotFoundException e) {
//            Toast.makeText(this, "Please install the ZXing Barcode Scanner app", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.zxing.client.android&hl=en");
            Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent2);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String product = intent.getStringExtra("SCAN_RESULT");

                Uri uri = Uri.parse("http://www.google.com/#q=" + product);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webIntent);

            }
        }
    }
}
