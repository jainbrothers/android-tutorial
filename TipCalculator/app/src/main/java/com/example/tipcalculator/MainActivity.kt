package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipCalculator()
                }
            }
        }
    }
}

@Composable
fun TipCalculator() {
    var userInput by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("") }
    var isRoundUp by remember { mutableStateOf(false) }
    val tipAmount = calculateTip(billAmount = userInput.toDoubleOrNull() ?: 0.0, tipPercent = tipPercent.toDoubleOrNull() ?: 15.0, isRoundUp = isRoundUp)
    Column(Modifier.fillMaxSize(), 
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.tip_calculator_screen_heading))
        Spacer(Modifier.height(16.dp))

        BillAmountTextField(value = userInput,
            onValueChange = {userInput = it})
        Spacer(Modifier.height(24.dp))

        TipPercentTextField(value = tipPercent,
            onValueChange = {tipPercent = it})
        Spacer(Modifier.height(24.dp))
        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.is_roundup_text),
                fontSize = 16.sp
            )
            Switch(
                checked = isRoundUp,
                onCheckedChange = { isRoundUp = it },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.Gray,
                    checkedThumbColor = Color.Blue
                )
            )
        }
        Spacer(Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.tip_amount, tipAmount),
            Modifier.align(CenterHorizontally),
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BillAmountTextField(value: String, onValueChange: (String) -> Unit) {
    NumericTextField(value = value,
        labelText = stringResource(id = R.string.`bill_amount_label`),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next))
}

@Composable
fun TipPercentTextField(value: String, onValueChange: (String) -> Unit) {
    NumericTextField(value = value,
        labelText = stringResource(id = R.string.tip_percent_label),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done))
}
@Composable
fun NumericTextField(value : String, labelText : String, onValueChange: (String) -> Unit, keyboardOptions: KeyboardOptions) {
    val focusManager = LocalFocusManager.current
    TextField(value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()}, onNext = {focusManager.moveFocus(
            FocusDirection.Next)}),
        singleLine = true,
        label = { Text(text = labelText, Modifier.fillMaxSize()) }
    )
}

@VisibleForTesting
internal fun calculateTip(billAmount: Double, tipPercent: Double = 15.0, isRoundUp: Boolean = false): String {
    var tipAmount = ((billAmount * tipPercent)/100)
    if (isRoundUp) {
        tipAmount = ceil(tipAmount)
    }
    return NumberFormat.getCurrencyInstance().format(tipAmount)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        TipCalculator()
    }
}