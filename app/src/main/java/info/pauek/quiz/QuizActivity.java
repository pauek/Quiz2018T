package info.pauek.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup respostesview;

    private void generaPregunta() {
        String[] respostes = new String[4];
        respostes[0] = "Barcelona";
        respostes[1] = "Paris";
        respostes[2] = "Londres";
        respostes[3] = "Hanoi";
        pregunta = new PreguntaTest(
                "Quina és la capital de Vietnam?",
                respostes,
                3
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        generaPregunta();

        TextView textview = findViewById(R.id.textview);
        respostesview = findViewById(R.id.respostesview);
        RadioButton btn_resp0 = findViewById(R.id.btn_resp0);
        RadioButton btn_resp1 = findViewById(R.id.btn_resp1);
        RadioButton btn_resp2 = findViewById(R.id.btn_resp2);
        RadioButton btn_resp3 = findViewById(R.id.btn_resp3);

        textview.setText(pregunta.getText());
        btn_resp0.setText(pregunta.getRespostes()[0]);
        btn_resp1.setText(pregunta.getRespostes()[1]);
        btn_resp2.setText(pregunta.getRespostes()[2]);
        btn_resp3.setText(pregunta.getRespostes()[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_comprova:
                comprovaResposta();
                break;
            case R.id.menu_reset:
                respostesview.clearCheck();
                break;
        }
        return true;
    }

    private void comprovaResposta() {
        if (getButtonIndex() == pregunta.getCorrecta()) {
            Toast.makeText(this, "Molt bé!!1", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Torna a provar...", Toast.LENGTH_SHORT).show();
        }
    }

    private int getButtonIndex() {
        int index = -1;
        int selected = respostesview.getCheckedRadioButtonId();
        int ids[] = {R.id.btn_resp0, R.id.btn_resp1, R.id.btn_resp2, R.id.btn_resp3};
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == selected) {
                index = i;
                break;
            }
        }
        return index;
    }
}


