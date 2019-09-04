package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText InputAngka;
	private TextView ViewAngka;
	private PopupMenu PopAngka;
	int angka;
	Random acak = new Random();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		InputAngka = findViewById(R.id.number_input);
		initRandomNumber();
	}

	// TODO: generate angka random di sini

	private void initRandomNumber() {
		this.angka = this.acak.nextInt(100) +1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String tebak = InputAngka.getText().toString();
		int n =Integer.parseInt(tebak);
		if (n == angka){
			Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
		}
		else if (n < angka){
			Toast.makeText(this, "Tebakan kurang besar", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(this, "Tebakan Terlalu Besar", Toast.LENGTH_SHORT).show();
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		InputAngka.setText("");
		Button btn =(Button) findViewById(R.id.guess_button);
		btn.setEnabled(true);
	}
}
