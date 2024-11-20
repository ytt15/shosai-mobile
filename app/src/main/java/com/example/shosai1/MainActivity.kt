package com.example.shosai1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración del BottomNavigationView
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            // Cambiar fragment según el ítem seleccionado
            when (menuItem.itemId) {
                R.id.recuperar -> {
                    loadFragment(Recuperar()) // Cargar el fragment de inicio
                    true
                }
                R.id.navigation_dashboard -> {
                    loadFragment(DashboardFragment()) // Cargar el fragment de Dashboard
                    true
                }
                R.id.navigation_notifications -> {
                    loadFragment(NotificationsFragment()) // Cargar el fragment de Notificaciones
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment()) // Cargar el fragment de Perfil
                    true
                }
                else -> false
            }
        }

        // Cargar el fragment inicial (HomeFragment) si es la primera vez
        if (savedInstanceState == null) {
            loadFragment(HomeFragment()) // Cargar el fragment inicial
        }
    }

    // Método para cargar fragmentos
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment) // Reemplaza el fragmento en el contenedor
        transaction.addToBackStack(null) // Puedes omitir esto si no deseas poder navegar hacia atrás
        transaction.commit()
    }
}
