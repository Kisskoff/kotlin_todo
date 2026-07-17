package com.formation.todolist.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataUsage
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.formation.todolist.model.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onDeletee: () -> Unit,
    onChangeDone: () -> Unit,
) {

//    NavigationDrawerItem(
//        label = {
//            Column()
//
//         {
//            Text(text = todo.title)
//            Text(text = todo.description,overflow = TextOverflow.Ellipsis, fontSize = 12.sp,color = MaterialTheme.colorScheme.onSurface)
//        }
//                },
//        selected = false,
//        onClick = { null },
//        badge = {Row() {
//            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
//            Switch(
//            checked = todo.isDone,
//            onCheckedChange = { onChangeDone() }
//        )}
//                },
//    )
    Column {
        ListItem(
            modifier = Modifier
                .padding(0.dp),
            // overlineContent = { Text("Tâche") },
            headlineContent = { Text(todo.title) },
            supportingContent = {
                Text(
                    todo.description,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            trailingContent = {
                IconButton(onClick = onDeletee) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            },
            leadingContent = {
                //
                 Checkbox(
                 checked = todo.isDone,
                 onCheckedChange = { onChangeDone() }
                 )
                //
//                Switch(
//                    checked = todo.isDone,
//                    onCheckedChange = { onChangeDone() },
//                )
            },
        )
        HorizontalDivider()
    }

//    Row(
//        modifier = Modifier
//            //.fillMaxWidth()
//            //.background(color = MaterialTheme.colorScheme.primary)
//            .padding(vertical = 8.dp)
//            .height(50.dp)
//        ,
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color = MaterialTheme.colorScheme.onError)
//        ) {
//            Text(text = todo.title)
//            Text(text = todo.description,overflow = TextOverflow.Ellipsis, fontSize = 12.sp,color = MaterialTheme.colorScheme.onSurface)
//        }
//
//       // Spacer(modifier = Modifier.weight(1.0f))
//        Switch(
//            checked = todo.isDone,
//            onCheckedChange = { onChangeDone() }
//        )
//        IconButton(
//            onClick = { onDeletee() }
//        ) {
//        Icon(
//            imageVector = Icons.Default.Delete,
//            contentDescription = "Delete",
//        )}
//    }

}


@Composable
fun ClickableListItems(
    todo: Todo,
    onDeletee: () -> Unit,
    onChangeDone: () -> Unit,
) {
    Column {
        ListItem(
            headlineContent = { Text(todo.title) },
            trailingContent = {
                Switch(
                    checked = todo.isDone,
                    onCheckedChange = { onChangeDone() }, // null recommended for accessibility with screenreaders
                )
            },
            modifier =
                Modifier
                    .clip(MaterialTheme.shapes.small)
                    .padding(vertical = 8.dp)
                    .toggleable(
                        role = Role.Switch,
                        value = todo.isDone,
                        onValueChange = { onDeletee() },
                    ),
            colors = ListItemColors(
                containerColor = MaterialTheme.colorScheme.background,
                leadingIconColor = MaterialTheme.colorScheme.onSurface,
                headlineColor = MaterialTheme.colorScheme.onSurface,
                supportingTextColor = MaterialTheme.colorScheme.onSurface,
                trailingIconColor = MaterialTheme.colorScheme.onSurface,
                overlineColor = MaterialTheme.colorScheme.onSurface,
                disabledHeadlineColor = MaterialTheme.colorScheme.onSurface,
                disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface,
            ),
        )
        HorizontalDivider()
    }
}

@Composable
fun FilterChipSample(todo: Todo) {
    val state = remember { mutableStateOf(false) }
    FilterChip(
        selected = state.value,
        onClick = { state.value = !state.value },
        label = { Text(todo.title) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.DataUsage,
                contentDescription = "Localized Description",
                //  modifier = Modifier.requiredSize(ChipDefaults.SelectedIconSize),
            )
        },
    )
}