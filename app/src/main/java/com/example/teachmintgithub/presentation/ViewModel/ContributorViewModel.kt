package com.example.teachmintgithub.presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmenttrial1.data.repository.ContributorRepository
import com.example.assignmenttrial1.data.local.ContributorEntity
import com.example.teachmintgithub.data.local.ContributorEntity
import com.example.teachmintgithub.data.repository.ContributorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContributorViewModel @Inject constructor(
    private val contributorRepository: ContributorRepository
) : ViewModel() {

    private val _contributors = MutableLiveData<List<ContributorEntity>>()
    val contributors: LiveData<List<ContributorEntity>> = _contributors

    fun fetchContributors(owner: String, repo: String, offset: Int) {
        viewModelScope.launch {
            val contributorsList = contributorRepository.getContributors(owner, repo, offset)
            _contributors.value = contributorsList
        }
    }
}
