package com.example.cloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cloneapp.databinding.ActivityMainBinding
import com.example.cloneapp.fragments.BusinessesTabFragment
import com.example.cloneapp.fragments.ChatFragment
import com.example.cloneapp.fragments.ConnectionFragment
import com.example.cloneapp.fragments.ContactsFragment
import com.example.cloneapp.fragments.ExploreFragment
import com.example.cloneapp.fragments.GroupsFragment
import com.example.cloneapp.fragments.PersonalTabFragment
import com.example.cloneapp.fragments.ServiceTabFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var personalTabFragment: PersonalTabFragment
    private lateinit var serviceTabFragment: ServiceTabFragment
    private lateinit var connectionFragment: ConnectionFragment
    private lateinit var exploreFragment: ExploreFragment
    private lateinit var groupsFragment: GroupsFragment
    private lateinit var contactsFragment: ContactsFragment
    private lateinit var chatFragment: ChatFragment

    private lateinit var businessesTabFragment: BusinessesTabFragment
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initialize()

        initiallyHideAllFragemnts()

        setTabLayoutViewPager()

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.explore -> {
                    showFragment(personalTabFragment)
                    showTabLaout()
                    true
                }
                R.id.connection -> {
                    showFragment(connectionFragment)
                    hideTabLayout()
                    true
                }
                R.id.chat -> {
                    showFragment(chatFragment)
                    hideTabLayout()
                    true
                }
                R.id.contacts -> {
                    showFragment(contactsFragment)
                    hideTabLayout()
                    true
                }
                R.id.groups -> {
                    showFragment(groupsFragment)
                    hideTabLayout()
                    true
                }
                else -> false
            }
        }
    }

    private fun hideTabLayout() {
        binding.tabLayout.visibility = View.GONE
    }

    private fun showTabLaout() {
        binding.tabLayout.visibility = View.VISIBLE
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(personalTabFragment)
            .hide(serviceTabFragment)
            .hide(businessesTabFragment)
            .hide(connectionFragment)
            .hide(chatFragment)
            .hide(groupsFragment)
            .hide(contactsFragment)
            .show(fragment)
            .commitNow()

        binding.viewPager.visibility = if (fragment == exploreFragment) View.VISIBLE else View.GONE
        binding.fameLayout.visibility = if (fragment == exploreFragment) View.GONE else View.VISIBLE

    }

    private fun setTabLayoutViewPager() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = when(position){
                0 -> "Personal"
                1 -> "Service"
                2 -> "Businesses"
                else -> ""
            }
        }.attach()
    }

    private fun initiallyHideAllFragemnts() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fameLayout, personalTabFragment)
            .hide(personalTabFragment)

            .add(R.id.fameLayout, serviceTabFragment)
            .hide(serviceTabFragment)

            .add(R.id.fameLayout, businessesTabFragment)
            .hide(businessesTabFragment)

            .add(R.id.fameLayout, connectionFragment)
            .hide(connectionFragment)

            .add(R.id.fameLayout, chatFragment)
            .hide(chatFragment)

            .add(R.id.fameLayout, groupsFragment)
            .hide(groupsFragment)

            .add(R.id.fameLayout, contactsFragment)
            .hide(contactsFragment)

            .commitNow()
    }

    private fun initialize() {
        personalTabFragment = PersonalTabFragment()
        serviceTabFragment = ServiceTabFragment()
        businessesTabFragment = BusinessesTabFragment()
        connectionFragment = ConnectionFragment()
        chatFragment = ChatFragment()
        groupsFragment = GroupsFragment()
        exploreFragment = ExploreFragment()
        connectionFragment = ConnectionFragment()
        contactsFragment = ContactsFragment()

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.offscreenPageLimit = binding.bottomNav.maxItemCount
    }
}