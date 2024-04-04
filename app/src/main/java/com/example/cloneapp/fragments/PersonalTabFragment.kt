package com.example.cloneapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneapp.R
import com.example.cloneapp.adapter.PersonalItemAdapter
import com.example.cloneapp.model.PersonalData

class PersonalTabFragment : Fragment() {
    private lateinit var personalItemAdapter: PersonalItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_personal_tab, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val arr = ArrayList<PersonalData>()
        arr.add(PersonalData("Rahul", "Noida", "Android developer", "200km"))
        arr.add(PersonalData("Rohit", "Delhi", "Web developer", "20km"))
        arr.add(PersonalData("Ritik", "AI", "ML", "80km"))
        arr.add(PersonalData("Ajay", "Goa", "Front-end developer", "90km"))
        arr.add(PersonalData("Abhay", "Bihar", "Android developer", "100km"))
        arr.add(PersonalData("Golu", "Noida", "Web developer", "150km"))
        arr.add(PersonalData("Akash", "Delhi", "Web developer", "130km"))


        personalItemAdapter = PersonalItemAdapter(activity as Context, arr)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context)
        recyclerView.adapter = personalItemAdapter


        return view
    }
}