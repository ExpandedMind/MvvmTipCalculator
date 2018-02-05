package com.acme.tipcalculator.viewmodel

import com.acme.tipcalculator.model.Calculator
import com.acme.tipcalculator.model.TipCalculation
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorViewModelTest {

    @InjectMocks
    lateinit var viewModel : CalculatorViewModel

    @Mock
    lateinit var calculator: Calculator

    @Test
    fun testPerformCalculation() {

        val tipCalculationStub =
                TipCalculation(10.0, 2.0, 12.0)

        `when`(calculator.calculateTip(10.0, 20))
                .thenReturn(tipCalculationStub)


        viewModel.checkAmountInput = 10.0.toString()
        viewModel.tipPercentageAmount = 20


        viewModel.calculateTip()


        verify(calculator, times(1)).calculateTip(10.0, 20)
        assertThat(viewModel.tipCalculation, equalTo(tipCalculationStub))

    }

}