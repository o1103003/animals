package com.example.abc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.abc.ui.theme.AbcTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current

    val link = "https://rr5---sn-n4v7snly.googlevideo.com/videoplayback?expire=1682513822&ei=PctIZOCVPJT5zLUPv_yQ4A0&ip=198.199.101.47&id=o-ANNjngmY5x7w9L2tdTmWqWj755pp_-dUobGlT5n1BN1z&itag=18&source=youtube&requiressl=yes&mh=Qv&mm=31,29&mn=sn-n4v7snly,sn-o097znzk&ms=au,rdu&mv=m&mvi=5&pl=24&pcm2=yes&initcwndbps=133750&spc=qEK7B3pnk2DYtWM9oAL7yb1gq9_69AyCc2B-wM1fIA&vprv=1&mime=video/mp4&ns=JxkRZVviSrZd62sfCDN3RH8N&cnr=14&ratebypass=yes&dur=165.395&lmt=1666334755542655&mt=1682491742&fvip=3&fexp=24007246&beids=24512779&c=WEB_EMBEDDED_PLAYER&txp=1310224&n=nCXRWSUPMkxb502z8&sparams=expire,ei,ip,id,itag,source,requiressl,pcm2,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&sig=AOq0QJ8wRAIgDnmCkcQHHiZB-MMZrfat5pXKAy2aUFrWN5j0ahv_AWgCIDqE-5zHDbhxeTtq5zOiqi79OuORryQ2PWPlIXhF6HsB&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRQIhAMuFOVsOX1EZAhlC29BgFiGyWRISIcd_AkSxi0D6IwGDAiA4nFuQB_v6jaoNI6ZuPwnj30OaI6Is5aa7893m0TqsWA==&title=Bali,%20Indonesia%20(Travel%20Video)"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AbcTheme {
        Greeting2("Android")
    }
}