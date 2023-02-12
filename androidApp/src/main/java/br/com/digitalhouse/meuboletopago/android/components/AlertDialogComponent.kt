import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertDialogComponent(
    showDialog: Boolean,
    message: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
){
    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            title = { Text(text = "") },
            text = { Text(text = "$message") },
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "OK")
                }
            },
            contentColor = Color.White,
            backgroundColor = Color.Black
        )
    }
}

@Preview
@Composable
fun AlertDialogComponentPreview() {
    AlertDialogComponent(showDialog = true, message = "Teste", onDismissRequest = { })
}