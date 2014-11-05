package preferencias.preferencias;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

@SuppressWarnings("deprecation")
@TargetApi(11)
public class preferencias extends PreferenceActivity
{

    private static int recurso_preferencias = R.xml.preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if( Build.VERSION.SDK_INT >= 11 )
        {
            addPreferencesFromResource(recurso_preferencias);
        }
        else
        {
            getFragmentManager().beginTransaction().replace(android.R.id.content, new PF()).commit();
        }
    }

    public static class PF extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(recurso_preferencias);
        }
    }

}
