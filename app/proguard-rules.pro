# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#################Basic rules############################
 # Code obfuscation compression ratio, between 0 and 7, default to 5, generally do not modify
 -optimizationpasses 5

 # No case mixing is used when mixing. The class after mixing is called lowercase.
 -dontusemixedcaseclassnames

 # Specify classes that do not ignore non-public Libraries
 -dontskipnonpubliclibraryclasses

 # This sentence can confuse our project and produce mapping files
 # Mapping Relations Containing Class Names - > Confused Post-Class Names
 -verbose

 # Specify class members that do not ignore non-public Libraries
 -dontskipnonpubliclibraryclassmembers

 # Without prevalidation, prevalidation is one of the four steps of proguard. Android does not need prevalidation. Removing this step can speed up confusion.
 -dontpreverify

 # Retain Annotation without confusion
 -keepattributes *Annotation*,InnerClasses

 # Avoid confusing generics
 -keepattributes Signature

 # Keep line numbers when throwing exceptions
 -keepattributes SourceFile,LineNumberTable

 # Specifies that obfuscation is the algorithm used, and the latter parameter is a filter
 # This filter is Google's recommended algorithm, usually unchanged
 -optimizations !code/simplification/cast,!field/*,!class/merging/*


 #############################################
 #
 # Some common parts of Android development that need to be preserved
 #
 #############################################

 # Keep the four components we use, custom applications, and so on unobfuscated
 # Because these subclasses are likely to be called externally
 -keep public class * extends android.app.Activity
 -keep public class * extends android.app.Appliction
 -keep public class * extends android.app.Service
 -keep public class * extends android.content.BroadcastReceiver
 -keep public class * extends android.content.ContentProvider
 -keep public class * extends android.app.backup.BackupAgentHelper
 -keep public class * extends android.preference.Preference
 -keep public class * extends android.view.View
 -keep public class com.android.vending.licensing.ILicensingService


 # Keep all classes under support and their internal classes
 -keep class android.support.** {*;}
 -dontwarn javax.annotation.**

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

 # Reserved inheritance
 -keep public class * extends android.support.v4.**
 -keep public class * extends android.support.v7.**
 -keep public class * extends android.support.annotation.**

 # Reserve the resources under R
 -keep class **.R$* {*;}



 # Keep local native methods unambiguous
 -keepclasseswithmembernames class * {
     native <methods>;
 }

 # The method parameter retained in Activity is the method of view.
 # So the onClick we wrote in the layout won't be affected.
 -keepclassmembers class * extends android.app.Activity{
     public void *(android.view.View);
 }

 # Keep enumeration classes unambiguous
 -keepclassmembers enum * {
     public static **[] values();
     public static ** valueOf(java.lang.String);
 }

 # Keep our custom controls (inherited from View) unambiguous
 -keep public class * extends android.view.View{
     *** get*();
     void set*(***);
     public <init>(android.content.Context);
     public <init>(android.content.Context, android.util.AttributeSet);
     public <init>(android.content.Context, android.util.AttributeSet, int);
 }

 # Keep Parcelable serialized classes unambiguous
 -keep class * implements android.os.Parcelable {
     public static final android.os.Parcelable$Creator *;
 }

 # Keep Serializable serialized classes unambiguous
 -keepclassmembers class * implements java.io.Serializable {
     static final long serialVersionUID;
     private static final java.io.ObjectStreamField[] serialPersistentFields;
     !static !transient <fields>;
     !private <fields>;
     !private <methods>;
     private void writeObject(java.io.ObjectOutputStream);
     private void readObject(java.io.ObjectInputStream);
     java.lang.Object writeReplace();
     java.lang.Object readResolve();
 }

 # For onXXEvent,** On*Listener with callback function, it should not be confused
 -keepclassmembers class * {
     void *(**On*Event);
     void *(**On*Listener);
 }

 # webView Processing, the project does not use webView ignorance can be
 -keepclassmembers class fqcn.of.javascript.interface.for.webview {
     public *;
 }
 -keepclassmembers class * extends android.webkit.webViewClient {
     public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
     public boolean *(android.webkit.WebView, java.lang.String);
 }
 -keepclassmembers class * extends android.webkit.webViewClient {
     public void *(android.webkit.webView, jav.lang.String);
 }
 #Do not confuse resource classes
 -keepclassmembers class **.R$* {
     public static <fields>;
 }

 #--------------In-Project Processing----------------
 #model
 -keep class com.intbuller.taohua.**{*;}


 -dontwarn javax.inject.**

 #okhttp
 -dontwarn okhttp3.**
 -dontwarn okio.**
 -keepnames class okhttp3.internal.publicsuffix.publicSuffixDatabase
 -dontwarn okhttp3.logging.**
 -keep class okhttp3.internal.**{*;}

 -dontwarn org.codehaus.**
 -dontwarn java.nio.**
 -dontwarn java.lang.invoke.**
 -dontwarn rx.**

 #Retrofit
 -dontwarn okio.**
 -dontwarn retrofit2.Platform
 -dontnote retrofit2.Platform$IOS$MainThreadExecutor
 -dontwarn retrofit2.Platform$java8
 -keepattributes Signature
 -keepattributes Exceptions

 #Rxjava RxAndroid
 -dontwarn rx.*
 -dontwarn sun.misc.**
 -keepclassmembers class rx.internal.util.unsafe.*ArrayQuene*Field*{
 long producerIndex;
 long consumerIndex;
 }

 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
 }

 # RxLifeCycle2
 -keep class com.trello.rxlifecycle2.** { *; }
  -keep interface com.trello.rxlifecycle2.** { *; }
  -dontwarn com.trello.rxlifecycle2.**

 #Gson
 -keep class com.google.gson.stream.**{*;}
 -keepattributes EnclosingMethod


 -keepclassmembers class * {
     public void *ButtonClicked(android.view.View);
 }

 -keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }

 -keepclasseswithmembernames class * {
     @butterknife.* <fields>;
 }

 -keepclasseswithmembernames class * {
     @butterknife.* <methods>;
 }

 # glide Obfuscation code
# -keep public class * implements com.bumptech.glide.module.GlideModule
# -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
#   **[] $VALUES;
#   public *;
# }


-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep class com.bumptech.glide.GeneratedAppGlideModuleImpl { *; }
#wechar
#-libraryjars libs/libammsdk.jar
-keep class com.tencent.** { *;}
-keep class com.tencent.wxop.** {
   *;
}
-keep class com.tencent.mm.sdk.** {
   *;
}
-keep class com.tencent.mm.opensdk.** {
   *;
}
