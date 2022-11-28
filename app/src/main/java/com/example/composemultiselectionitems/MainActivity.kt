package com.example.composemultiselectionitems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemultiselectionitems.ui.theme.ComposeMultiSelectionItemsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultiSelectionItemsTheme() {
                /*  var items = (1..20).map { //itemlar selectedlerı degısecegı için bu kısmı state yapmalıyız.
                      ListItem(
                          title = "Item $it",
                          isSelected = false
                      )
                  }*/
                var items by remember {
                    mutableStateOf((1..20).map { //itemlar selectedlerı degısecegı için bu kısmı state yapmalıyız.
                        ListItem(
                            title = "Item $it",
                            isSelected = false
                        )
                    }
                    )
                }
                items.filter {
                    it.isSelected
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items.size) { i ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    items = items.mapIndexed { j, item ->
                                        if (i == j) {
                                            item.copy(isSelected = !item.isSelected)
                                        } else {
                                            item
                                        }

                                    }
                                }
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(text = items[i].title)
                            if (items[i].isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Selected",
                                    tint = Color.Green,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

