package com.niks0n.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(modifier = modifier) {
        Column(modifier = Modifier.weight(0.5f)) {
            TextFieldArea(state = state.value)
        }
        Column(modifier = Modifier.weight(0.5f)) {
            NumberFieldValue(viewModel = viewModel, state = state.value)
        }
    }
}

@Composable
fun NumberFieldValue(
    viewModel: MainViewModel,
    state: MainState
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FirstRow(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
            viewModel = viewModel,
            state = state
        )
        SecondRow(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
            viewModel = viewModel,
            state = state
        )
        ThirdRow(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
            viewModel = viewModel,
            state = state
        )
        FortyRow(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
            viewModel = viewModel
        )
    }
}

@Composable
fun FirstRow(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    state: MainState
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(1.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(1.0))
            }
        ) {
            Text("1")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(2.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(2.0))
            }
        ) {
            Text("2")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(3.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(3.0))
            }
        ) {
            Text("3")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                viewModel.onAction(MainIntent.SetOperation("+"))
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun SecondRow(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    state: MainState
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(4.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(4.0))
            }
        ) {
            Text("4")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(5.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(5.0))
            }
        ) {
            Text("5")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(6.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(6.0))
            }
        ) {
            Text("6")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                viewModel.onAction(MainIntent.SetOperation("-"))
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun ThirdRow(
    modifier: Modifier,
    viewModel: MainViewModel,
    state: MainState
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {


                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(7.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(7.0))
            }
        ) {
            Text("7")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(8.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(8.0))
            }
        ) {
            Text("8")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                if (!state.isOperationEntered) {
                    viewModel.onAction(MainIntent.SetFirstDigit(9.0))
                }
                else viewModel.onAction(MainIntent.SetSecondDigit(9.0))
            }
        ) {
            Text("9")
        }
        Button(
            modifier = Modifier.weight(0.25f).fillMaxHeight(),
            onClick = {
                viewModel.onAction(MainIntent.CalculateResult)
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Add"
            )
        }
    }
}

@Composable
fun FortyRow(modifier: Modifier, viewModel: MainViewModel) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            modifier = Modifier.weight(0.77f).fillMaxHeight(),
            onClick = {
                viewModel.onAction(MainIntent.SetFirstDigit(0.0))
            }
        ) {
            Text("0")
        }
        Button(
            modifier = Modifier.weight(0.23f).fillMaxHeight(),
            onClick = {
                viewModel.onAction(MainIntent.DeleteAllInfo)
            }
        ) {
            Text("C")
        }
    }
}

@Composable
fun TextFieldArea(
    modifier: Modifier = Modifier,
    state: MainState
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.weight(1.0f))
        Text(
            modifier = Modifier.padding(10.dp),
            text = "${if (state.firstDigit != 0.0) state.firstDigit else ""} ${state.operation} " +
                    "${if (state.secondDigit != 0.0) state.secondDigit else ""}",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp, bottom = 40.dp),
            text = "${state.result}",
            style = MaterialTheme.typography.displayMedium
        )
    }
}
