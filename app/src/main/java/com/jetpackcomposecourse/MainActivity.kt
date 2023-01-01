package com.jetpackcomposecourse

import android.Manifest.permission.RECORD_AUDIO
import android.annotation.SuppressLint
import android.app.appsearch.StorageInfo
import android.content.ClipDescription
import android.graphics.Paint
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.AdapterView.OnItemClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.*
import com.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.lang.Math.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Jetpack Default design
         JetpackComposeCourseTheme {
              // A surface container using the 'background' color from the theme
              Surface(
                  modifier = Modifier.fillMaxSize(),
                  color = MaterialTheme.colors.background
              ) {
                  Greeting("Android")
              }
          }*/

            /* Row and Column Compose Design
            Column(Modifier.height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {
                Text("Hello")
                Text("Android")
                Text("Hello")
            }*/
            //----Compose Modifiers----
            /*Column(Modifier.background(color = Color.Yellow)
                .height(200.dp)
                .fillMaxWidth()
                .padding(15.dp)
                .border(1.dp, Color.Green)) {
                Text("Hello")
                Spacer(Modifier.height(50.dp))
                Text("Android", modifier = Modifier.clickable {

                })
                Text("Hello")
            }*/
            //--------Compose Image Card-----
            /*val painter = painterResource(R.drawable.kuldeep_pic)
            val description = "Kuldeep Nimawat"
            val title="Kuldeep Nimawat"
            Box(modifier = Modifier.fillMaxWidth(0.6f)
                .fillMaxHeight(0.5f)
                .padding(20.dp)){
                ImageCard(painter, description, title)
            }*/
            //-----Styling Text-------
            /*val fontFamily = FontFamily(
                Font(R.font.ptsans_regular, weight = FontWeight.Thin),
                Font(R.font.ptsans_bold, weight = FontWeight.Bold),
                Font(R.font.ptsans_bolditalic, weight = FontWeight.SemiBold),
                Font(R.font.ptsans_italic, weight = FontWeight.Light)
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 35.sp
                            )
                        ){
                            append("J")
                        }
                        append("etpack")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 35.sp
                            )
                        ){
                            append("C")
                        }
                        append("ompose")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )

            }*/
            //--------State Jetpack Compose-----
            /*Column {
                val color = remember { mutableStateOf(Color.Yellow) }
                ColorBox(Modifier.weight(1f).fillMaxSize()){
                    color.value = it
                }
                Box(Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
            }*/
            //------text field, button, snackbar-------------
            /*val scaffoldState = rememberScaffoldState()
            var textFiledState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold(modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                        .padding(30.dp)) {
                       TextField(
                           value = textFiledState,
                           label = {
                               Text("Enter user name")
                            },
                           onValueChange = {
                               textFiledState = it
                           },
                           singleLine = true,
                           modifier = Modifier.fillMaxWidth()
                       )

                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFiledState")
                            }
                        }){
                            Text("Click Here")
                        }
                    }
            }*/
            //--------List-----------
            /*var scrollState = rememberScrollState()
            Column(
                modifier = Modifier.fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {

                for (i in 0..200) {
                    Text(
                        "Item $i",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )
                }*/
            /*  LazyColumn {

                  *//*items(5000){
                        Text(
                            "Item $it",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                                .padding(vertical = 10.dp)
                        )
                    }*//*

                    itemsIndexed(
                        listOf("a","b","c","d","e")
                    ){index, string ->
                        Text(
                            text = string,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                                .padding(vertical = 10.dp)
                        )
                    }
            }*/
            //---------constraint layout-------
            /*val constraints = ConstraintSet{
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
               // val guideline = createGuidelineFromTop(0.5f)
                constrain(greenBox){
                    //top.linkTo(guideline)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(50.dp)
                }
                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(50.dp)
                }
                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()
                    .background(Color.Green)
                    .layoutId("greenBox")
                )
                Box(modifier = Modifier.fillMaxWidth()
                    .background(Color.Red)
                    .layoutId("redBox")
                )
            }*/
            //-------handler effect-----
            /* var i = 0
             var text by remember {
                 mutableStateOf("")
             }*/
            // Button(onClick = {text += "#"}){
            //     i++
            //     Text(text = text, modifier = Modifier.fillMaxWidth(0.5f),
            //     color = Color.Black)
            // }
            /*LaunchedEffect(key1 = text){
                delay(1000L)
                println("Hello World!")
                //rememberCoroutineEffect
                //DisposableEffect
            }*/
            //--------Animation-----
            /* var sizeState by remember { mutableStateOf(200.dp) }
             val size by animateDpAsState(
                targetValue = sizeState,
                 *//*tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )*//*
            *//*spring(
                Spring.StiffnessMediumLow
            )*//*
            keyframes {
                durationMillis = 5000
                sizeState at 0 with LinearEasing
                sizeState * 1.0f at 2000 with FastOutLinearInEasing
                sizeState * 1.5f at 1500
            }
            )
            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Blue,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Box(modifier = Modifier.size(size)
                .background(color),
            contentAlignment = Alignment.Center){
             Button(onClick = {
                     sizeState += 50.dp
             }){
                 Text("Increase Size")
             }
            }*/
            //---------circular progressbar----
            /*Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){
              CircularProgressBar(percentage = 0.8f, number = 100)
            }*/
            //----timer------
            /*Surface(
                color = Color.Black,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Timer(
                       totalTime = 100L *1000L,
                        handleColor = Color.Green,
                        inactiveColor = Color.DarkGray,
                        activeColor = Color(0xFF37B900),
                        modifier = Modifier.size(200.dp)
                    )
                }

            }*/

            //----------3D Drop Down-------
            /* Surface(
                 color = Color.Black,
                 modifier = Modifier.fillMaxSize()
             ) {
                DropDown(
                    text = "Hello World",
                    modifier = Modifier.padding(15.dp),
                ){
                    Text("This is now revealed!",
                    modifier = Modifier.fillMaxWidth()
                        .height(70.dp)
                        .background(Color.Green)
                    )
                }
             }*/

            //--------Composal with ViewModel--------
            //UpdateScreenUIUsingByViewModel()

            //-------------
            //HelloWorld()
            //-------Navigation oneActivity to another activity----
            //Navigation()
            //-------Animated Splash Screen----
            //Navigation()
            //-----Bottom Navigation with Badges--------
           /* val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(listOf(
                        BottomNavItem(
                            name = "Home",
                            route = "home",
                            icon = Icons.Default.Home,
                            badgeCount = 200
                        ),
                        BottomNavItem(
                            name = "Chat",
                            route = "chat",
                            icon = Icons.Default.Notifications,
                            badgeCount = 205
                        ),
                        BottomNavItem(
                            name = "Setting",
                            route = "setting",
                            icon = Icons.Default.Settings,
                            badgeCount = 150
                        )
                    ),
                        navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        })
                }
            ) {
                NavigationWithBadegs(navController)
            }*/

            //-------------Multi-Layer Parallax Scroll Effect--------

            /*val moonScrollSpeed = 0.08f
            val midBgScrollSpeed = 0.03f
            var moonOffset by remember {
                mutableStateOf(0f)
            }
            var midBgOffset by remember {
                mutableStateOf(0f)
            }

            val imageHeight = (LocalConfiguration.current.screenWidthDp * (2f/3f)).dp
            val lazyListState = rememberLazyListState()

            val nestedScrollConnection = object : NestedScrollConnection{
                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    val delta = available.y
                    val layoutInfo = lazyListState.layoutInfo
                    //---to check list first item is visible ----
                    if(lazyListState.firstVisibleItemIndex == 0){
                        return Offset.Zero
                    }
                    if(layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1){
                        return Offset.Zero
                    }
                    moonOffset += delta * moonScrollSpeed
                    midBgOffset += delta * midBgScrollSpeed
                    return Offset.Zero
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
                    .nestedScroll(nestedScrollConnection),
                state = lazyListState
            ) {
               items(10){
                   Text(text = "Sample Text",
                   modifier = Modifier.fillMaxWidth()
                       .padding(16.dp))
               }

                item {
                    Box(modifier = Modifier.clipToBounds()
                        .fillMaxWidth()
                        .height(imageHeight)
                        .background(
                            Brush.verticalGradient(listOf(
                                Color(0xFFf36b21),
                                Color(0xFFf36b21)
                            ))
                        )
                    ){
                       Image(painter = painterResource(id = R.drawable.ocean),
                       contentDescription = "moon",
                       contentScale = ContentScale.FillWidth,
                       alignment = Alignment.BottomCenter,
                       modifier = Modifier.matchParentSize()
                           .graphicsLayer {
                               translationY = midBgOffset
                           })

                        Image(painter = painterResource(id = R.drawable.sun),
                            contentDescription = "mid bg",
                            contentScale = ContentScale.FillWidth,
                            alignment = Alignment.TopCenter,
                            modifier = Modifier.matchParentSize())

                        Image(painter = painterResource(id = R.drawable.mountain1),
                            contentDescription = "outer bg",
                            contentScale = ContentScale.FillWidth,
                            alignment = Alignment.BottomCenter,
                            modifier = Modifier.matchParentSize())
                    }
                }

                items(15){
                    Text(text = "Sample Text",
                        modifier = Modifier.fillMaxWidth()
                            .padding(16.dp))
                }
            }*/
           //-------------multi-select lazy column---------
             /*var items by remember {
                 mutableStateOf(
                     (1..20).map {
                     ListItems(
                         title = "item $it",
                         isBoolean = false
                     )
                 }
                 )
             }
            //items.filter { it.isBoolean }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                  items(items.size){ i ->
                      Row(modifier = Modifier.fillMaxWidth()
                          .clickable {
                           items = items.mapIndexed { j, item ->
                               if(i==j){
                                  item.copy(isBoolean = !item.isBoolean)
                               }else item
                           }
                          }
                          .padding(16.dp),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically){
                        Text(text = items[i].title)
                          if(items[i].isBoolean){
                              Icon(imageVector = Icons.Default.Check,
                                  contentDescription = "Selected",
                              tint = Color.Green,
                              modifier = Modifier.size(20.dp))
                          }
                      }
                  }
            }*/

            //--------Permissions Handling------------
            val permissionState = rememberMultiplePermissionsState(
                permissions = listOf(
                    android.Manifest.permission.CAMERA,
                    RECORD_AUDIO,
                )
            )

            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(
                key1 = lifecycleOwner,
                effect = {
                       val observer = LifecycleEventObserver{_,event ->
                           if(event == Lifecycle.Event.ON_START){
                               permissionState.launchMultiplePermissionRequest()
                           }
                       }
                    lifecycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                }
            )

            Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
                permissionState.permissions.forEach { perm ->
                    when(perm.permission){
                      android.Manifest.permission.CAMERA ->{
                          when {
                              perm.status.isGranted ->{
                                  Text("Camera permission is accepted")
                              }
                              perm.status.shouldShowRationale ->{
                                  Text("Camera permission is required to access Camera features")
                              }
                              !perm.status.isGranted && !perm.status.shouldShowRationale ->{
                                  Text("Camera permission is denied permanently")
                              }
                          }
                      }
                        RECORD_AUDIO ->{
                            when {
                                perm.status.isGranted ->{
                                    Text("Record audio permission is accepted")
                                }
                                perm.status.shouldShowRationale ->{
                                    Text("Record audio permission is required to access Camera features")
                                }
                                !perm.status.isGranted && !perm.status.shouldShowRationale ->{
                                    Text("Record audio permission is denied permanently")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/*@Composable
fun NavigationWithBadegs(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("setting") {
            SettingScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    var backStackState = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackState.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if (selected) {
                            Text(
                                item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }else{
                            Text(
                                item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Chat Screen")
    }
}

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Setting Screen")
    }
}*/

/*@Preview
@Composable
fun HelloWorld(){
Box{
Row {
Surface(modifier = Modifier
    .padding(2.dp)) {
    Image(painter = painterResource( R.drawable.kuldeep_pic),
        contentDescription = null,
        modifier = Modifier.width(50.dp)
            .height(50.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = MaterialTheme.colors.secondary, CircleShape),
        contentScale = ContentScale.Fit
    )
}

Spacer(modifier = Modifier.width(8.dp))
Column{
    Text("Hello World!")
    Text("Hey Ram")
}
}
}
}*/

/*
@Composable
fun UpdateScreenUIUsingByViewModel(
modifier: Modifier = Modifier,
viewModel: MyViewModel = MyViewModel()
){
val state = viewModel.state.value
Column(
modifier = modifier,
horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.SpaceBetween
) {
Text("Counter : ${state.counter}")
Text("Button Number : ${state.buttonNumber}")
}
Column(modifier = modifier.fillMaxWidth(),
horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.spacedBy(16.dp)) {

Button(onClick = {
viewModel.onEvent(MyViewModel.UIEvent.IncrementCounter)
}){
Text("Increment Counter")
}

Row(modifier= modifier.fillMaxWidth(),
verticalAlignment = Alignment.CenterVertically,
horizontalArrangement = Arrangement.Center){
Button(onClick = {
    viewModel.onEvent(MyViewModel.UIEvent.ChooseButton(1))
}){
    Text("Button 1")
}

Spacer(modifier = modifier.width(8.dp))
Button(onClick = {
    viewModel.onEvent(MyViewModel.UIEvent.ChooseButton(2))
}){
    Text("Button 2")
}

}

}
}
*/

/*@Composable
fun DropDown(
text : String,
modifier: Modifier,
initialyOpened : Boolean = false,
content : @Composable -> Unit
){
var isOpen by remember {
mutableStateOf(initialyOpened)
}
var alpha = animateFloatAsState(
targetValue = if(isOpen) 1f else 0f,
    animationSpec = tween(
    durationMillis = 300
    )
)
val rotatX = animateFloatAsState(
targetValue = if(isOpen) 0f else -90f,
animationSpec = tween(
durationMillis = 300
)
)
Column(modifier = modifier
.fillMaxWidth()
) {
Row(
horizontalArrangement = Arrangement.SpaceBetween,
verticalAlignment = Alignment.CenterVertically,
modifier =modifier
.fillMaxWidth()
) {
Text(
    text =text,
    color = Color.White,
    fontSize = 25.sp
)
Icon(
  imageVector= Icons.Default.ArrowDropDown,
   contentDescription = "Open or Close the drop down",
   tint = Color.White,
   modifier = Modifier.clickable {
       isOpen = !isOpen
   }
       .scale(1f,if(isOpen) 1f else 1f)
)
}
Spacer(modifier = Modifier.height(10.dp))
Box(
contentAlignment = Alignment.Center,
modifier = Modifier.fillMaxWidth()
    .graphicsLayer {
        transformOrigin = TransformOrigin(0.5f, 0f)
        rotationX = rotatX.value
    }
    .alpha(alpha.value)
){
content()
}
}
}*/

/*@Composable
fun Timer(
totalTime : Long,
handleColor : Color,
inactiveColor : Color,
activeColor : Color,
modifier : Modifier,
initalValue : Float = 1f,
strokeWidth : Dp = 5.dp
){
var size by remember {
mutableStateOf(IntSize.Zero)
}
var value by remember {
mutableStateOf(initalValue)
}
var currentTime by remember {
mutableStateOf(totalTime)
}
var isTimerRunning by remember {
mutableStateOf(false)
}
LaunchedEffect(
key1 = currentTime, key2 = isTimerRunning
){
if(currentTime > 0 && isTimerRunning){
  delay(100L)
  currentTime -= 100L
  value = currentTime / totalTime.toFloat()
}
}
Box (
contentAlignment = Alignment.Center,
modifier = modifier.onSizeChanged {
size = it
}
){
Canvas(modifier = modifier){
  drawArc(
      color = inactiveColor,
      startAngle = -215f,
      sweepAngle = 250f,
      useCenter = false,
      size = Size(size.width.toFloat(), size.height.toFloat()),
      style = Stroke(strokeWidth.toPx(),
      cap = StrokeCap.Round)
  )
  drawArc(
      color = activeColor,
      startAngle = -215f,
      sweepAngle = 250f * value,
      useCenter = false,
      size = Size(size.width.toFloat(), size.height.toFloat()),
      style = Stroke(strokeWidth.toPx(),
          cap = StrokeCap.Round)
  )
  val center = Offset(size.width/2f, size.height/2f)
  val beta = (250f * value + 145f) * (PI / 180f).toFloat()
  val radius = size.width/2f
  val a = cos(beta) * radius
  val b = sin(beta) * radius
  drawPoints(
      listOf(Offset(center.x+a,  center.y+b)),
      pointMode = PointMode.Points,
      color = handleColor,
      strokeWidth= (strokeWidth * 3f).toPx(),
      cap = StrokeCap.Round
  )
}
Text(
text = (currentTime / 1000L).toString(),
fontSize = 44.sp,
fontWeight = FontWeight.Bold,
color = Color.Red
)
Button(
onClick = {
      if(currentTime <= 0L){
          currentTime = totalTime
          isTimerRunning = true
      }else{
          isTimerRunning = !isTimerRunning
      }
},
modifier = Modifier.align(Alignment.BottomCenter),
colors = ButtonDefaults.buttonColors(
    backgroundColor = if(!isTimerRunning || currentTime <= 0L){
        Color.Green
    }else{
        Color.Red
    }
)
){
Text(text = if(isTimerRunning && currentTime >=0L ) "Stop"
    else if(!isTimerRunning && currentTime >=0L) "Start"
    else "Restart"
)
}
}
}*/

/*@Composable
fun CircularProgressBar(
percentage : Float,
number : Int,
fontSize: TextUnit = 20.sp,
radius: Dp = 50.dp,
color: Color = Color.Green,
strokeWidth : Dp = 8.dp,
animationDuration : Int=1000,
animationDelay: Int = 0
){
var animationPlayed by remember {
mutableStateOf(false)
}
var curPercentage = animateFloatAsState(
targetValue = if(animationPlayed) percentage else 0f,
animationSpec = tween(
durationMillis = animationDuration,
delayMillis = animationDelay
)
)
LaunchedEffect(key1=true){
animationPlayed = true
}

Box(
contentAlignment = Alignment.Center,
modifier = Modifier.size(radius * 2f)
) {
Canvas(modifier = Modifier.size(radius *2f)){
drawArc(
  color =color,
  90f,
  360 *curPercentage.value,
  useCenter = false,
  style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
)
}
Text(
text = (curPercentage.value * number).toInt().toString(),
color = Color.Blue,
fontSize = fontSize,
fontWeight = FontWeight.Bold
)
}
}*/

/*@Composable
fun ColorBox(modifier: Modifier = Modifier,
updatedColor : (Color) ->Unit ){
Box(
modifier = modifier.background(
Color.Red
)
.clickable {
    updatedColor(
        Color(
            Random.nextFloat(),
            Random.nextFloat(),
            Random.nextFloat(),
            1f
        )
    )
}
)
}*/

/*@Composable
fun ImageCard(
painter: Painter,
contentDescription: String,
title: String,
modifier: Modifier = Modifier
) {
Card(
modifier = modifier.fillMaxWidth(0.3f),
shape = RoundedCornerShape(10.dp),
elevation = 5.dp
)
{
Box(modifier = Modifier.height(80.dp)) {
Image(
    painter, contentDescription,
    contentScale = ContentScale.Crop
)
Box(
    modifier = Modifier.fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black
                )
            )
        )
)
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomStart
) {
    Text(title, style = TextStyle(Color.Black, fontSize = 14.sp))
}
}
}
}*/

/*
@Composable
fun Greeting(name: String) {
Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
JetpackComposeCourseTheme {
Greeting("Android")
}
}*/
