package com.example.myfirebase_050.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myfirebase_050.RepositorySiswa
import com.example.myfirebase_050.Siswa
import com.example.myfirebase_050.view.route.DestinasiDetail

sealed interface  StatusUIDetail {
    data class Success(val satusiswa: Siswa?) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositorySiswa:
RepositorySiswa): ViewModel() {

    private val idSiswa: Long =
        savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong()
            ?: error("idSiswa tidak ditemukan di SavedStateHandle")
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set


}