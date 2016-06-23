package gooin.github.io.wordsoftime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkShowTutorial();
        setContentView(R.layout.activity_main);

    }

    private void checkShowTutorial() {
        int oldVersionCode = PrefConstances.getAppPrefInt(this, "version_code");
        int currentVersionCode = SAppUtil.getAppVersionCode(this);
        if (currentVersionCode > oldVersionCode) {
            startActivity(new Intent(MainActivity.this, ProductTourActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            PrefConstances.putAppPrefInt(this, "version_code", currentVersionCode);
        }
    }
}
