package com.formation.todolist.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TextFieldLabelPosition.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

//@Composable
//fun SearchTextFieldExample() {
//    val state = TextFieldState() // rememberTextFieldState()
//
//    OutlinedTextField(
//        value = state,
//        modifier = Modifier.fillMaxWidth(),
//        label = { },
//        onValueChange = {},
//       // shape = RoundedCornerShape(10.dp),
//        // labelPosition = Above(),
//        placeholder = { },
//        leadingIcon = {
////            Icon(
////                imageVector = Icons.Filled.Search,
////                contentDescription = null,
////                //  modifier = Modifier.size(16.dp),
////                //  tint = Theme[colors][mutedColor],
////            )
//        },
//        trailingIcon = {
////            AnimatedVisibility(
////                visible = state.text.isNotEmpty(),
////                //enter = fadeIn(),
////                // exit = fadeOut(),
////            ) {
////                IconButton(
////                    onClick = { state.clearText() },
////                    //  modifier = Modifier.size(32.dp),
//////                  // style = ButtonStyle.Ghost,
//////                  // buttonSize = ButtonSize.Small,
////                ) {
////                    Icon(
////                        imageVector = Icons.Filled.Clear,
////                        contentDescription = "Clear search",
////                        //   modifier = Modifier.size(14.dp),
////                        // tint = Theme[colors][mutedColor],
////                    )
////                }
////            }
//        },
////        onValueChange = TODO(),
////        enabled = TODO(),
////        readOnly = TODO(),
////        textStyle = TODO(),
////        prefix = TODO(),
////        suffix = TODO(),
////        supportingText = TODO(),
////        isError = TODO(),
////        visualTransformation = TODO(),
////        keyboardOptions = TODO(),
////        keyboardActions = TODO(),
////        singleLine = TODO(),
////        maxLines = TODO(),
////        minLines = TODO(),
////        interactionSource = TODO(),
////        colors = TODO(),
//    )
//
//}

//@Composable
//fun AdvancedTextFieldWithState() {
//    val state = rememberTextFieldState()
//
//    TextField(
//        state = state,
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(10.dp),
//        colors = TextFieldDefaults.colors(
////focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
//
//
//        ),
//        //  label = { Text("Label avec état") },
//        lineLimits = TextFieldLineLimits.SingleLine,
//        leadingIcon = {
//            Icon(Icons.Filled.Search, contentDescription = null)
//        },
//        trailingIcon = {
//            IconButton(onClick = { state.clearText() }) {
//                Icon(Icons.Filled.Clear, contentDescription = "Effacer")
//            }
//        },
//        prefix = {Text("pre")},
//        suffix = {Text("suf")}
//    )
//}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType?,
    imeAction: ImeAction = ImeAction.Done,
    manager: FocusManager,
    onSend:()->Unit,
) {


    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onChange,
        placeholder = { Text("Entrer votre $label") },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType ?: KeyboardType.Text,
            imeAction = imeAction,
        ),
        keyboardActions = KeyboardActions(
            // si l action est done
            // on enleve le focus
            // sinon, on ne fait rien
            onDone = { if (imeAction == ImeAction.Done) manager.clearFocus() else null },
            onNext = { manager.moveFocus(FocusDirection.Down) },
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
               contentDescription = null,
//                //  modifier = Modifier.size(16.dp),
//                //  tint = Theme[colors][mutedColor],
           )
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = true,// value.isNotEmpty(),
                //enter = fadeIn(),
                // exit = fadeOut(),
            ) {
                IconButton(
                    onClick = onSend //{
                                   // value.clearText()
                             // },
                    //  modifier = Modifier.size(32.dp),
//                  // style = ButtonStyle.Ghost,
//                  // buttonSize = ButtonSize.Small,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear search",
                        //   modifier = Modifier.size(14.dp),
                        // tint = Theme[colors][mutedColor],
                    )
                }
            }
        }

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    textFieldState: TextFieldState,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
) {
    // Controls expansion state of the search bar
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(50.dp)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = { textFieldState.edit { replace(0, length, it) } },
                    onSearch = {
                        onSearch(textFieldState.text.toString())
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Search") }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            // Display search results in a scrollable column
            Column(Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        modifier = Modifier
                            .clickable {
                                textFieldState.edit { replace(0, length, result) }
                                expanded = false
                            }
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
