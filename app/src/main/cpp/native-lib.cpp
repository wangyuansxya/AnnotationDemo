#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_wangyuan_myopensourcelibrary_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jint
JNICALL
Java_com_wangyuan_myopensourcelibrary_MainActivity_getIntFromJni(JNIEnv *env, jobject) {
    int x = 6;
    return x;

}
