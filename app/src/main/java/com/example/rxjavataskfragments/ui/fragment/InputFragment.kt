package com.example.rxjavataskfragments.ui.fragment


import android.util.Log
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.rxjavataskfragments.databinding.FragmentUpBinding
import com.example.rxjavataskfragments.util.DataConnection
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class InputFragment : BaseFragment<FragmentUpBinding>() {
    private lateinit var connection: DataConnection
    override val bindingInflater: (LayoutInflater) -> FragmentUpBinding = FragmentUpBinding::inflate
    override val LOG_TAG = "InputFragment"

    override fun setup() {
        connection = activity as DataConnection
        setData()
    }

    private fun setData(){
        val observable = PublishSubject.create<String>{ data ->
            binding?.myEditText?.doOnTextChanged { next, _, _, _ ->
                data.onNext(next.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS).publish()
        observable.connect()
        observable.subscribe(
            {onNext ->
                connection.dataTransition(onNext)
            },
            {onError->
                Log.i("Error","onError ${onError.message}")
            }
        )
    }
}