package alterindonesia.project.com;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import alterindonesia.project.com.Model.User;
import alterindonesia.project.com.Utils.DialogHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.etFullname)
    AutoCompleteTextView etFullname;
    @BindView(R.id.etEmail)
    AutoCompleteTextView etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etRePassword)
    EditText etRePassword;
    @BindView(R.id.email_sign_in_button)
    Button btnDaftar;

    private String TAG = "--Register-Tag--";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        initToolbar();
        initForm();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initForm(){

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(validation()) {
                        doRegisterAction();
                    }
                }
            });

    }

    private void doRegisterAction(){
        DialogHelper.showLoading(this);
        mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            createNewUser(user);
                        } else {
                            DialogHelper.hideLoading(RegisterActivity.this);
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private boolean validation(){
        boolean isValid = true;
        if(TextUtils.isEmpty(etFullname.getText().toString())){
            isValid = false;
            etFullname.setError("Wajib Diisi");
        }
        if(TextUtils.isEmpty(etEmail.getText().toString())){
            isValid = false;
            etEmail.setError("Wajib Diisi");
        }
        if(TextUtils.isEmpty(etPassword.getText().toString())){
            isValid = false;
            etPassword.setError("Wajib Diisi");
        }
        if(TextUtils.isEmpty(etRePassword.getText().toString())){
            isValid = false;
            etRePassword.setError("Wajib Diisi");
        }
//        if(isValid){
//            if(!etPassword.getText().equals(etRePassword.getText().toString())) {
//                isValid = false;
//                etRePassword.setText("Password tidak cocok");
//            }
//        }
        return isValid;
    }

    private void createNewUser(FirebaseUser firebaseUser){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        User user   = new User();
        user.setId(firebaseUser.getUid());
        user.setNama(etFullname.getText().toString());
        user.setEmail(etEmail.getText().toString());
        user.setTelepon("xxx");
        user.setCreatedAt(System.currentTimeMillis());
        myRef.child("user/"+firebaseUser.getUid()).setValue(user);
        DialogHelper.hideLoading(this);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
