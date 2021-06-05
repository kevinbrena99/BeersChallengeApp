package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.detail

import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.brena.beerschallengeapp.BR
import com.brena.beerschallengeapp.R
import com.brena.beerschallengeapp.databinding.FragmentBeerDetailBinding
import com.brena.beerschallengeapp.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class BeerDetailFragment : BaseFragment<FragmentBeerDetailBinding, BeerDetailViewModel>() {

    override val myViewModel: BeerDetailViewModel by viewModel()
    override val getLayoutId: Int = R.layout.fragment_beer_detail
    override val getBindingVariable: Int = BR.beerDetailViewModel
    private val beerArgs: BeerDetailFragmentArgs by navArgs()

    override fun onFragmentViewReady(view: View) {
        beerArgs.let {
            myViewModel.setBeerDetail(it.beer)
        }
        with(binding.btnBack) {
            setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}