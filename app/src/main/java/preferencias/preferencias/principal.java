package preferencias.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class principal extends Activity implements View.OnClickListener
{
    private TextView tPreferencias = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        final Button bPreferencias = (Button)findViewById(R.id.bPreferencias);
        final Button bMostrarPreferencias = (Button)findViewById(R.id.bMostrarPreferencias);
        tPreferencias = (TextView)findViewById(R.id.tPreferencias);

        bPreferencias.setOnClickListener(this);
        bMostrarPreferencias.setOnClickListener(this);

        cargarPreferenciasPorDefecto();
        mostrarPreferenciasEnPantalla();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    /**
     * Aquí damos funcionalidad a las opciones del menú
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId())
        {
            case R.id.menu_guardar:
                irAPreferencias();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.bPreferencias:
                irAPreferencias();
                break;
            case R.id.bMostrarPreferencias:
                mostrarPreferenciasEnPantalla();
                break;
        }
    }

    public void cargarPreferenciasPorDefecto()
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putBoolean("musica", Boolean.TRUE);
        editor.putString("graficos", "0");
        editor.commit();
    }

    public void mostrarPreferenciasEnPantalla()
    {
        SharedPreferences preferenciasapp = getSharedPreferences("preferencias.preferencias_preferences", MODE_PRIVATE);
        String resultado = "Música: ";
        if( preferenciasapp.getBoolean("musica", Boolean.TRUE) )
            resultado += "Activado";
        else
            resultado += "No activado";
        resultado += "\n";
        resultado += "Gráficos: " + preferenciasapp.getString("graficos", "0") + "\n";
        resultado += "Fragmentos: " + preferenciasapp.getString("fragmentos", "1") + "\n";
        tPreferencias.setText(resultado);
    }

    public void irAPreferencias()
    {
        Intent intent = new Intent(principal.this, preferencias.class);
        startActivity(intent);
    }
}
