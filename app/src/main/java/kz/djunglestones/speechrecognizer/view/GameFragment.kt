package kz.djunglestones.speechrecognizer.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kz.djunglestones.speechrecognizer.databinding.FragmentGameBinding

import kz.djunglestones.speechrecognizer.R
import kz.djunglestones.speechrecognizer.viewModel.GameFragmentViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class GameFragment : Fragment() {

    private val viewModel:GameFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(GameFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding:  FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        return binding.root
    }


}
