package com.maxdexter.triviaapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.maxdexter.triviaapp.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener { view: View -> Navigation.findNavController(view).navigate(R.id.action_gameWonFragment_to_gameFragment) }

        var args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(context, "Num Correct ${args?.numCorrect}, Num question ${args?.numQuestion}", Toast.LENGTH_SHORT).show()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }

    }

    private fun getShareIntent(): Intent {
        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        val shareIntent: Intent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text,args?.numCorrect, args?.numQuestion))
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


}