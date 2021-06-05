package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.list


import android.view.View
import com.brena.beerschallengeapp.BR
import com.brena.beerschallengeapp.R
import com.brena.beerschallengeapp.databinding.FragmentBeerCorouselBinding
import com.brena.beerschallengeapp.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerCarouselFragment : BaseFragment<FragmentBeerCorouselBinding,BeerListViewModel>() {

    override val myViewModel: BeerListViewModel by viewModel()
    override val getLayoutId: Int = R.layout.fragment_beer_corousel
    override val getBindingVariable: Int = BR.beerListViewModel

    override fun onFragmentViewReady(view: View) {
        setupRecyclerCarousel()
        initLiveData()
    }

    private fun setupRecyclerCarousel(){
        with(binding.recycler){
            set3DItem(true)
            setAlpha(true)
        }
    }

    private fun initLiveData(){
        myViewModel.beersLiveData.observe(viewLifecycleOwner,{
            myViewModel.setItemAfterMapping(it)
        })
    }
}