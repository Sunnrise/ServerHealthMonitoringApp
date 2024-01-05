package vtys.group.serverhealth

import Home
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import vtys.group.serverhealth.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.navigation_home -> replaceFragment(Home())
                R.id.navigation_favourite -> replaceFragment(Favourites())
                R.id.navigation_refresh -> replaceFragment(Refresh())
                R.id.navigation_notification -> replaceFragment(Notifications())
                R.id.navigation_profile -> replaceFragment(Profile())

                else ->{

                }
        }
        true
    }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }
}
/*val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
      bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
          when (menuItem.itemId) {
              R.id.navigation_item1 -> {
                  // Item 1 ile ilgili işlemler
                  true
              }
              R.id.navigation_item2 -> {
                  // Item 2 ile ilgili işlemler
                  true
              }
              R.id.navigation_item3 -> {
                  // Item 3 ile ilgili işlemler
                  true
              }
              R.id.navigation_item4 -> {
                  // Item 4 ile ilgili işlemler
                  true
              }
              R.id.navigation_item5 -> {
                  // Item 5 ile ilgili işlemler
                  true
              }

              // Diğer öğeleri ekleyin
              else -> false
          }
      }
*/
