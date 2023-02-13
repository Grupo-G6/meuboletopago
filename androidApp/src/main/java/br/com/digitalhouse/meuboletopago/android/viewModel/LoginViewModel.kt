package br.com.digitalhouse.meuboletopago.android.viewModel

import androidx.lifecycle.ViewModel
import br.com.digitalhouse.meuboletopago.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
//
//class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
////    private val _loginState: MutableStateFlow<DataResult<ProfileToken>> =
////        MutableStateFlow(DataResult.Empty)
////    //-----encapsular: view model é o único a ser mudado e quem chamar o loginState, vai pegar um objeto imutável()
////}