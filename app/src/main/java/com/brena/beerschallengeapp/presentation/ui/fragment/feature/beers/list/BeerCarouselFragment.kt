package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.list


import android.view.View
import androidx.navigation.fragment.findNavController
import com.brena.beerschallengeapp.BR
import com.brena.beerschallengeapp.R
import com.brena.beerschallengeapp.databinding.FragmentBeerCorouselBinding
import com.brena.beerschallengeapp.presentation.model.Beer
import com.brena.beerschallengeapp.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerCarouselFragment : BaseFragment<FragmentBeerCorouselBinding,BeerListViewModel>(), ListenerBeerClick {

    override val myViewModel: BeerListViewModel by viewModel()
    override val getLayoutId: Int = R.layout.fragment_beer_corousel
    override val getBindingVariable: Int = BR.beerListViewModel

    override fun onFragmentViewReady(view: View) {
        setupRecyclerCarousel()
        initLiveData()
        myViewModel.setNavigator(this)
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

    override fun onClickBeer(beer: Beer) {
       findNavController().navigate(BeerCarouselFragmentDirections.actionBeerCarouselFragmentToBeerDetailFragment(beer))
    }
}