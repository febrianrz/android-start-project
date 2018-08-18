package alterindonesia.project.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import alterindonesia.project.com.Utils.StoreObjek;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MerchantDetailActivity extends AppCompatActivity {
    @BindView(R.id.tvNama)
    TextView tvNama;
    @BindView(R.id.tvKeterangan)
    TextView tvKeterangan;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvTelepon)
    TextView tvTelepon;
    @BindView(R.id.tvAlamat)
    TextView tvAlamat;

    StoreObjek storeObjek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_detail);
        ButterKnife.bind(this);
        initToolbar();
        storeObjek = ((StoreObjek) getApplicationContext());
        tvNama.setText(storeObjek.merchant.getNama());
        tvKeterangan.setText(storeObjek.merchant.getKeterangan());
        tvEmail.setText(storeObjek.merchant.getEmail());
        tvTelepon.setText(storeObjek.merchant.getTelepon());
        tvAlamat.setText(storeObjek.merchant.getAlamat());
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
//            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
