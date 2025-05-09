package steps

import com.niks0n.calculator.MainViewModel
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import junit.framework.TestCase.assertEquals
import com.niks0n.calculator.MainIntent
import kotlinx.coroutines.runBlocking

class CalculatorSteps {

    private lateinit var viewModel: MainViewModel

    @Given("I enter first digit {double}")
    fun iEnterFirstDigit(value: Double) {
        ensureViewModel()
        viewModel.onAction(MainIntent.SetFirstDigit(value))
    }

    @Given("I enter second digit {double}")
    fun iEnterSecondDigit(value: Double) {
        ensureViewModel()
        viewModel.onAction(MainIntent.SetSecondDigit(value))
    }

    @Given("I select operation {string}")
    fun iSelectOperation(op: String) {
        ensureViewModel()
        viewModel.onAction(MainIntent.SetOperation(op))
    }

    @When("I calculate the result")
    fun iCalculate() {
        ensureViewModel()
        viewModel.onAction(MainIntent.CalculateResult)
    }

    @Then("the result should be {double}")
    fun checkResult(expected: Double) = runBlocking {
        val actual = viewModel.state.value.result
        assertEquals(expected, actual, 0.0001)
    }

    private fun ensureViewModel() {
        if (!::viewModel.isInitialized) {
            viewModel = MainViewModel()
        }
    }
}