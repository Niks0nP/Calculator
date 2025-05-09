package com.niks0n.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class MainState(
    var firstDigit: Double = 0.0,
    var secondDigit: Double = 0.0,
    var operation: String = "",
    var result: Double = 0.0,
    var isOperationEntered: Boolean = false
)

sealed class MainIntent {
    data class SetFirstDigit(val firstDigit: Double) : MainIntent()
    data class SetSecondDigit(val secondDigit: Double) : MainIntent()
    data class SetOperation(val operation: String) : MainIntent()
    data object CalculateResult : MainIntent()
    data object DeleteAllInfo : MainIntent()
}

class MainViewModel: ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState>
        get() = _state

    fun onAction(mainIntent: MainIntent) {
        when (mainIntent) {
            is MainIntent.SetFirstDigit -> setText(mainIntent.firstDigit)
            is MainIntent.SetSecondDigit -> setSecondDigit(mainIntent.secondDigit)
            is MainIntent.SetOperation -> setOperation(mainIntent.operation)
            is MainIntent.CalculateResult -> calculateResult()
            is MainIntent.DeleteAllInfo -> deleteAllInfo()
        }
    }

    private fun deleteAllInfo() {
        _state.value = _state.value.copy(
            firstDigit = 0.0,
            secondDigit = 0.0,
            operation = "",
            result = 0.0,
            isOperationEntered = false
        )
    }

    private fun calculateResult() {
        val newResult = when (_state.value.operation) {
            "+" -> _state.value.firstDigit + _state.value.secondDigit
            "-" -> _state.value.firstDigit - _state.value.secondDigit
            else -> 0.0
        }
        _state.value = _state.value.copy(result = newResult)
    }

    private fun setOperation(operation: String) {
        _state.value = _state.value.copy(
            operation = operation,
            isOperationEntered = operation.isNotEmpty()
        )
    }

    private fun setText(firstDigit: Double) {
        _state.value = _state.value.copy(firstDigit = firstDigit)
    }

    private fun setSecondDigit(secondDigit: Double) {
        _state.value = _state.value.copy(secondDigit = secondDigit)
    }
}