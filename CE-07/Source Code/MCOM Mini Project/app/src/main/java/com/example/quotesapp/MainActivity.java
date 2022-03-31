package  com.example.quotesapp;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button showAllBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        showAllBtn = findViewById(R.id.showAllBtn);
        showAllBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, DisplayActivity.class);
            startActivity(intent);
        });
    }
}