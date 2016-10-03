## Description
This project is an example to launch the TreasureHunt (GVR SDK Sample) from the CastleDefense (Unity GVR Sample) run on GVR7.1

This project was initiailly created to ask a question to Google team. Since the problem has been solved, I will include the working version for others.


## Environment
- Unity IDE version : GVR 7.1
- Android GVR version 1.0.0

## Setup

## From Android Studio
Github source: https://github.com/jclova/TreasureHuntAsLibrary

To call TreasureHunt app from the Unity, I copied [TreasureHunt](https://github.com/googlevr/gvr-android-sdk/tree/master/samples/sdk-treasurehunt) source code to an Android library with small changes:
- [ActivityLauncher.java](https://github.com/jclova/TreasureHuntAsLibrary/blob/master/treasurehuntlibrary/src/main/java/com/joshuapark/treasurehuntlibrary/ActivityLauncher.java) - contains static method to launch TreasureHunt activity or Empty (prints hello world) activity.
- [EmptyActivity.java](https://github.com/jclova/TreasureHuntAsLibrary/blob/master/treasurehuntlibrary/src/main/java/com/joshuapark/treasurehuntlibrary/EmptyActivity.java) - A simple Activity which displays 'hello world'.
- [EmptyActivityAppcompat.java](https://github.com/jclova/TreasureHuntAsLibrary/blob/master/treasurehuntlibrary/src/main/java/com/joshuapark/treasurehuntlibrary/EmptyActivityAppcompat.java) - A simple Activity (that extends AppCompatActivity) which displays 'hello world'.

Above project generates [treasurehuntlibrary-release.aar](https://github.com/jclova/TreasureHuntAsLibrary/blob/master/treasurehuntlibrary-release.aar)

## From Unity
Github source: https://github.com/jclova/CastleDefenseUnityTest

From the GVR Unity CastleDefense sample project, do following:
- Upgrade to GVR 7.1 (also Player Settings > Virtual Reality Supported > Cardboard is enabled)
- Include following files at Assets/Plugins/Android
       treasurehuntlibrary-release.aar
       appcompat-v7-24.2.1.aar (optional)
       appcompat-v7-24.2.1-sources.jar (optional)
       appcompat-v7-24.2.1-javadoc.jar (optional)
       audio_no_arm64-v8a.aar (optional) - This is from the audio.aar (version 1.0.0). However, I removed *.so files in the 'arm64-v8a' folder. (Else you get other '.so' files not found error).
- Modify AndroidManifest-Cardboard.xml - include additional Activities from the treasurehuntlibrary-release.aar.
- Modify [Assets/Game/Scripts/CannonBehaviour.cs](https://github.com/jclova/CastleDefenseUnityTest/blob/master/Assets/Game/Scripts/CannonBehaviour.cs) to launch another Activity when the surface is clicked:

```csharp
public void FireAtTarget(Vector3 at) {
       AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
       AndroidJavaObject ajo = jc.GetStatic<AndroidJavaObject>("currentActivity");
       AndroidJavaClass ajc = new AndroidJavaClass("com.joshuapark.treasurehuntlibrary.ActivityLauncher");

       // ajc.CallStatic("launchEmpty", ajo);
       // ajc.CallStatic("launchEmptyAppcompat", ajo);
       ajc.CallStatic("launchTreasureHunt", ajo);
}
```

## base.aar (version 1.0.0)
1. 'delete '*.so' files in the ''arm64-v8a' folder.
2. Remove '<uses-feature android:glEsVersion="0x00020000" android:required="true"/>' in the AndroidManifest.xml in 'base.aar'

## audio.aar (version 1.0.0)
1. 'delete '*.so' files in the ''arm64-v8a' folder.



