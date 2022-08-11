package com.daveapps.walkthrouthds2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.daveapps.walkthrouthds2.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private var intent:Intent? = null

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.about_menu,menu)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.about_this_app)
        _binding = FragmentAboutBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)

        binding.tvguidebiteLink.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://guidebite.net/view/contact.php"))
            startActivity(intent)
        }
        return binding.root
    }
}