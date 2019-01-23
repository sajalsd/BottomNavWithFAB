package ch.sooon.navsample.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import ch.sooon.navsample.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {

private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_about, container, false)



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        about_text1.translationY = 500F
        about_text1.post {
            Handler().postDelayed( {
                about_text1.animate()
                    .translationY(0F)
                    .alpha(1F)
                    .setInterpolator(FastOutSlowInInterpolator())
                    .setDuration(400L)
                    .start()
            }, 200)
        }


        about_text2.translationY = 150F
        about_text2.post {
            Handler().postDelayed( {
                about_text2.animate()
                    .translationY(0F)
                    .alpha(1F)
                    .setInterpolator(FastOutSlowInInterpolator())
                    .setDuration(400L)
                    .start()
            },300)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = AboutFragment()
    }
}
