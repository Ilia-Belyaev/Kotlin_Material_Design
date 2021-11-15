package com.example.app.material.ui.animation

import android.graphics.Typeface
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.example.app.R
import kotlinx.android.synthetic.main.activity_animations_bonus_end.*

import kotlinx.android.synthetic.main.activity_animations_bonus_start.*
import kotlinx.android.synthetic.main.activity_animations_bonus_start.backgroundImage
import kotlinx.android.synthetic.main.activity_animations_bonus_start.description

class AnimationsActivityBonus : AppCompatActivity() {

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations_bonus_start)

        backgroundImage.setOnClickListener { if (show) hideComponents() else showComponents() }
    }

    private fun showComponents() {
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_animations_bonus_end)
        R.layout.activity_animations_bonus_end.let {
            description.typeface = Typeface.createFromAsset(assets,"TheBomb-7B9gw.ttf")
        }

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint_container, transition)
        constraintSet.applyTo(constraint_container)
    }

    private fun hideComponents() {
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_animations_bonus_start)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint_container, transition)
        constraintSet.applyTo(constraint_container)
    }
}
